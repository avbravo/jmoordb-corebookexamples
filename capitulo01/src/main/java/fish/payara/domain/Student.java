package fish.payara.domain;

import jakarta.persistence.*;
import java.util.List;
import jakarta.json.bind.annotation.JsonbTransient;

@NamedQueries({
    @NamedQuery(name = "Student.findByStudentID", query = "SELECT e FROM Student e WHERE e.studentID = :studentID"),
    @NamedQuery(name = "Student.findByName", query = "SELECT e FROM Student e WHERE e.name = :name"),
    @NamedQuery(name = "Student.findByAddress", query = "SELECT e FROM Student e WHERE e.address = :address"),
    @NamedQuery(name = "Student.findByAge", query = "SELECT e FROM Student e WHERE e.age = :age")
})
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String studentID;

    private String name;

    private String address;

    private Integer age;

    @JsonbTransient
    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

    // Getters and setters

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

}
