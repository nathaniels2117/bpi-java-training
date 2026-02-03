
package com.bpi.module6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import com.bpi.model.Student;

public class Jpql {
	
    public static void printAllStudentNames(EntityManager em) {
    	String jpql = "SELECT s FROM Student s ORDER BY s.name";
        TypedQuery<Student> query = em.createQuery(jpql, Student.class);
        List<Student> students = query.getResultList();
        students.forEach(s -> System.out.println(s.getName()));
    }

    public static long countCoursesByStudentId(EntityManager em, Long id) {
    	String jpql = "SELECT count(c.id) FROM Student s JOIN s.courses c WHERE s.id = :id";
        Long query = em.createQuery(jpql, Long.class)
		            .setParameter("id", id)
		            .getSingleResult();
        return query != null ? query : 0L;
    }

    public static long countStudentsByAgeGreaterThan(EntityManager em, int age) {
    	String jpql = "SELECT count(s.id) FROM Student s WHERE s.age > :age";
        Long query = em.createQuery(jpql, Long.class)
		            .setParameter("age", age)
		            .getSingleResult();
        return query != null ? query : 0L;
    }


}
