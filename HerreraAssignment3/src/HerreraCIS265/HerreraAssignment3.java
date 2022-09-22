package HerreraCIS265;

import java.util.Scanner;

/**
 * @author Carlos Herrera
 * @version 1.0
 */
public class HerreraAssignment3 {
    static Scanner scan = new Scanner(System.in); //Declaring the scanner object to get the input from the user

    public static void main(String[] args) {
        boolean differentId = true;

        System.out.println("Welcome to the student management system!"); //A warming welcome message :)

        int numStudents = checkLengthArray();

        //Creating the array that will allocate the students information
        Student[] students = new Student[numStudents];

        //Populating the array
        for (int i = 0; i < students.length; i++) {
            //Creating variables inside for to delete them after completing the loop (since they are temporary).
            String tempName;
            int tempId = 0;
            double tempGPA;

            //Setting the name by using a method
            tempName = setName(i);

            tempId = setId(i, students);

            tempGPA = setGPA(i);

            students[i] = new Student(tempName, tempId, tempGPA); //Allocating their information in different objects inside the array
        }

        //Creating the linear search until the user inputs 0 as ID
        //Variables used to do the linear search
        int enteredId;
        boolean flag = true;

        while (flag) {
            enteredId = checkIDNoCounter();

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
     * @param actualLength is the index of the last location with a value. (i.e. students[actualLength])
     */
    public static boolean checkIdIsRepeated(Student[] student, int id, int actualLength) {
        boolean flag = true; //Meaning that it is repeated

        for (int i = 0; i < actualLength; i++) {
            if (id == student[i].getId()) {
                System.out.println("Student ID: " + id + " already exists! Please retry!");
                return true;
            } else {
                flag = false;
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
    public static void linearSearch(Student[] student, int id) {
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
    //Works
    //Check length for the array
    public static int checkLengthArray() {
        int numStudents = 0;
        String input;
        boolean correctAmount = false; //Flag variable to verify the correct amount of students is being entered
        //Creating the array

        do { //Getting the number of students to create the array
            System.out.println("Please, tell me how many students do yo have (1-10): ");
            input = scan.nextLine();

            try{
                numStudents = Integer.parseInt(input);
                if (numStudents < 1 || numStudents > 10) { //Verifying if the amount of students is on the range
                    System.out.println("I cannot create " + numStudents + " students!!");
                } else {
                    correctAmount = true;
                }
            }catch (NumberFormatException e){
                correctAmount = false;
            }
        } while (!correctAmount);

        return numStudents;
    }

    //Works
    public static String setName(int counter){
        System.out.print("Student " + (counter + 1) + " name: ");
        String tempName = scan.next();
        return tempName;
    }

    //Works
    public static int setId(int counter, Student[] students){
        int tempId = 0;
        //After the first student the program will check if there is any duplicate ID to reject it
        if (counter == 0) {
            tempId = checkID(counter);
        } else {
            do {
               tempId = checkID(counter);
            } while (checkIdIsRepeated(students, tempId, counter));
        }
        return tempId;
    }

    //Works
    public static int checkID(int counter){
        String input;
        int id=0;
        while (id == 0){
            try {
                System.out.print("Student " + (counter + 1) + " ID: ");
                input = scan.next();

                if (Integer.parseInt(input) >= 1000000 && Integer.parseInt(input) <= 9999999){
                    id = Integer.parseInt(input);
                }else {
                    System.out.println("Please input an integer between 1000000 and 9999999");
                }
            }catch (NumberFormatException e){
                System.out.println("Please input an integer between 1000000 and 9999999");
                id = 0;
            }
        }
        return id;
    }

    public static int checkIDNoCounter(){
        String input;
        int id=0;
        while (id == 0){
            try {
                System.out.println("Enter a student ID (Enter 0 to quit): ");
                input = scan.next();

                if (Integer.parseInt(input) == 0){
                    id = Integer.parseInt(input);
                    return id;
                }
                else if (Integer.parseInt(input) >= 1000000 && Integer.parseInt(input) <= 9999999){
                    id = Integer.parseInt(input);
                    return id;
                }else {
                    System.out.println("A valid ID is an integer between 1000000 and 9999999");
                }
            }catch (NumberFormatException e){
                System.out.println("Please input an integer between 1000000 and 9999999");
                id = 0;
            }
        }
        return id;
    }

    //Works
    public static double setGPA(int counter){
        String input;
        double GPA=-1.0;

        do {
            try{
                System.out.print("Student " + (counter + 1) + " GPA: ");
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
