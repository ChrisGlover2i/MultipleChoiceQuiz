package org.twoeye.display;

import org.twoeye.Setup.GameRules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameConfig extends JFrame implements ActionListener {
    private JLabel playerLabel;
    private JTextField playerTextField;
    private JLabel roundLabel;
    private JTextField roundTextField;
    private JButton startButton;
    private GameRules gameRules;

    public GameConfig() {
        super("Game Configuration");
        setLayout(new GridLayout(3, 2));

        // Player label and text field
        playerLabel = new JLabel("Number of Players:");
        add(playerLabel);
        playerTextField = new JTextField();
        add(playerTextField);

        // Round label and text field
        roundLabel = new JLabel("Number of Rounds:");
        add(roundLabel);
        roundTextField = new JTextField();
        add(roundTextField);

        // Start button
        startButton = new JButton("Start Game");
        startButton.addActionListener(this);
        add(startButton);

        // Cancel button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the application
                System.exit(0);
            }
        });
        add(cancelButton);

        // center the frame on the screen
        setLocationRelativeTo(null);

        setSize(300, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int numPlayers = Integer.parseInt(playerTextField.getText());
        int numRounds = Integer.parseInt(roundTextField.getText());

        // Create array of player names
        String[] playerNames = new String[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            String name = JOptionPane.showInputDialog("Enter name for player " + (i+1));
            playerNames[i] = name;
        }

        // Create game config object and store it in a class variable
        gameRules = new GameRules(numPlayers, playerNames, numRounds);

        // Dispose of the GUI
        dispose();
    }

    public GameRules getGameRules() {
        return gameRules;
    }
}

