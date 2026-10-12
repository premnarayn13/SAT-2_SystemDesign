package com.premsatexam.systemdesign.entity;
import jakarta.persistence.*;
@Entity @Table(name="exams")
public class Exam {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String title;
 private int durationMinutes; private boolean active=true;
 public Exam() {}
 public Exam(String title,int durationMinutes,boolean active){this.title=title;this.durationMinutes=durationMinutes;this.active=active;}
 public Long getId(){return id;} public String getTitle(){return title;}
 public int getDurationMinutes(){return durationMinutes;} public boolean isActive(){return active;}
}
