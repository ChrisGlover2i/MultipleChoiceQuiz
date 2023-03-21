package org.twoeye;
import java.util.*;

public class Game {
    private int numRounds;
    private String[] playerNames;
    private HashSet<Question> questionDeck;
    private ArrayList<Question> remainingQuestions;
    private HashMap<String, Integer> playerScores;

    public Game(int numRounds, String[] playerNames, HashSet<Question> questionDeck) {
        this.numRounds = numRounds;
        this.playerNames = playerNames;
        this.questionDeck = questionDeck;
        remainingQuestions = new ArrayList<>(questionDeck);
        playerScores = new HashMap<>();
        for (String playerName : playerNames) {
            playerScores.put(playerName, 0);
        }
    }

    public void start() {
        System.out.println("Starting game with " + playerNames.length + " players and " + numRounds + " rounds.");

        // Loop over the specified number of rounds
        for (int round = 1; round <= numRounds; round++) {
            System.out.println("Starting round " + round + ".");
            Collections.shuffle(remainingQuestions); // Shuffle the remaining questions

            // Loop over each player
            for (String playerName : playerNames) {
                System.out.println("Player " + playerName + "'s turn.");

                // Get the next question and display it
                Question question = remainingQuestions.remove(0);
                System.out.println(question.getQuestion());
                String[] answers = question.getAnswers();
                for (int i = 0; i < answers.length; i++) {
                    System.out.println((i+1) + ": " + answers[i]);
                }

                // Prompt the player for their answer and check if it's correct
                Scanner scanner = new Scanner(System.in);
                int playerAnswer = scanner.nextInt();
                if (playerAnswer == question.getCorrectAnswerIndex()) {
                    System.out.println("Correct!");
                    playerScores.put(playerName, playerScores.get(playerName) + 1);
                } else {
                    System.out.println("Incorrect.");
                }
            }
        }

        // Display the final scores
        System.out.println("Game over. Final scores:");
        for (String playerName : playerNames) {
            System.out.println(playerName + ": " + playerScores.get(playerName));
        }
    }
}