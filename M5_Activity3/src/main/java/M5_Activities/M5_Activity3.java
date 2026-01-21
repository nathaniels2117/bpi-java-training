package M5_Activities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;

public class M5_Activity3 {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		choices();
		System.out.print("EXIT");
	}
	
	public static void choices() {
		boolean loopin = true;
		while (loopin) {
			Scanner choiceMenu = new Scanner(System.in);
			printMenu();
			System.out.print("Choose an option : ");
			String choice = choiceMenu.nextLine();
			switch (choice) {
	        	case "1":
	        		addStudent();
	        		break;
	        	case "2":
	        		addCourse();
	        		break;
	        	case "3":
	        		showStudent();
	        		break;
	        	case "4":
	        		showCourse();
	        		break;
	        	case "0":
	        		loopin = false;
	        		break;
	        	default:
	        		System.out.println("Invalid option. Please select 1, 2, 3, 4, or 0.");
	        	}
			} 
	}
	
	public static void printMenu() {
        System.out.println("================= STUDENT COURSE MANAGEMENT ==================");
        System.out.println("1 : Add Student");
        System.out.println("2 : Add Course");
        System.out.println("3 : Show Students");
        System.out.println("4 : Show Courses");
        System.out.println("0 : Exit");
	}
	
	public static void addStudent() {
		
        String name = checkEmpty("Enter Name : ","Name");
        int age = readInt("Enter Age : ", "Age");
        String email = checkEmpty("Enter Email : ","Email");

        try (Connection connection = DBConnection.getConnection()) {
	        insertStudent(connection, name, age, email);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	} // End of add student
	
	public static void addCourse() {
		
        int sid = readInt("Enter Student ID : ", "Student ID");
        String cname = checkEmpty("Enter Course Name : ","Course Name");
        int grade = readInt("Enter Grade : ", "Grade");

        try (Connection connection = DBConnection.getConnection()) {
	        insertCourse(connection, sid, cname, grade);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	} // End of add course
	
	public static void insertStudent(Connection connection, String name, int age, String email) {

		 String sql = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";

		 try (PreparedStatement ps = connection.prepareStatement(sql)) {

			 ps.setString(1, name);
			 ps.setInt(2, age);
			 ps.setString(3, email);
			 ps.executeUpdate();
			 System.out.println("Student added successfully!");

		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	} // End of insert student in database
	
	public static void insertCourse(Connection connection, int sid, String cname, int grade) {

		 String sql = "INSERT INTO courses (student_id, course_name, grade) VALUES (?, ?, ?)";

		 try (PreparedStatement ps = connection.prepareStatement(sql)) {

			 ps.setInt(1, sid);
			 ps.setString(2, cname);
			 ps.setInt(3, grade);
			 ps.executeUpdate();
			 System.out.println("Course added successfully!");

		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	} // End of insert course in database
	
	public static void showStudent() {
		String sql = "SELECT * FROM students";
		
	    try (Connection connection = DBConnection.getConnection();
	    	 PreparedStatement ps = connection.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	
	    	System.out.println("==============================================================");
	        System.out.printf("%-3s %-25s %-5s %-1s %n", "ID", "Student Name", "Age", "Grade");
	        System.out.println("==============================================================");
	
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String name = rs.getString("name");
	            int age = rs.getInt("age");
	            String email = rs.getString("email");
	            System.out.printf("%-3s %-25s %-5s %-1s %n", id, name, age, email);
	        }
	    } catch (SQLException e) {
		    e.printStackTrace();
		}
	} // End of show student
	
	public static void showCourse() {
		String sql = "SELECT * FROM courses";
		
	    try (Connection connection = DBConnection.getConnection();
	    	 PreparedStatement ps = connection.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	    	
	    	System.out.println("==============================================================");
	        System.out.printf("%-3s %-12s %-20s %-1s %n", "ID", "Student ID", "Course Name", "Grade");
	        System.out.println("==============================================================");
	
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            int sid = rs.getInt("student_id");
	            String cname = rs.getString("course_name");
	            int grade = rs.getInt("grade");
	            System.out.printf("%-3s %-12s %-20s %-1s %n", id, sid, cname, grade);
	        }
	    } catch (SQLException e) {
		    e.printStackTrace();
		}
	} // End of show course
	
	public static int readInt(String prompt, String promptMes) {
		while (true) {
        	System.out.print(prompt);
        	String s = input.nextLine().trim();
        	if (s.isEmpty()) {
        		System.out.println(promptMes + " cannot be empty."); 	
        	}
        	else {
        		try {	 	
        			int d = Integer.parseInt(s);
        			if (d < 0) {
        				System.out.println(promptMes + " cannot be negative.");
        			}else {
        				return d;
        			}
        		} catch (NumberFormatException e) {
        			System.out.println("Please enter a valid number.");
        		}
        	}
        }
    } // End of validation of readInt.

    public static String checkEmpty(String prompt, String promptMes) {
        while (true) {
            System.out.print(prompt);
            String s = input.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println(promptMes + " cannot be empty.");
            } else {
                return s;
            }
        }
    } // End of validation check empty

}
