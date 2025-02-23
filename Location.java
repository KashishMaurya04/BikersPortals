package bikersportal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Location extends JPanel {
    private JTextArea locationArea;

    public Location() {
        JButton locationButton = new JButton("Location");
        locationArea = new JTextArea(10, 30);
        locationArea.setEditable(false);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(locationButton);
        add(new JScrollPane(locationArea));

        locationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String locationInfo = LocationApi.fetchStoreLocations();
                if (locationInfo != null) {
                    locationArea.setText(locationInfo);
                } else {
                    locationArea.setText("Error fetching store locations");
                }
            }
        });
    }
}
