package fish.payara.domain;

import jakarta.persistence.*;
import java.util.List;
import jakarta.json.bind.annotation.JsonbTransient;

@NamedQueries({
    @NamedQuery(name = "Enrollment.findByEnrollmentID", query = "SELECT e FROM Enrollment e WHERE e.enrollmentID = :enrollmentID"),
    @NamedQuery(name = "Enrollment.findBySemester", query = "SELECT e FROM Enrollment e WHERE e.semester = :semester")
})
@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer enrollmentID;

    private String semester;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @JsonbTransient
    @OneToMany(mappedBy = "enrollment")
    private List<Course> courses;

    // Getters and setters

    public Integer getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(Integer enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
