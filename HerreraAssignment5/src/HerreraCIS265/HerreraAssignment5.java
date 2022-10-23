package HerreraCIS265;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HerreraAssignment5 {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            if (args.length != 2){
                System.out.println("Usage: HerreraAssignment5.HerreraCIS265 input_file output_file");
            }else{
                File file = new File("src/HerreraCIS265/"+args[0].toString());
                Scanner scan = new Scanner(file);

                StringTokenizer token;
                ArrayList<Student> students = new ArrayList<Student>();

                while (scan.hasNextLine()){
                    boolean incorrect = false;
                    Object newObject = new Object();
                    String invalidInput = scan.nextLine();
                    token = new StringTokenizer(invalidInput, ",");
                    String name = token.nextToken();
                    String tempInput = token.nextToken();

                    if (checkID(tempInput)){ //Checking if ID is a number
                        int id = Integer.parseInt(tempInput);
                        if (checkIdIsRepeated(id, students)){
                            tempInput = token.nextToken();
                            if (checkGPA(tempInput)){ //Check GPA
                                double gpa = Double.parseDouble(tempInput);
                                tempInput = token.nextToken();
                                if (checkStanding(tempInput)){
                                    String standing = tempInput;
                                    if (checkLastField(tempInput)){
                                        if (standing.equals("undergraduate")){
                                            boolean transfer = Boolean.parseBoolean(token.nextToken());
                                            newObject = new UndergradStudent(name, id, gpa, transfer);

                                        }else if (standing.equals("graduate")){
                                            String school = token.nextToken();
                                            newObject = new GradStudent(name, id, gpa, school);
                                        }
                                        students.add((Student) newObject);
                                    }else{
                                        incorrect = true;
                                    }
                                }else{
                                    incorrect = true;
                                }
                            }else{
                                incorrect = true;
                            }
                        }else{
                            incorrect = true;
                        }
                    }else{
                        incorrect = true;
                    }

                    if(incorrect){
                        System.out.println("Invalid input: "+invalidInput);
                    }
                }
                writeDocument(students, args[1]);

                System.out.println("All done, have a great day!");
            }
        }catch (FileNotFoundException ex){
            System.out.println("Error!! \nUsage: HerreraAssignment5.HerreraCIS265 "+args[0]+ " "+args[1]);
        }
    }

    public static void writeDocument(ArrayList<Student> students, String path){
        try{
            File newFile = new File("src/HerreraCIS265/"+path);
            newFile.createNewFile();

            PrintWriter writer = new PrintWriter("src/HerreraCIS265/"+path);

            for (int i = (students.size()-1); i >= 0; i--) {
                students.get(i).printStudent(writer);
            }

            writer.close();

        }catch (IOException ex){
            System.out.println(ex);
        }
    }

    public static boolean checkID(String id){
        try{
            int tempId = Integer.parseInt(id);
            if (tempId > 0){
                return true;
            }else{
                return false;
            }
        }catch (NumberFormatException ex){
            return false;
        }
    }

    public static boolean checkIdIsRepeated(int id, ArrayList<Student> student){
        boolean flag = false;
        try {
            if (student.size() != 0){
                for (int i = 0; i < student.size(); i++) {
                    if (id == student.get(i).getId()) {
                        flag = false;
                    } else {
                        flag = true;
                    }
                }
            }else{
                return true;
            }
        }catch (Exception ex){
            return false;
        }
        return flag;
    }

    public static boolean checkGPA(String GPA){
        try{
            double tempGPA = Double.parseDouble(GPA);
            if (tempGPA >= 0.0 && tempGPA <= 4.0){
                return true;
            }else{
                return false;
            }
        }catch (NumberFormatException ex){
            return false;
        }
    }

    public static boolean checkStanding(String standing){
        try{
            if (standing.equals("undergraduate") || standing.equals("graduate")){
                return true;
            }else{
                return false;
            }
        }catch (NumberFormatException ex){
            return false;
        }
    }

    public static boolean checkLastField(String lastField){
        try{
            if (lastField.isEmpty()){
                return false;
            }else{
                return true;
            }
        }catch (NumberFormatException ex){
            return false;
        }
    }
}
