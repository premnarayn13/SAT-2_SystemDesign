package com.premsatexam.systemdesign.controller;
import com.premsatexam.systemdesign.dto.*; import com.premsatexam.systemdesign.service.ExamService;
import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/exams")
public class ExamController {
 private final ExamService service; public ExamController(ExamService s){service=s;}
 @GetMapping("/{examId}") public ExamResponse getExam(@PathVariable Long examId){return service.getExam(examId);}
 @GetMapping("/{examId}/questions") public List<QuestionResponse> getQuestions(@PathVariable Long examId){return service.getQuestions(examId);}
 @PostMapping("/{examId}/answers") public ResponseEntity<Map<String,String>> saveAnswer(@PathVariable Long examId,@Valid @RequestBody AnswerRequest r){
  return ResponseEntity.ok(Map.of("message",service.saveAnswer(examId,r),"status","SAVED"));
 }
 @PostMapping("/{examId}/submit") public ResponseEntity<ResultResponse> submit(@PathVariable Long examId,@Valid @RequestBody SubmitExamRequest r){
  return ResponseEntity.status(HttpStatus.CREATED).body(service.submitExam(examId,r));
 }
 @GetMapping("/{examId}/result") public ResultResponse result(@PathVariable Long examId,@RequestParam Long candidateId){return service.getResult(examId,candidateId);}
}
