import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdvancedQuiz extends JFrame implements ActionListener {
    private JTextField textField;
    private JTextArea textArea;
    private JButton nextButton, finishButton;
    private int questionNumber = 0, correctAnswers = 0;
    private String[][] questions = {
        {"What is the capital of France?", "Paris"},
        {"What is the largest planet in the solar system?", "Jupiter"},
        {"What is the chemical symbol for gold?", "Au"},
        {"Who wrote the novel 'To Kill a Mockingbird'?", "Harper Lee"},
        {"What is the highest mountain in the world?", "Mount Everest"}
    };

    public AdvancedQuiz() {
        setTitle("Advanced Quiz");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(questions[questionNumber][0]);
        panel.add(textArea, BorderLayout.CENTER);

        textField = new JTextField();
        panel.add(textField, BorderLayout.SOUTH);

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        panel.add(nextButton, BorderLayout.EAST);

        finishButton = new JButton("Finish");
        finishButton.addActionListener(this);
        finishButton.setEnabled(false);
        panel.add(finishButton, BorderLayout.WEST);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();

        if (buttonText.equals("Next")) {
            String answer = textField.getText();

            if (answer.equalsIgnoreCase(questions[questionNumber][1])) {
                correctAnswers++;
            }

            questionNumber++;

            if (questionNumber < questions.length) {
                textArea.setText(questions[questionNumber][0]);
                textField.setText("");
            } else {
                textArea.setText("You answered " + correctAnswers + " out of " + questions.length + " questions correctly.");
                textField.setEnabled(false);
                nextButton.setEnabled(false);
                finishButton.setEnabled(true);
            }
        } else if (buttonText.equals("Finish")) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new AdvancedQuiz();
    }
}