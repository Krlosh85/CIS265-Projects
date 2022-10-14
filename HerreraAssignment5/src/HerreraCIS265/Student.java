package HerreraCIS265;

import java.io.PrintWriter;

/**
 * This class represents a Student object and its properties
 * @author Carlos Herrera
 * @version 2.0
 */
abstract public class Student {
    private String name;
    private int id;
    private double gpa;

    //Constructors
    /**
     * Creates a new instance of Student
     */
    public Student(){

    }

    /**
     * Creates a new instance of Student
     * @param name The name of a new Student
     * @param id The ID of a new Student
     * @param gpa The GPA of a new Student
     */
    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    //Methods
    /**
     * Prints all the local information stored from a student
     */
    public void printStudent(){
        System.out.println("=================================");
        System.out.println("\tStudent name: "+name);
        System.out.println("\tStudent id: "+id);
        System.out.println("\tStudent gpa: "+gpa);
    }

    public void printStudent(PrintWriter output){
        output.write(name+","+id+","+gpa+",");
    }

    /**
     * Returns the value held for the variable id
     * @return the ID of a student
     */
    public int getId() {
        return id;
    }
}
