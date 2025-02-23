
package bikersportal1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class EventPanel extends JPanel {
    private JTextArea eventsArea;

    public EventPanel() {
        JButton eventsButton = new JButton("Show Events");
        eventsArea = new JTextArea(10, 30);
        eventsArea.setEditable(false);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(eventsButton);
        add(new JScrollPane(eventsArea));

        eventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> events = fetchEvents();
                if (events != null && !events.isEmpty()) {
                    StringBuilder eventText = new StringBuilder();
                    for (String event : events) {
                        eventText.append(event).append("\n\n");
                    }
                    eventsArea.setText(eventText.toString());
                } else {
                    eventsArea.setText("No events found.");
                }
            }
        });
    }

    private List<String> fetchEvents() {
      
        List<String> events = new ArrayList<>();
        events.add("Bike Rally - 25th March 2025");
        events.add("Bike Maintenance Workshop - 5th April 2025");
        events.add("Adventure Ride - 15th April 2025");
        return events;
    }
}
