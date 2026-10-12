package com.premsatexam.systemdesign.entity;
import jakarta.persistence.*;
@Entity @Table(name="questions")
public class Question {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="exam_id",nullable=false) private Exam exam;
 @Column(nullable=false,length=1000) private String questionText;
 private String optionA,optionB,optionC,optionD,correctOption; private int marks;
 public Question(){}
 public Question(Exam e,String text,String a,String b,String c,String d,String correct,int marks){
  exam=e;questionText=text;optionA=a;optionB=b;optionC=c;optionD=d;correctOption=correct;this.marks=marks;
 }
 public Long getId(){return id;} public Exam getExam(){return exam;} public String getQuestionText(){return questionText;}
 public String getOptionA(){return optionA;} public String getOptionB(){return optionB;} public String getOptionC(){return optionC;}
 public String getOptionD(){return optionD;} public String getCorrectOption(){return correctOption;} public int getMarks(){return marks;}
}
