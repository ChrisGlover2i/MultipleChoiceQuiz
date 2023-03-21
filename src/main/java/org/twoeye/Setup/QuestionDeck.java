package org.twoeye.Setup;

import org.twoeye.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * This class extracts the question decks from a CSV file containing, category, question, answer.
 *
 * @author Chris Glover 21/03/2023
 *
 */
public class QuestionDeck {

    public HashSet<Question> buildQuestionDeck(String csvFile) {
        HashSet<Question> questions = new HashSet<>();
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";

        try {
            InputStream inputStream = getClass().getResourceAsStream("/questions/" + csvFile);
            br = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = br.readLine()) != null) {
                String[] questionData = line.split(csvSplitBy);
                String category = questionData[0];
                String question = questionData[1];
                String[] answers = new String[4];
                answers[0] = questionData[2];
                answers[1] = questionData[3];
                answers[2] = questionData[4];
                answers[3] = questionData[5];
                int correctAnswerIndex = Integer.parseInt(questionData[6]);
                questions.add(new Question(category, question, answers, correctAnswerIndex));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return questions;
    }
}
