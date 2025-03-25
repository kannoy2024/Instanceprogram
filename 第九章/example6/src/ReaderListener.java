import java.awt.event.ActionListener;
public class ReaderListener implements ActionListener{
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String str=e.getActionCommand();
        System.out.println(str+":"+str.length());//Monitor click events and print the length of the string
        System.out.println("TEXT");

    }
}
