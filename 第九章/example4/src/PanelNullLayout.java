import javax.swing.*;

public class PanelNullLayout extends JPanel {
    JButton button;
    JTextField text;
    PanelNullLayout() {
        setLayout(null);
        button = new JButton("Click Me");
        text = new JTextField("Enter Text Here");
        add(text);
        add(button);
        text.setBounds(100,30,90,30);
        button.setBounds(100,70,90,30);
    }
}
