package com.premsatexam.systemdesign.config;
import com.premsatexam.systemdesign.entity.*; import com.premsatexam.systemdesign.repository.*;
import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.*;
@Configuration
public class DataInitializer {
 @Bean CommandLineRunner seed(ExamRepository exams,QuestionRepository questions){return args->{
  if(exams.count()==0){Exam e=exams.save(new Exam("Java Fundamentals",30,true));
   questions.save(new Question(e,"Which keyword creates a subclass?","this","extends","implements","super","B",1));
   questions.save(new Question(e,"Which collection stores unique elements?","ArrayList","LinkedList","HashSet","Vector","C",1));
   questions.save(new Question(e,"Which method is the Java program entry point?","start()","run()","main()","init()","C",1));
  }
 };}
}
