package com.premsatexam.systemdesign.dto;
import jakarta.validation.constraints.*;
public class SubmitExamRequest {
 @NotNull @Positive private Long candidateId;
 public Long getCandidateId(){return candidateId;} public void setCandidateId(Long v){candidateId=v;}
}
