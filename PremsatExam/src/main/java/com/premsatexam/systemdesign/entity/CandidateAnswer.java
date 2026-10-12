package com.premsatexam.systemdesign.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="candidate_answers",uniqueConstraints=@UniqueConstraint(name="uk_candidate_question",columnNames={"candidate_id","question_id"}))
public class CandidateAnswer {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(name="candidate_id",nullable=false) private Long candidateId;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="exam_id",nullable=false) private Exam exam;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="question_id",nullable=false) private Question question;
 @Column(nullable=false,length=1) private String selectedOption; private LocalDateTime updatedAt;
 public CandidateAnswer(){}
 public CandidateAnswer(Long c,Exam e,Question q,String o){candidateId=c;exam=e;question=q;selectedOption=o;}
 @PrePersist @PreUpdate public void timestamp(){updatedAt=LocalDateTime.now();}
 public Long getId(){return id;} public Long getCandidateId(){return candidateId;} public Exam getExam(){return exam;}
 public Question getQuestion(){return question;} public String getSelectedOption(){return selectedOption;}
 public void setSelectedOption(String o){selectedOption=o;}
}
