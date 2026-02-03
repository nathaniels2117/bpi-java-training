package com.bpi.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name = "students")
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    private Long id;


	@Column(
        name = "name",
        columnDefinition = "VARCHAR(100)",
        nullable = false                 
    )
    private String name;

    @Column(
        name = "age",
        columnDefinition = "INTEGER", 
        nullable = false
    )
    private Integer age;

    @Column(
        name = "email",
        columnDefinition = "VARCHAR(100)", 
        unique = true,                     
        nullable = false
    )
    private String email;
    
    @OneToMany(
           mappedBy = "student",
           cascade = { CascadeType.PERSIST, CascadeType.MERGE },
           fetch = FetchType.LAZY

       )
    private List<Course> courses = new ArrayList<>();


    public Student() {}

    // Getters/Setters
    public Long getId() { 
    	return id; 
    }

    public String getName() { 
    	return name; 
    }
    
    public void setName(String name) { 
    	this.name = name; 
    }

    public Integer getAge() { 
    	return age; 
    }
    
    public void setAge(Integer age) { 
    	this.age = age; 
    }

    public String getEmail() { 
    	return email; 
    }
    
    public void setEmail(String email) { 
    	this.email = email; 
    }
    
    public List<Course> getCourses() { 
    	return courses; 
    }

	public void addCourse(Course course) {
		courses.add(course);
        course.setStudent(this); 
	}


}