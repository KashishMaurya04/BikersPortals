package bikersportal;

import javax.swing.*;

public class BikersPortal {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bikers Portal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Compare", new ComparePanel());
        tabbedPane.addTab("Location", new Location());
        tabbedPane.addTab("Loan", new Loan());
        tabbedPane.addTab("Events", new Event());

        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);
    }
}
