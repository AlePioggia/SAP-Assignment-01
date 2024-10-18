package sap.ass01.frontend;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class AddEBikeDialog extends JDialog {

    private JTextField idField;
    private JTextField xCoordField;
    private JTextField yCoordField;
    private JButton okButton;
    private JButton cancelButton;

    public AddEBikeDialog(Frame owner) {
        super(owner, "Adding E-Bike", true);
        initializeComponents();
        setupLayout();
        addEventHandlers();
        pack();
        setLocationRelativeTo(owner);
    }

    private void initializeComponents() {
        idField = new JTextField(15);
        xCoordField = new JTextField(15);
        yCoordField = new JTextField(15);
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
    }

    private void setupLayout() {
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.add(new JLabel("E-Bike ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("E-Bike location - X coord:"));
        inputPanel.add(xCoordField);
        inputPanel.add(new JLabel("E-Bike location - Y coord:"));
        inputPanel.add(yCoordField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addEventHandlers() {
        okButton.addActionListener(e -> {
            String id = idField.getText();
            String xCoord = xCoordField.getText();
            String yCoord = yCoordField.getText();
            addEBikeRequest(id, Integer.parseInt(xCoord), Integer.parseInt(yCoord));
            dispose();
        });

        cancelButton.addActionListener(e -> dispose());
    }

    private void addEBikeRequest(String id, int x, int y) {
        try {
            URL url = new URL("http://localhost:8080/api/ebikes/add?eBikeId=" + id + "&x=" + x + "&y=" + y);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                JOptionPane.showMessageDialog(this, "E-Bike added successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add E-Bike", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the server", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
