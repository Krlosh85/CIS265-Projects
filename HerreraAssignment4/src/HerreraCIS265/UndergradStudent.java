package HerreraCIS265;

public class UndergradStudent extends Student {
    private boolean isTransfer;

    public UndergradStudent(String name, int id, double gpa, boolean isTransfer){
        super(name, id, gpa);
        this.isTransfer = isTransfer;
    }

    @Override
    public void printStudent() {
        super.printStudent();
        System.out.println("Transfer Student: "+isTransfer);
        System.out.println("=================================");
    }
}
