package quizapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                new String[]{"London", "Paris", "Rome", "Berlin"}, 1));
        // Add more questions
        questions.add(new Question("Who is known as father of Computer?",
                new String[]{"Dennis Richie", "Charles Babbage", "Steve Jobs", "Bill Gate"}, 1));

        questions.add(new Question("Who created Java?",
                new String[]{"Sun Microsystems", "Oracle", "Apple", "Facebook"}, 0));

        questions.add(new Question("What is Java?",
                new String[]{"An Outdoor Game", "A Movie", "A programming language", "A Chocolate"}, 2));

        questions.add(new Question("Which feature of Java lets you create multiple version of same method?",
                new String[]{"Method Overriding", "Inheritance", "Encapsulation", "Method Overloading"}, 3));

        Quiz quiz;

        String quizPin = "12345";

        boolean exit = false;

        do {
            System.out.println("Welcome to Online Quiz Application!");
            System.out.println("What do you want to do?");
            System.out.println("1. Create Quiz");
            System.out.println("2. Play Quiz");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice;
            do{
                while(!scanner.hasNextInt()){
                    System.out.print("Please enter a valid number: ");
                    scanner.next();
                }
                choice = scanner.nextInt();
            }while(choice < 0);
            switch (choice) {
                case 1:
                    System.out.print("Enter your Quiz creator pin: ");
                    String pin = scanner.nextLine();
                    if(pin.equals(quizPin)){
                        System.out.println("Login Successful!");
                        quiz = new Quiz();
                        questions = quiz.getQuestions();
                        break;
                    }
                    else{
                        System.out.println("Invalid Pin");
                        continue;
                    }

                case 2:
                    quiz  = new Quiz(questions);
                    UserInterface ui = new UserInterface();
                    ui.startQuiz(quiz, questions);
                    break;
                case 3:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }while(!exit);
    }
}
