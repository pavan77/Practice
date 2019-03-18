package jpractice;

import java.util.HashMap;
import java.util.HashSet;

public class ImmutableObject {

	private int a;

	private HashMap<Integer, String> map;

	ImmutableObject() {

	}

	ImmutableObject(int a, HashMap<Integer, String> map) {
		this.a = a;
		this.map = (HashMap<Integer, String>) map.clone();
	}

	HashMap getMap() {
		return map;
	}

	class Name {
		String name;

		Name(String name) {
			this.name = name;
		}
	}

	class Address {
		String street;

		Address(String street) {
			this.street = street;
		}
	}

	class Person {
		Name name;
		Address address;

		Person(Name name, Address address) {
			this.name = name;
			this.address = address;
		}

		public String toString() {
			return name.name + "" + address.street;
		}
	}

	void testCloning() {
		/*
		 * HashMap<Person, Integer> set = new HashMap<>(); Name n1 = new Name("pavan");
		 * Address a1 = new Address("madhapur"); Person p1 = new Person(n1, a1); p1.cl
		 * set.put(p1, 1);
		 * 
		 * System.out.println("set is" + set); HashMap<Person, Integer> m2 =
		 * (HashMap<Person, Integer>) set.clone();
		 * 
		 * a1.street = "kondapur";
		 * 
		 * System.out.println("set  after mod is" + m2);
		 */

		Course c1 = new Course("a", "b", "c");

		Student s1 = new Student(1, "pavan", c1);

		try {
			Student s2 = (Student) s1.clone();
			System.out.println("s1" + s1.course.subject1);
			System.out.println("s2" + s2.course.subject1);
			System.out.println("After clone");
			s1.course.subject1 = "newA";
			System.out.println("s1" + s1.course.subject1);
			System.out.println("s2" + s2.course.subject1);

		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	class Course implements Cloneable {
		String subject1;
		String subject2;
		String subject3;
		
		

		public Course(String sub1, String sub2, String sub3) {
			this.subject1 = sub1;
			this.subject2 = sub2;
			this.subject3 = sub3;
		}

		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}

	class Student implements Cloneable {
		int id;
		String name;
		Course course;

		public Student(int id, String name, Course course) {
			this.id = id;
			this.name = name;
			this.course = course;
		}

		// Overriding clone() method to create a deep copy of an object.
		protected Object clone() throws CloneNotSupportedException {
			Student student = (Student) super.clone();
			student.course = (Course) course.clone();
			return student;
		}
	}

}
