package model;

public class SubjectScore {

    private String subjectName;
    private double attendance;
    private double midterm;
    private double finalExam;

    public SubjectScore(String subjectName,
                        double attendance,
                        double midterm,
                        double finalExam) {
        this.subjectName = subjectName;
        this.attendance = attendance;
        this.midterm = midterm;
        this.finalExam = finalExam;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    public double getMidterm() {
        return midterm;
    }

    public void setMidterm(double midterm) {
        this.midterm = midterm;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    public double getTotal() {
        return attendance * 0.1
                + midterm * 0.3
                + finalExam * 0.6;
    }
}