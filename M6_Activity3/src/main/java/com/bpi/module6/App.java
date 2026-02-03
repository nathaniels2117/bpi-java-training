package com.bpi.module6;

import util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import com.bpi.model.Student;
import com.bpi.model.Course;

public class App {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

		try {
			runM6Activity3(em);
		} finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		}
	}

	static void runM6Activity3(EntityManager em) {
		
		try {
			em.getTransaction().begin();
			
			Student student = em.find(Student.class, 1);

		    Course c1 = new Course("Math", 97.00);
		    Course c2 = new Course("English", 97.00);
		    
		    student.addCourse(c1);
		    student.addCourse(c2);
		    
			em.getTransaction().commit();
		} catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }


	}
}
