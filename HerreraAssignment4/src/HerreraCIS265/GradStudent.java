package HerreraCIS265;

public class GradStudent extends Student{
    private String college;

    public GradStudent(String name, int id, double gpa, String college){
        super(name, id, gpa);
        this.college = college;
    }

    @Override
    public void printStudent() {
        super.printStudent();
        System.out.println("College Graduated: "+college);
        System.out.println("=================================");
    }
}
