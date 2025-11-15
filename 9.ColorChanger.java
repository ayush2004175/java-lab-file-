import java.awt.*;
import java.awt.event.*;

public class ColorChanger extends Frame implements ActionListener {

    Button changeColorButton;

    public ColorChanger() {
        // Frame settings
        setTitle("AWT Color Change Example");
        setSize(400, 300);
        setLayout(new FlowLayout());

        // Button
        changeColorButton = new Button("Change Background");
        add(changeColorButton);

        // Event handling
        changeColorButton.addActionListener(this);

        // Window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    // When button is clicked
    public void actionPerformed(ActionEvent e) {
        // Generate a random color
        Color randomColor = new Color(
                (int)(Math.random() * 256),
                (int)(Math.random() * 256),
                (int)(Math.random() * 256)
        );
        setBackground(randomColor);
    }

    public static void main(String[] args) {
        new ColorChanger();
    }
}
