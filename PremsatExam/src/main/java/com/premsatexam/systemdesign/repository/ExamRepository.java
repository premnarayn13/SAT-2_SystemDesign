package com.premsatexam.systemdesign.repository;
import com.premsatexam.systemdesign.entity.Exam; import org.springframework.data.jpa.repository.JpaRepository;
public interface ExamRepository extends JpaRepository<Exam,Long>{}
