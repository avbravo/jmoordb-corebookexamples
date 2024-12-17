package fish.payara.domain;

import jakarta.persistence.*;
import java.util.List;
import jakarta.json.bind.annotation.JsonbTransient;

@NamedQueries({
    @NamedQuery(name = "Teacher.findByTeacherID", query = "SELECT e FROM Teacher e WHERE e.teacherID = :teacherID"),
    @NamedQuery(name = "Teacher.findByName", query = "SELECT e FROM Teacher e WHERE e.name = :name"),
    @NamedQuery(name = "Teacher.findBySpecialization", query = "SELECT e FROM Teacher e WHERE e.specialization = :specialization")
})
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String teacherID;

    private String name;

    private String specialization;

    @JsonbTransient
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

    // Getters and setters

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
