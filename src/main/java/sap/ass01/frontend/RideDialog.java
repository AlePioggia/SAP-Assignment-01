package sap.ass01.frontend;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class RideDialog extends JDialog {

    private JTextField idEBikeField;
    private JTextField userName;
    private JButton startButton;
    private JButton cancelButton;

    public RideDialog(Frame owner) {
        super(owner, "Start Riding an EBike", true);
        initializeComponents();
        setupLayout();
        addEventHandlers();
        pack();
        setLocationRelativeTo(owner);
    }

    private void initializeComponents() {
        idEBikeField = new JTextField(15);
        userName = new JTextField(15);
        startButton = new JButton("Start Riding");
        cancelButton = new JButton("Cancel");
    }

    private void setupLayout() {
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.add(new JLabel("User name:"));
        inputPanel.add(userName);
        inputPanel.add(new JLabel("E-Bike to ride:"));
        inputPanel.add(idEBikeField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(cancelButton);

        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addEventHandlers() {
        startButton.addActionListener(e -> {
            String user = userName.getText();
            String bikeId = idEBikeField.getText();
            startRideRequest(user, bikeId);
            dispose();
        });

        cancelButton.addActionListener(e -> dispose());
    }

    private void startRideRequest(String userId, String bikeId) {
        try {
            URL url = new URL("http://localhost:8080/api/rides/start?userId=" + userId + "&bikeId=" + bikeId);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                JOptionPane.showMessageDialog(this, "Ride started successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to start ride", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the server", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
