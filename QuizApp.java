import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String question;
    List<String> options;
    int correctAnswerIndex;

    public Question(String question, List<String> options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }
}

public class QuizApp {
    private List<Question> questions;
    private int score;

    public QuizApp() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is the capital of France?", 
            List.of("Berlin", "Madrid", "Paris", "Lisbon"), 2));
        questions.add(new Question("What is 2 + 2?", 
            List.of("3", "4", "5", "6"), 1));
        questions.add(new Question("What is the color of the sky?", 
            List.of("Green", "Blue", "Red", "Yellow"), 1));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question q : questions) {
            System.out.println(q.question);
            for (int i = 0; i < q.options.size(); i++) {
                System.out.println((i + 1) + ". " + q.options.get(i));
            }

            System.out.print("Your answer (1-" + q.options.size() + "): ");
            int answer = scanner.nextInt() - 1;

            if (q.isCorrect(answer)) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Wrong! The correct answer was: " + q.options.get(q.correctAnswerIndex) + "\n");
            }
        }

        System.out.println("Quiz over! Your score: " + score + "/" + questions.size());
        scanner.close();
    }

    public static void main(String[] args) {
        QuizApp quiz = new QuizApp();
        quiz.startQuiz();
    }
}
