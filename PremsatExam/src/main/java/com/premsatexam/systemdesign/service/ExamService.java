package com.premsatexam.systemdesign.service;
import com.premsatexam.systemdesign.dto.*; import com.premsatexam.systemdesign.entity.*;
import com.premsatexam.systemdesign.repository.*; import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException; import java.util.*;
@Service
public class ExamService {
 private final ExamRepository exams; private final QuestionRepository questions;
 private final CandidateAnswerRepository answers; private final ExamResultRepository results;
 public ExamService(ExamRepository e,QuestionRepository q,CandidateAnswerRepository a,ExamResultRepository r){exams=e;questions=q;answers=a;results=r;}
 @Transactional(readOnly=true) public ExamResponse getExam(Long id){Exam e=findExam(id);return new ExamResponse(e.getId(),e.getTitle(),e.getDurationMinutes(),e.isActive());}
 @Transactional(readOnly=true) public List<QuestionResponse> getQuestions(Long id){
  findExam(id); return questions.findByExam_IdOrderById(id).stream().map(q->new QuestionResponse(q.getId(),q.getQuestionText(),q.getOptionA(),q.getOptionB(),q.getOptionC(),q.getOptionD(),q.getMarks())).toList();
 }
 @Transactional public String saveAnswer(Long examId,AnswerRequest r){
  Exam exam=findExam(examId);
  if(results.findByCandidateIdAndExam_Id(r.getCandidateId(),examId).isPresent())throw new ResponseStatusException(HttpStatus.CONFLICT,"Exam already submitted");
  Question q=questions.findByIdAndExam_Id(r.getQuestionId(),examId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Question not found in this exam"));
  String option=r.getSelectedOption().trim().toUpperCase();
  if(!List.of("A","B","C","D").contains(option))throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Option must be A, B, C, or D");
  CandidateAnswer a=answers.findByCandidateIdAndQuestion_Id(r.getCandidateId(),q.getId()).orElseGet(()->new CandidateAnswer(r.getCandidateId(),exam,q,option));
  a.setSelectedOption(option);answers.save(a);return "Answer saved successfully";
 }
 @Transactional public ResultResponse submitExam(Long id,SubmitExamRequest r){
  Exam exam=findExam(id); ExamResult old=results.findByCandidateIdAndExam_Id(r.getCandidateId(),id).orElse(null);
  if(old!=null)return response(old);
  List<Question> qs=questions.findByExam_IdOrderById(id); List<CandidateAnswer> as=answers.findByCandidateIdAndExam_Id(r.getCandidateId(),id);
  int score=0; for(Question q:qs)for(CandidateAnswer a:as)if(a.getQuestion().getId().equals(q.getId())&&q.getCorrectOption().equalsIgnoreCase(a.getSelectedOption())){score+=q.getMarks();break;}
  int total=qs.stream().mapToInt(Question::getMarks).sum();return response(results.save(new ExamResult(r.getCandidateId(),exam,score,total)));
 }
 @Transactional(readOnly=true) public ResultResponse getResult(Long id,Long candidateId){
  findExam(id);return results.findByCandidateIdAndExam_Id(candidateId,id).map(this::response).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Submit exam before requesting result"));
 }
 private Exam findExam(Long id){return exams.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Exam not found"));}
 private ResultResponse response(ExamResult r){return new ResultResponse(r.getCandidateId(),r.getExam().getId(),r.getMarksObtained(),r.getTotalMarks(),r.getStatus(),r.getSubmittedAt());}
}
