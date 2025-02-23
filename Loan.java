package bikersportal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loan extends JPanel {
    private JTextField bikeNameField;
    private JTextField loanYearsField;
    private JTextArea resultArea;

    public Loan() {
        bikeNameField = new JTextField(15);
        loanYearsField = new JTextField(15);
        JButton calculateButton = new JButton("Calculate Loan");
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Enter Bike Name:"));
        add(bikeNameField);
        add(new JLabel("Enter Loan Years:"));
        add(loanYearsField);
        add(calculateButton);
        add(new JScrollPane(resultArea));

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bikeName = bikeNameField.getText();
                String loanYearsStr = loanYearsField.getText();
                try {
                    int loanYears = Integer.parseInt(loanYearsStr);
                    double loanAmount = calculateLoanAmount(bikeName);
                    double monthlyPayment = calculateMonthlyPayment(loanAmount, loanYears);
                    resultArea.setText("Bike Name: " + bikeName + "\n" +
                            "Total Loan Amount: " + loanAmount + "\n" +
                            "Loan Duration (Months): " + (loanYears * 12) + "\n" +
                            "Monthly Payment: " + monthlyPayment);
                } catch (NumberFormatException ex) {
                    resultArea.setText("Please enter a valid number for loan years.");
                }
            }
        });
    }

    private double calculateLoanAmount(String bikeName) {
    
        return 100000; 
    }

    private double calculateMonthlyPayment(double loanAmount, int loanYears) {
        int loanMonths = loanYears * 12;
        double annualInterestRate = 0.05; // Example interest rate
        double monthlyInterestRate = annualInterestRate / 12;
        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -loanMonths));
    }
}
