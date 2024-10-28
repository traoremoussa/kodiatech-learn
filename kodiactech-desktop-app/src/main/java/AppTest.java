import javax.swing.*;

public class AppTest {
    public static void main(String[] args) {
        // Run the GUI code on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Swing Application");
            JButton button = new JButton("Click Me");

            // Add action listener to the button
            button.addActionListener(e ->
                    JOptionPane.showMessageDialog(frame, "Button Clicked!")
            );

            frame.add(button);
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
