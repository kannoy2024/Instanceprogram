import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PoliceListener implements ActionListener {
    private WindowView view;

    public void setView(WindowView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = getInputText();
        if (e.getSource() == view.inputText) {
            view.textArea.append("\"" + str + "\"的长度: " + str.length() + "\n");
        } else if (e.getSource() == view.button) {
            view.textArea.append(str + "\n");
        }
    }

    private String getInputText() {
        return view.inputText.getText();
    }
}