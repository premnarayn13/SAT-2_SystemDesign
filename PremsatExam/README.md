# PremsatExam — Round 2
Spring Boot REST API for an Online Examination & Live Result Platform.

## Run on Windows
Requires internet for initial dependency downloads.
```powershell
.\mvnw.cmd clean test
.\mvnw.cmd spring-boot:run
```
Base URL: `http://localhost:8080`

## APIs
- GET `/api/exams/1` — exam details
- GET `/api/exams/1/questions` — questions without answer keys
- POST `/api/exams/1/answers` — save/update answer
- POST `/api/exams/1/submit` — submit and calculate result
- GET `/api/exams/1/result?candidateId=1001` — result

Answer request:
```json
{"candidateId":1001,"questionId":1,"selectedOption":"B"}
```
Submit request:
```json
{"candidateId":1001}
```
Uses an in-memory H2 database with three seeded sample questions. Data resets when the app restarts.
This is a demonstration project; production deployment needs real authentication and authorization.
