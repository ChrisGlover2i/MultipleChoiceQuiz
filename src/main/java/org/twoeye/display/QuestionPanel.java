package org.twoeye.display;

import org.twoeye.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A panel that displays a question and answer options.
 */
public class QuestionPanel extends JFrame implements ActionListener {
    private JLabel playerLabel;
    private JLabel questionLabel;
    private JRadioButton[] answerButtons;
    private JButton submitButton;

    private int currentPlayerIndex;
    private Question currentQuestion;
    private String[] playerNames;
    private int numPlayers;
    private ButtonGroup answerGroup;

    /**
     * Creates a new QuestionPanel.
     *
     * @param playerNames the names of the players
     * @param numPlayers the number of players
     */
    public QuestionPanel(int numPlayers, String[] playerNames) {
        super("Question Panel");
        this.playerNames = playerNames;
        this.numPlayers = numPlayers;

        setLayout(new GridLayout(6, 1)); // 6 rows to fit all components

        // Create labels for current player and question
        playerLabel = new JLabel("Current player: " + playerNames[0]);
        add(playerLabel);
        questionLabel = new JLabel("Question:");
        add(questionLabel);

        // Create radio buttons for answer options
        answerButtons = new JRadioButton[4];
        ButtonGroup answerGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new JRadioButton();
            answerGroup.add(answerButtons[i]);
            add(answerButtons[i]);
        }

        // Create submit button
        submitButton = new JButton("Submit Answer");
        submitButton.addActionListener(this);
        add(submitButton);

        // Set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Sets the question to be displayed.
     * @param playerIndex The index of the player who will answer the question
     * @param question The question to be displayed
     */
    public void setQuestion(int playerIndex, Question question) {
        currentPlayerIndex = playerIndex;
        currentQuestion = question;

        // Update player and question labels
        playerLabel.setText("Current player: " + playerNames[playerIndex]);
        questionLabel.setText("Question: " + question.getQuestion());

        // Update answer buttons with answer options
        answerGroup = new ButtonGroup();
        String[] answers = question.getAnswers();
        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText(answers[i]);
            answerGroup.add(answerButtons[i]);
        }
    }

    /**
     * Handles the submit button being clicked.
     * @param e The action event
     */
    public void actionPerformed(ActionEvent e) {
        // Check which answer was selected
        int answerIndex = -1;
        for (int i = 0; i < 4; i++) {
            if (answerButtons[i].isSelected()) {
                answerIndex = i;
                break;
            }
        }

        // Handle submitted answer
        if (answerIndex == currentQuestion.getCorrectAnswerIndex()) {
            // Correct answer - TODO: add logic for awarding points
            JOptionPane.showMessageDialog(this, "Correct!");
        } else {
            // Incorrect answer - TODO: add logic for penalizing points
            JOptionPane.showMessageDialog(this, "Incorrect. The correct answer is " + currentQuestion.getAnswers()[currentQuestion.getCorrectAnswerIndex()]);
        }

        // Move to next player
        currentPlayerIndex = (currentPlayerIndex + 1) % numPlayers;
        playerLabel.setText("Current player: " + playerNames[currentPlayerIndex]);

        // Clear answer buttons
        ButtonModel selectedModel = answerGroup.getSelection();
        if (selectedModel != null) {
            selectedModel.setSelected(false);
        }
    }
}