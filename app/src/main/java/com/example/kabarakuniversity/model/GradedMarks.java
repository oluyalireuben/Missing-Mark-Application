package com.example.kabarakuniversity.model;

public class GradedMarks {
    private String RegNo;
    private String StudentName;
    private String UnitName;
    private String UnitCode;
    private String Stage;
    private String LecturerName;
    private String ExaminationSemester;
    private String ExamYear;
    private String ExamType;
    private String StudentComment;
    private String Marks;
    private String LecturerComment;


    public GradedMarks(){
    }
    public GradedMarks(String regNo, String studentName, String unitName, String unitCode, String stage, String lecturerName,
                       String examinationSemester, String examYear, String examType, String studentComment,
                       String marks,String lecturerComment) {
        RegNo = regNo;
        StudentName = studentName;
        UnitName = unitName;
        UnitCode = unitCode;
        Stage = stage;
        LecturerName = lecturerName;
        ExaminationSemester = examinationSemester;
        ExamYear = examYear;
        ExamType = examType;
        StudentComment = studentComment;
        Marks = marks;
        LecturerComment = lecturerComment;
    }
    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String regNo) {
        RegNo = regNo;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public String getUnitCode() {
        return UnitCode;
    }

    public void setUnitCode(String unitCode) {
        UnitCode = unitCode;
    }

    public String getStage() {
        return Stage;
    }

    public void setStage(String stage) {
        Stage = stage;
    }

    public String getLecturerName() {
        return LecturerName;
    }

    public void setLecturerName(String lecturerName) {
        LecturerName = lecturerName;
    }

    public String getExaminationSemester() {
        return ExaminationSemester;
    }

    public void setExaminationSemester(String examinationSemester) {
        ExaminationSemester = examinationSemester;
    }

    public String getExamYear() {
        return ExamYear;
    }

    public void setExamYear(String examYear) {
        ExamYear = examYear;
    }

    public String getExamType() {
        return ExamType;
    }

    public void setExamType(String examType) {
        ExamType = examType;
    }

    public String getStudentComment() {
        return StudentComment;
    }

    public void setStudentComment(String studentComment) {
        StudentComment = studentComment;
    }
    public String getMarks() {
        return Marks;
    }

    public void setMarks(String marks) {
        Marks = marks;
    }

    public String getLecturerComment() {
        return LecturerComment;
    }

    public void setLecturerComment(String lecturerComment) {
        LecturerComment = lecturerComment;
    }
}
