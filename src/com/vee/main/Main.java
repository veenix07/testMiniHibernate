package com.vee.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vee.dao.impl.DepartmentDAOImpl;
import com.vee.dao.impl.EmployeeDAOImpl;
import com.vee.entity.Department;
import com.vee.entity.Employee;
import com.vee.entity.Student;

public class Main {
	private static SessionFactory factory; 
	   public static void main(String[] args) {
		   
		   DepartmentDAOImpl ddao = new DepartmentDAOImpl();
		   List<Department> departments = ddao.list();
		   for(Department d : departments){
			   System.out.println(d.getDepartmentID() + " : " + d.getDepartmentName() + " - " + d.getManagerID() );
			   if( d.getEmployeeList().size() > 0 ){
				   for(Employee e : d.getEmployeeList()){
					   System.out.println("------"+e.getEmployeeID() + " " +e.getFirstName());
				   }
			   }
		   }
		   
		   EmployeeDAOImpl edao = new EmployeeDAOImpl();
		   List<Employee> employees = edao.list();
		   for(Iterator iterator = employees.iterator();iterator.hasNext();){
			   Employee emp = (Employee)iterator.next();
			   System.out.println("Employee ID : " + emp.getEmployeeID());
			   System.out.println("Employee name : " + emp.getFirstName() + " " + emp.getLastName() );
			   System.out.println("Employee email : " + emp.getEmail());
			   if(emp.getDepartment()!=null){
				   System.out.println("Dept " + emp.getDepartment().getDepartmentName());
			   }
		   }
		   
		   // new code
//		   StudentDAOImpl sdao = new StudentDAOImpl();
//		   List<Student> students = sdao.list();
//		   for(Iterator iterator = students.iterator();iterator.hasNext();){
//			   Student std = (Student)iterator.next();
//			   System.out.println("Student ID : " + std.getStudentId());
//			   System.out.println("Name : " + std.getName());
//		   }
//		   
//		   Student s = sdao.find("1234567004");
//		   System.out.println(s==null);
		   
//		   StudentGrade s1 = new StudentGrade();
//		   s1.setStudentId("672016006");
//		   s1.setName("Student Grade 1");
//		   s1.setGrade(13);
//		   
//		   sdao.create(s1);
		   
//		   Student s2 = new Student();
//		   s2.setStudentId("672007007");
//		   s2.setName("Student 2");
//		   
//		   sdao.create(s2);
		   
//		   sdao.create(s1);
//		   List<Student> students = new ArrayList<Student>();
//		   int studentId = 672016000;
//		   for(int a=0;a<5;a++){
//			   students.add(new Student(String.valueOf(studentId++),"Test Student " + (a+1)));
//		   }
//		   for(Student std : students){
//			   sdao.create(std);
//		   }
//		   Student std1 = sdao.find(s1.getStudentId());
//		   
//		   std1.setName("Student 222");
//		   sdao.update(std1);
//		   sdao.delete(s1);
		   
//	      try{
//	         factory = new Configuration().configure().buildSessionFactory();
//	      }catch (Throwable ex) { 
//	         System.err.println("Failed to create sessionFactory object." + ex);
//	         throw new ExceptionInInitializerError(ex); 
//	      }
//	      Main main = new Main();

	      /* Add few employee records in database */
//	      Integer empID1 = main.addEmployee("Zara", "Ali", 1000);
//	      Integer empID2 = main.addEmployee("Daisy", "Das", 5000);
//	      Integer empID3 = main.addEmployee("John", "Paul", 10000);

	      /* List down all the employees */
//	      main.listStudent();

	      /* Update employee's records */
//	      main.updateStudent(empID1, 5000);

	      /* Delete an employee from the database */
//	      main.deleteEmployee(empID2);

	      /* List down new list of the employees */
//	      main.listStudent();
	   }
	   /* Method to CREATE an employee in the database */
	   /*public Integer addEmployee(String fname, String lname, int salary){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer employeeID = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = new Employee(fname, lname, salary);
	         employeeID = (Integer) session.save(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return employeeID;
	   }*/
	   /* Method to  READ all the employees */
	   public void listStudent( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List students = session.createQuery("FROM Student").list(); 
	         for (Iterator iterator = 
	                           students.iterator(); iterator.hasNext();){
	            Student student = (Student) iterator.next(); 
	            System.out.println("Student ID: " + student.getStudentId()); 
	            System.out.println("Name: " + student.getName()); 
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   /* Method to UPDATE salary for an employee */
	   /*public void updateStudent(Integer studentID, int salary ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = 
	                    (Employee)session.get(Employee.class, studentID); 
	         employee.setSalary( salary );
			 session.update(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }*/
	   /* Method to DELETE an employee from the records */
	   /*public void deleteEmployee(Integer EmployeeID){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = 
	                   (Employee)session.get(Employee.class, EmployeeID); 
	         session.delete(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }*/

}
