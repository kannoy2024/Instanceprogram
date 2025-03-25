import java.awt.event.*;

public class OperatorListener implements ItemListener,ActionListener{
    NumberView numberView;
    public void setView(NumberView view){
        numberView = view;
    }
    public void itemStateChanged(ItemEvent e){
        String operator =numberView
        .selectOperationSymbol
        .getSelectedItem()
        .toString();

        numberView
        .computerListener
        .setOperationSymbol(operator);
    }
    public void actionPerformed(ActionEvent e){
        String operator =numberView
        .selectOperationSymbol
        .getSelectedItem()
        .toString();
        
        numberView
        .computerListener
        .setOperationSymbol(operator);
    }
}
