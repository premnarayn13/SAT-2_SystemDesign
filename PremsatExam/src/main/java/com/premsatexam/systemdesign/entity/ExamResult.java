package com.premsatexam.systemdesign.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="exam_results",uniqueConstraints=@UniqueConstraint(name="uk_candidate_exam",columnNames={"candidate_id","exam_id"}))
public class ExamResult {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(name="candidate_id",nullable=false) private Long candidateId;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="exam_id",nullable=false) private Exam exam;
 private int marksObtained,totalMarks; private String status; private LocalDateTime submittedAt;
 public ExamResult(){}
 public ExamResult(Long c,Exam e,int score,int total){candidateId=c;exam=e;marksObtained=score;totalMarks=total;status="COMPLETED";submittedAt=LocalDateTime.now();}
 public Long getId(){return id;} public Long getCandidateId(){return candidateId;} public Exam getExam(){return exam;}
 public int getMarksObtained(){return marksObtained;} public int getTotalMarks(){return totalMarks;}
 public String getStatus(){return status;} public LocalDateTime getSubmittedAt(){return submittedAt;}
}
