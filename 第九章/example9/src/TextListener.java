import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.util.Arrays;
public class TextListener implements DocumentListener {
    WindowDocument windowDocument;

    public void setView(WindowDocument windowDocument){
        this.windowDocument = windowDocument;
    }

    public void changedUpdate(DocumentEvent e){
        String str = windowDocument.inputText.getText();//获取输入框内容
        String regex = "[\\s\\d\\p{Punct}]+";
        String words[]= str.split(regex);
        Arrays.sort(words);
        windowDocument.showText.setText(null);
        for(int i=0;i<words.length;i++){
            windowDocument.showText.append(words[i]+"*");
        }
    }


    public void removeUpdate(DocumentEvent e){
        changedUpdate(e);
    }


    public void insertUpdate(DocumentEvent e){
        changedUpdate(e);
    }
}
