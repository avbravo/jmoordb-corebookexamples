package fish.payara.domain;

import jakarta.persistence.*;

@NamedQueries({
    @NamedQuery(name = "Course.findByCourseCode", query = "SELECT e FROM Course e WHERE e.courseCode = :courseCode"),
    @NamedQuery(name = "Course.findByCourseName", query = "SELECT e FROM Course e WHERE e.courseName = :courseName"),
    @NamedQuery(name = "Course.findByCredits", query = "SELECT e FROM Course e WHERE e.credits = :credits")
})
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String courseCode;

    private String courseName;

    private Integer credits;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    // Getters and setters

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

}
