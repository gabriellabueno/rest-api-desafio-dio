package restapi.dio.myapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Subject {

    @Id
    private String subjectId;
    private String subjectName;
    private String subjectProfessor;
    private int subjectSemester;

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectProfessor() {
        return subjectProfessor;
    }

    public void setSubjectProfessor(String subjectProfessor) {
        this.subjectProfessor = subjectProfessor;
    }

    public int getSubjectSemester() {
        return subjectSemester;
    }

    public void setSubjectSemester(int subjectSemester) {
        this.subjectSemester = subjectSemester;
    }
}
