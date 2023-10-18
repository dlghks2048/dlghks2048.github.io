package org.javaro.Midtrem;

public class Midterm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stud1 = new Student("20201368", "조이환", 3);
		stud1.exam[0].setSubject("자바");
		stud1.exam[0].setScore(88);
		stud1.exam[1].setSubject("C");
		stud1.exam[1].setScore(90);
		stud1.exam[2].setSubject("C++");
		stud1.exam[2].setScore(92);
		stud1.printGPA();
	}

}
