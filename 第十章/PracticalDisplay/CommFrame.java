import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class CommFrame extends JFrame implements ActionListener {
    File file  = null;
    JMenuBar bar;
    JMenu fileMenu;
    JMenuItem inputMenuItem, showMenuItem;
    JTextArea show;
    InputArea inputArea;
    CardLayout card = null;
    JPanel pCenter;
    CommFrame() {
        file = new File("通讯录.txt");
        inputMenuItem = new JMenuItem("输入");
        showMenuItem = new JMenuItem("显示");
        bar = new JMenuBar();
        fileMenu = new JMenu("文件");
        fileMenu.add(inputMenuItem);
        fileMenu.add(showMenuItem);
        bar.add(fileMenu);
        setJMenuBar(bar);
        inputMenuItem.addActionListener(this);
        showMenuItem.addActionListener(this);
        inputArea = new InputArea(file);
        show = new JTextArea(12,20);
        card = new CardLayout();
        pCenter = new JPanel();
        pCenter.setLayout(card);
        pCenter.add("inputMenuItem",inputMenuItem);
        pCenter.add("showMenuItem",show);
        add(pCenter,"Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(100,100,400,300);
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inputMenuItem) {
            card.show(pCenter,"input");
        } else if (e.getSource() == showMenuItem) {
            int number = 1;
            show.setText(null);
            card.show(pCenter,"show");
            try {
                RandomAccessFile in = new RandomAccessFile(file,"r");
                String name = null;
                while ((name = in.readUTF())!= null) {
                    show.append("\n"+number+"."+name);
                    show.append("\t"+in.readUTF());
                    show.append("\t"+in.readUTF());
                    show.append("\n------------------------------");
                    number++;
                }
                in.close();
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }
}
