package HerreraCIS265;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a refactor of assign. 3.
 *
 * @author Carlos Herrera
 * @version 4.0
 */
public class HerreraAssignment4 {
    private static Scanner scan = new Scanner(System.in); //Declaring a static scanner object to get the input from the user

    public static void main(String[] args) {
        boolean differentId = true;

        System.out.println("Welcome to the student management system!"); //A warming welcome message :)

        //Creating the array that will allocate the students information
        ArrayList<Student> students = new ArrayList<>();


        //Populating the array
        boolean flag = true;
        while(flag){
            System.out.print("Do you have more students to enter? (Y for yes, N for no): ");
            String ans = scan.next();
            if (ans.toString().toUpperCase().equals("Y")){
                System.out.print("Undergraduate or Graduate student? (U for undergraduate, G for Graduate): ");
                ans = scan.next();

                String tempName = setName();
                int tempId = setId(students);
                double tempGPA = setGPA();

                if (ans.toString().toUpperCase().equals("U")){
                    boolean transfer = true;
                    System.out.println("Is a Transfer student? (Y for yes, N for no): ");
                    ans = scan.next();
                    if (ans.toString().toUpperCase().equals("Y")){
                        transfer = true;
                    }else if (ans.toString().toUpperCase().equals("n")){
                        transfer = false;
                    }

                    students.add(new UndergradStudent(tempName, tempId, tempGPA, transfer));
                }else if(ans.toString().toUpperCase().equals("G")){
                    String college;
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("What college did the student graduate from: ");
                    college = scan2.nextLine();
                    students.add(new GradStudent(tempName, tempId, tempGPA, college));
                }


            }else if (ans.toString().toUpperCase().equals("N")){
                flag=false;
            }
        }


        //Creating the linear search until the user inputs 0 as ID
        //Variables used to do the linear search
        int enteredId;
        flag = true;

        System.out.println("\tEntering search mode: ");
        while (flag) {
            System.out.println("Enter a student ID (enter 0 to quit)");
            enteredId = scan.nextInt();

            if (enteredId == 0) { //If 0 is typed, the flag changes to false and exits the while
                flag = false;
            } else {
                linearSearch(students, enteredId);
            }
        }

        System.out.println("Goodbye!"); //The program is terminated
    }


    /**
     * This method does a linear search on the array of students (until the actual last value) to check if a certain ID was already typed before
     *
     * @param student      The array that contains the information of all the students objects
     * @param id           The ID that was just enetered by the user to check if it's repetied
     */
    public static boolean checkIdIsRepeated(ArrayList<Student> student, int id) {
        boolean flag = false; //Meaning that it is repeated

        if (student.size() != 0){
            for (int i = 0; i < student.size(); i++) {
                if (id == student.get(i).getId()) {
                    System.out.println("Student ID: " + id + " already exists! Please retry!");
                    return true;
                } else {
                    flag = false;
                }
            }
        }
        return flag;
    }

    /**
     * This method does a linear search on the array of students
     *
     * @param student The array that contains the information of all the students objects
     * @param id      The ID that the user is looking for
     */
    public static void linearSearch(ArrayList<Student> student, int id) {
        boolean flag = false;
        for (Student actualStudent : student) {
            if (actualStudent.getId() == id) {
                actualStudent.printStudent();
                flag = true;
                break;
            }
        }

        if (flag == false) {
            System.out.println("Student ID " + id + " not found.");
        }
    }

    //Refactor
    /**
     * This method checks if the user inputs correctly the length of the array based on the given parameters.
     *
     * @return the correct length of the array to be created.
     */
    public static int checkLengthArray() {
        int numStudents = 0;
        String input;
        boolean correctAmount = false; //Flag variable to verify the correct amount of students is being entered
        //Creating the array

        do { //Getting the number of students to create the array
            System.out.print("Please, tell me how many students do yo have (1-10): ");
            input = scan.nextLine();

            try{
                numStudents = Integer.parseInt(input);
                if (numStudents < 1 || numStudents > 10) { //Verifying if the amount of students is on the range
                    System.out.println("I cannot create " + numStudents + " students!!");
                } else {
                    correctAmount = true;
                }
            }catch (NumberFormatException e){
                System.out.println("Please input a number between 1 and 10.");
                correctAmount = false;
            }
        } while (!correctAmount);

        return numStudents;
    }

    /**
     * This method sets the name of the new student
     *
     * @return The name that is going to be input in the array
     */
    public static String setName(){
        Scanner scan2 = new Scanner(System.in);
        System.out.print("Student name: ");
        String tempName = scan2.nextLine();
        return tempName;
    }

    /**
     * This method sets the ID of the new student
     *
     * @return The id of the new student validated
     */
    public static int setId(ArrayList<Student> student){
        int tempId = 0;
        //After the first student the program will check if there is any duplicate ID to reject it
        do {
            tempId = checkID();
        } while (checkIdIsRepeated(student, tempId));

        return tempId;
    }


    /**
     * This method checks if the user inputs a valid ID
     *
     * @return The validated ID
     */
    public static int checkID(){
        String input;
        int id=0;
        while (id == 0){
            try {
                System.out.print("Student ID: ");
                input = scan.next();

                if (Integer.parseInt(input) > 0){
                    id = Integer.parseInt(input);
                    return id;
                }else {
                    System.out.println("A valid ID is an integer greater than 0");
                }
            }catch (NumberFormatException e){
                System.out.println("Please input an integer greater than 0");
                id = 0;
            }
        }
        return id;
    }


    /**
     * This method checks if the GPA was correctly input and sets the GPA of a student
     *
     * @return The validated GPA
     */
    public static double setGPA(){
        String input;
        double GPA=-1.0;

        do {
            try{
                System.out.print("Student GPA: ");
                input = scan.next();

                if (Double.parseDouble(input) >= 0 && Double.parseDouble(input) <= 4.0){
                    GPA = Double.parseDouble(input);
                    return GPA;
                }else{
                    System.out.println("Please input a valid GPA (0-4.0) ");
                }
            }catch (NumberFormatException e){
                System.out.println("Please input a valid GPA (0-4.0) ");
                GPA = -1.0;
            }
        }while (GPA == -1.0);

        return GPA;
    }
}
