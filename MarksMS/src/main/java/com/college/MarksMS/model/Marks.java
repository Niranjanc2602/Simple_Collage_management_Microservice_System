package com.college.MarksMS.model;

import javax.persistence.*;

@Entity
@Table(name = "marks")
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String Subject;

    private int stdId;

    private int staffId;

    private int Marks;

    public Marks() {
    }

    public Marks(int id, String subject, int stdId, int staffId, int marks) {
        this.id = id;
        Subject = subject;
        this.stdId = stdId;
        this.staffId = staffId;
        Marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getMarks() {
        return Marks;
    }

    public void setMarks(int marks) {
        Marks = marks;
    }

    @Override
    public String toString() {
        return "Marks{" +
                "id=" + id +
                ", Subject='" + Subject + '\'' +
                ", stdId=" + stdId +
                ", staffId=" + staffId +
                ", Marks=" + Marks +
                '}';
    }
}
