package model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String studentId;
    private String fullName;
    private List<SubjectScore> scores;

    public Student(String studentId, String fullName) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.scores = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<SubjectScore> getScores() {
        return scores;
    }

    public void setScores(List<SubjectScore> scores) {
        this.scores = scores;
    }

    public void addScore(SubjectScore score) {
        scores.add(score);
    }
}