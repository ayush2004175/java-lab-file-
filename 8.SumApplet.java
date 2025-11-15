import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="SumApplet" width=300 height=200>
</applet>
*/

public class SumApplet extends Applet implements ActionListener {

    TextField num1, num2, result;
    Button addButton;

    public void init() {
        Label l1 = new Label("Enter first number: ");
        Label l2 = new Label("Enter second number: ");
        Label l3 = new Label("Sum: ");

        num1 = new TextField(10);
        num2 = new TextField(10);
        result = new TextField(10);
        result.setEditable(false);

        addButton = new Button("Add");
        addButton.addActionListener(this);

        add(l1); add(num1);
        add(l2); add(num2);
        add(addButton);
        add(l3); add(result);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            int sum = n1 + n2;

            result.setText(String.valueOf(sum));

        } catch (Exception ex) {
            result.setText("Invalid Input");
        }
    }
}
