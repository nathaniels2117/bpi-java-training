package com.bpi.model;

import jakarta.persistence.*;


@Entity
@Table(name = "courses") 
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    private Long id;

    @Column(
        name = "course_name",
        columnDefinition = "VARCHAR(50)",
        nullable = false
    )
    private String courseName;

    @Column(
        name = "grade",
        columnDefinition = "DECIMAL(5,2)",
        nullable = true
    )
    private double grade;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public Course() {}

    public Course(String courseName, double grade) {
        this.courseName = courseName;
        this.grade = grade;
    }

    public Long getId() { 
    	return id; 
    }

    public String getCourseName() { 
    	return courseName; 
    }
    
    public void setCourseName(String courseName) { 
    	this.courseName = courseName; 
    }

    public double getGrade() { 
    	return grade; 
    }
    public void setGrade(double grade) { 
    	this.grade = grade; 
    }

    public Student getStudent() { 
    	return student; 
    }
    public void setStudent(Student student) { 
    	this.student = student; 
    }
}
