package com.premsatexam.systemdesign.repository;
import com.premsatexam.systemdesign.entity.Question; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface QuestionRepository extends JpaRepository<Question,Long>{
 List<Question> findByExam_IdOrderById(Long examId);
 Optional<Question> findByIdAndExam_Id(Long questionId,Long examId);
}
