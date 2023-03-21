package org.twoeye;

import org.twoeye.Setup.GameRules;
import org.twoeye.Setup.QuestionDeck;
import org.twoeye.display.GameConfig;
import org.twoeye.display.QuestionPanel;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    private static HashSet<Question> questionDeck;
    private static GameConfig gameConfig;
    public static void main(String[] args) {
        QuestionDeck qdSetup = new QuestionDeck();
        questionDeck = qdSetup.buildQuestionDeck("sampleDeck.csv");

        GameConfig configGUI = new GameConfig();
        while (configGUI.getGameRules() == null) {
            // wait for the user to input the game configuration data
        }
        GameRules gameRules = configGUI.getGameRules();

        // Initialize game
        int numPlayers = gameRules.getNumPlayers();
        String[] playerNames = gameRules.getPlayerNames();
        int numRounds = gameRules.getNumRounds();
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player(playerNames[i]));
        }

        // Set up frame for game
        JFrame frame = new JFrame("Two Eye Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create question panel and add it to the frame
        QuestionPanel questionPanel = new QuestionPanel(numPlayers, playerNames);
        frame.add(questionPanel, BorderLayout.CENTER);

        // Set up button for starting the game
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(e -> {
            // TODO: add logic for starting game
        });
        frame.add(startButton, BorderLayout.SOUTH);

        // Display the frame
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



}