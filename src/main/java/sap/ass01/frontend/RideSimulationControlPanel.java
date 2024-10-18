package sap.ass01.frontend;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class RideSimulationControlPanel extends JFrame {

    private JButton stopButton;
    private String rideId;

    public RideSimulationControlPanel(String rideId) {
        super("Ongoing Ride: " + rideId);
        this.rideId = rideId;

        initializeComponents();
        setupLayout();
        addEventHandlers();

        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initializeComponents() {
        stopButton = new JButton("Stop Riding");
    }

    private void setupLayout() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(stopButton);

        setLayout(new BorderLayout(10, 10));
        add(new JLabel("Ongoing Ride: " + rideId), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addEventHandlers() {
        stopButton.addActionListener(e -> {
            stopRideRequest(rideId);
            dispose();
        });
    }

    private void stopRideRequest(String rideId) {
        try {
            URL url = new URL("http://localhost:8080/api/rides/end/" + rideId);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                JOptionPane.showMessageDialog(this, "Ride ended successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to end ride", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the server", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void display() {
        SwingUtilities.invokeLater(() -> this.setVisible(true));
    }
}
