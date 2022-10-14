package HerreraCIS265;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HerreraAssignment5 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\Escritorio 2\\CSU\\CIS 265\\CIS265-Projects\\HerreraAssignment5\\src\\HerreraCIS265\\students.txt");
        Scanner scan = new Scanner(file);
        StringTokenizer token;
        String name;
        int id;
        double gpa = 0.0;
        String standing;
        ArrayList<Student> students = new ArrayList<Student>();
        while (scan.hasNextLine()){

            Object newObject = new Object();

            token = new StringTokenizer(scan.nextLine(), ",");
            name = token.nextToken();
            id = Integer.parseInt(token.nextToken());
            gpa = Double.parseDouble(token.nextToken());
            standing = token.nextToken();

            if (standing.equals("undergraduate")){
                boolean transfer = Boolean.parseBoolean(token.nextToken());
                newObject = new UndergradStudent(name, id, gpa, transfer);

            }else if (standing.equals("graduate")){
                String school = token.nextToken();
                newObject = new GradStudent(name, id, gpa, school);
            }

            students.add((Student) newObject);
        }
        writeDocument(students);

        System.out.println("All done, have a great day!");
    }

    public static void writeDocument(ArrayList<Student> students){
        try{
            File newFile = new File("D:\\Escritorio 2\\CSU\\CIS 265\\CIS265-Projects\\HerreraAssignment5\\src\\HerreraCIS265\\students_reversed.txt");
            newFile.createNewFile();

            PrintWriter writer = new PrintWriter("D:\\Escritorio 2\\CSU\\CIS 265\\CIS265-Projects\\HerreraAssignment5\\src\\HerreraCIS265\\students_reversed.txt");

            for (int i = (students.size()-1); i >= 0; i--) {
                students.get(i).printStudent(writer);
            }

            writer.close();

        }catch (IOException ex){
            System.out.println(ex);
        }
    }
}
