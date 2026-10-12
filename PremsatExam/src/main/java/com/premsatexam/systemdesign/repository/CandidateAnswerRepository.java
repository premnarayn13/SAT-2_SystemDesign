package com.premsatexam.systemdesign.repository;
import com.premsatexam.systemdesign.entity.CandidateAnswer; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface CandidateAnswerRepository extends JpaRepository<CandidateAnswer,Long>{
 Optional<CandidateAnswer> findByCandidateIdAndQuestion_Id(Long candidateId,Long questionId);
 List<CandidateAnswer> findByCandidateIdAndExam_Id(Long candidateId,Long examId);
}
