package com.premsatexam.systemdesign.repository;
import com.premsatexam.systemdesign.entity.ExamResult; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface ExamResultRepository extends JpaRepository<ExamResult,Long>{
 Optional<ExamResult> findByCandidateIdAndExam_Id(Long candidateId,Long examId);
}
