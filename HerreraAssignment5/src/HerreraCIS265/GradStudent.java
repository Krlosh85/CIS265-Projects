package HerreraCIS265;

import java.io.PrintWriter;

public class GradStudent extends Student{
    private String college;

    public GradStudent(String name, int id, double gpa, String college){
        super(name, id, gpa);
        this.college = college;
    }

    @Override
    public void printStudent() {
        super.printStudent();
        System.out.println("\tCollege Graduated: "+college);
        System.out.println("=================================");
    }

    @Override
    public void printStudent(PrintWriter output) {
        super.printStudent(output);
        output.write("graduate,"+college);
        output.println();
    }
}
