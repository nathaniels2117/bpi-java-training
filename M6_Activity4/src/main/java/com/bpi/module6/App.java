package com.bpi.module6;

import util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import com.bpi.model.Student;

public class App {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

		try {
			runM6Activity4(em);
		} finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		}
	}

	static void runM6Activity4(EntityManager em) {

		Long id = null;
		Student Student = new Student();

		// Create
		try {
			em.getTransaction().begin();
			Student.setName("Pedro Dela Cruz");
			Student.setAge(11);
			Student.setEmail("pedrodelacruz@gmail.com");

			em.persist(Student);
			em.getTransaction().commit();
			em.clear();
			System.out.println("is newStudent inside the persistence context: " + em.contains(Student));
			id = Student.getId(); 
		} catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
		
 
		// Read
        try {
            em.getTransaction().begin();
            Student = em.find(Student.class, id);

            em.getTransaction().commit();
        } catch (Exception e) {
        	if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }


        // Update
        try {
            em.getTransaction().begin();

            Student.setName("Pedro DC");
            Student.setAge(21);
            Student.setEmail("updatepedro@gmail.com");
            em.getTransaction().commit();
            System.out.println("is newStudent inside the persistence context: " 
                    + em.contains(Student));
        } catch (Exception e) {
        	if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }

        // Delete
        try {
            em.getTransaction().begin();
            
            Student = em.getReference(Student.class, id);
            em.remove(Student); 
            em.getTransaction().commit();
            System.out.println("is newStudent inside the persistence context: " 
                    + em.contains(Student));
        } catch (Exception e) {
        	if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }

	}
}
