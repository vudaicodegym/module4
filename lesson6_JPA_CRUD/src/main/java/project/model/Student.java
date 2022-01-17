package project.model;

import javax.persistence.*;

@Entity
public class Student {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
private String name;
private String img;
private String phoneNumber;

@ManyToOne
    private Classroom classroom;

    public Student() {
    }

    public Student(int id, String name, String img, String phoneNumber, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.phoneNumber = phoneNumber;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
