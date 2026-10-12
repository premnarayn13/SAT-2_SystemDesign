package com.premsatexam.systemdesign.dto;
import jakarta.validation.constraints.*;
public class AnswerRequest {
 @NotNull @Positive private Long candidateId;
 @NotNull @Positive private Long questionId;
 @NotBlank private String selectedOption;
 public Long getCandidateId(){return candidateId;} public void setCandidateId(Long v){candidateId=v;}
 public Long getQuestionId(){return questionId;} public void setQuestionId(Long v){questionId=v;}
 public String getSelectedOption(){return selectedOption;} public void setSelectedOption(String v){selectedOption=v;}
}
