package com.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStudent;

    @NotEmpty(message = "name cannot be empty")
    @Size(min = 3, max = 50, message = "min = 3 characters, max =  50 50 characters")
    private String studentName;

    @Min(value = 6, message = "min age = 6")
    @Max(value = 99, message = "Please enter a reasonable age")
    private int age;

    @Email(message = "Please enter a valid email")
    private String email;

    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/", message = "Please enter the correct phone number")
    private String phoneNumber;

    private String img;

    @ManyToOne
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(int idStudent, String studentName, int age, String email, String phoneNumber, String img, ClassRoom classRoom) {
        this.idStudent = idStudent;
        this.studentName = studentName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.img = img;
        this.classRoom = classRoom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
