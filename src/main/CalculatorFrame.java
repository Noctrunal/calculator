package main;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    private CalculatorFrame() {
        setBounds(300, 300, 300, 300);
        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel(new GridLayout(3, 5));
        add(buttonPanel, BorderLayout.CENTER);
        JButton buttonResult = new JButton("=");
        add(buttonResult, BorderLayout.SOUTH);
        JButton button0 = new JButton("0");
        buttonPanel.add(button0);
        JButton button1 = new JButton("1");
        buttonPanel.add(button1);
        JButton button2 = new JButton("2");
        buttonPanel.add(button2);
        JButton button3 = new JButton("3");
        buttonPanel.add(button3);
        JButton button4 = new JButton("4");
        buttonPanel.add(button4);
        JButton button5 = new JButton("5");
        buttonPanel.add(button5);
        JButton button6 = new JButton("6");
        buttonPanel.add(button6);
        JButton button7 = new JButton("7");
        buttonPanel.add(button7);
        JButton button8 = new JButton("8");
        buttonPanel.add(button8);
        JButton button9 = new JButton("9");
        buttonPanel.add(button9);
        JButton buttonSum = new JButton("+");
        buttonPanel.add(buttonSum);
        JButton buttonBack = new JButton("C");
        buttonPanel.add(buttonBack);
        JButton buttonDivide = new JButton("/");
        buttonPanel.add(buttonDivide);
        JButton buttonSub = new JButton("-");
        buttonPanel.add(buttonSub);
        JButton buttonMultiple = new JButton("*");
        buttonPanel.add(buttonMultiple);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Калькулятор");
        setVisible(true);
        button0.addActionListener(e -> display.setText(display.getText() + "0"));
        button1.addActionListener(e -> display.setText(display.getText() + "1"));
        button2.addActionListener(e -> display.setText(display.getText() + "2"));
        button3.addActionListener(e -> display.setText(display.getText() + "3"));
        button4.addActionListener(e -> display.setText(display.getText() + "4"));
        button5.addActionListener(e -> display.setText(display.getText() + "5"));
        button6.addActionListener(e -> display.setText(display.getText() + "6"));
        button7.addActionListener(e -> display.setText(display.getText() + "7"));
        button8.addActionListener(e -> display.setText(display.getText() + "8"));
        button9.addActionListener(e -> display.setText(display.getText() + "9"));
        buttonBack.addActionListener(e -> display.setText(display.getText().substring(0, display.getText().length() - 1)));
        buttonSum.addActionListener(e -> {
            firstValue = Integer.valueOf(display.getText());
            display.setText("");
            operation = "+";
        });
        buttonMultiple.addActionListener(e -> {
            firstValue = Integer.valueOf(display.getText());
            display.setText("");
            operation = "*";
        });
        buttonDivide.addActionListener(e -> {
            firstValue = Integer.valueOf(display.getText());
            display.setText("");
            operation = "/";
        });
        buttonSub.addActionListener(e -> {
            firstValue = Integer.valueOf(display.getText());
            display.setText("");
            operation = "-";
        });
        buttonResult.addActionListener(e -> {
            int secondValue = Integer.valueOf(display.getText());
            switch (operation) {
                case "+":
                    display.setText((firstValue + secondValue) + "");
                    break;
                case "-":
                    display.setText((firstValue - secondValue) + "");
                    break;
                case "*":
                    display.setText((firstValue * secondValue) + "");
                    break;
                case "/":
                    display.setText((firstValue / secondValue) + "");
                    break;
                default:
                    firstValue = 0;
                    operation = "+";
                    throw new UnsupportedOperationException();
            }
        });
    }

    public static void main(String[] args) {
        new CalculatorFrame();
    }

    private JTextArea display = new JTextArea();
    private int firstValue = 0;
    private String operation = "+";
}
