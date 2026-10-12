package com.premsatexam.systemdesign.dto;
import java.time.LocalDateTime;
public record ResultResponse(Long candidateId,Long examId,int marksObtained,int totalMarks,String status,LocalDateTime submittedAt){}
