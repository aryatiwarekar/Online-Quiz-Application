package quizapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    private int score;

    public Quiz(){
        this.questions = createQuiz();
    }
    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void displayQuestion(int questionNumber) {
        Question question = questions.get(questionNumber);
        System.out.println(question.getQuestionText());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Your answer: ");
    }

    public void evaluateAnswer(int questionNumber, int userAnswer) {
        Question question = questions.get(questionNumber);
        if (userAnswer == question.getCorrectOptionIndex() + 1) {
            score++;
        }
    }

    public int getScore() {
        return score;
    }

    private List<Question> createQuiz(){
        List<Question> questions = new ArrayList<>();
        System.out.println("Enter number of questions you want in the quiz: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfQuestions;
        do{
            while(!scanner.hasNextInt()){
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }
            numberOfQuestions = scanner.nextInt();
        }while(numberOfQuestions < 0);

        for(int i = 0; i < numberOfQuestions; i++){
            System.out.print("Enter question no." + (i + 1) + " :");
            String question = scanner.nextLine();
            String[] option = new String[4];
            System.out.println("Enter 4 options for the current question:");
            for(int j = 0; j < 4; j++){
                System.out.print("Enter Option " + (j + 1) + ": ");
                option[j] = scanner.nextLine();
            }
            System.out.println("Enter the correct answer option number");
            int correctOption;
            do{
                while(!scanner.hasNextInt()){
                    System.out.print("Please enter a valid number: ");
                    scanner.next();
                }
                correctOption = scanner.nextInt();
            }while(correctOption < 0);

            questions.add(new Question(question,option,correctOption - 1));
        }
        return questions;
    }
}
