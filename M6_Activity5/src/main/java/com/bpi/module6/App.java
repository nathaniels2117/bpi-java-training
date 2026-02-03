package com.bpi.module6;

import util.EntityManagerUtil;
import jakarta.persistence.EntityManager;

public class App {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

		try {
			runM6Activity5(em);
		} finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		}
	}

	static void runM6Activity5(EntityManager em) {
		try {
			Jpql.printAllStudentNames(em);

			Long studentId = 1L;
            long courseCount = Jpql.countCoursesByStudentId(em, studentId);
            System.out.println("Course count for Student ID " + studentId + " is : " + courseCount);


            int age = 20;
            long olderCount = Jpql.countStudentsByAgeGreaterThan(em, age);
            System.out.println("Students by age Greater Than ( " + age + " ) : " + olderCount);


		} catch (Exception e) {
            e.printStackTrace();
        }
	}
}
