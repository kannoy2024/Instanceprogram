import java.awt.event.*;
public class HandleListener implements ActionListener {
    WindowDocument windowDocument;
    public void setView(WindowDocument windowDocument) {
        this.windowDocument = windowDocument;
    }
    public void actionPerformed(ActionEvent e){
        String str = e.getActionCommand();
        if(str.equals("copy")){
            windowDocument.showText.copy();
        }else if(str.equals("cut")){
            windowDocument.showText.cut();
        }else if(str.equals("paste")){
            windowDocument.showText.paste();
        }
    }
}
