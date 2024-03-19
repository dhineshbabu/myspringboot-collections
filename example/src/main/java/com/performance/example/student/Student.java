package com.performance.example.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.performance.example.studentprofile.StudentProfile;
import com.performance.example.school.School;
import jakarta.persistence.*;

@Entity
@Table(name = "T_STUDENT")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "c_fname", length = 20)
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private Integer age;
//    @Column(updatable = false)
//    private String some_column;

    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )

    @JsonBackReference
    private School school;

    public Student() {

    }

    public Student(String firstname, String lastname, String email, Integer age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
