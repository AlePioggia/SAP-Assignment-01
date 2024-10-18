package sap.ass01.frontend;

import javax.swing.*;

public class MainApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] options = { "Add User", "Add E-Bike", "Start Ride", "Stop Ride" };
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose an action",
                    "E-Bike App",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);

            switch (choice) {
                case 0 -> new UserDialog(null).setVisible(true);
                case 1 -> new AddEBikeDialog(null).setVisible(true);
                case 2 -> new RideDialog(null).setVisible(true);
                case 3 -> {
                    String rideId = JOptionPane.showInputDialog("Enter Ride ID to stop:");
                    if (rideId != null) {
                        new RideSimulationControlPanel(rideId).display();
                    }
                }
                default -> System.exit(0);
            }
        });
    }
}
