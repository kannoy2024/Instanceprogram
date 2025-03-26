import javax.swing.*;
import javax.swing.text.Document;

import java.awt.*;

public class WindowDocument extends JFrame{
    private static final String FONT_INPUT="微软雅黑";
    private static final String FONT_SHOW="宋体";

    JTextArea inputText;
    JTextArea showText;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem itemCopy;
    JMenuItem itemPaste;
    JMenuItem itemCut;
    TextListener textChangeListener;
    HandleListener handleListener;

    public WindowDocument(){
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init(){
        setLayout(new FlowLayout());

        inputText = new JTextArea(10,20);
        showText = new JTextArea(10,20);

        showText.setLineWrap(true);
        showText.setWrapStyleWord(true);

        Font font = new Font(FONT_INPUT, Font.PLAIN, 20);
        inputText.setFont(font);
        font = new Font(FONT_SHOW, Font.PLAIN, 20);
        showText.setFont(font);

        menuBar = new JMenuBar();
        menu = new JMenu("编辑");
        itemCopy = new JMenuItem("复制(c)");
        itemPaste = new JMenuItem("粘贴(p)");
        itemCut = new JMenuItem("剪切(x)");
        itemCopy.setAccelerator(KeyStroke.getKeyStroke('c'));
        itemPaste.setAccelerator(KeyStroke.getKeyStroke('p'));
        itemCut.setAccelerator(KeyStroke.getKeyStroke('x'));
        itemCopy.setActionCommand("copy");
        itemPaste.setActionCommand("paste");
        itemCut.setActionCommand("cut");
        
        menu.add(itemCopy);
        menu.add(itemPaste);
        menu.add(itemCut);

        menuBar.add(menu);
        setJMenuBar(menuBar);
        add(new JScrollPane(inputText));
        add(new JScrollPane(showText));

        textChangeListener = new TextListener();
        handleListener = new HandleListener();
        textChangeListener.setView(this);
        handleListener.setView(this);

        Document document = inputText.getDocument();
        document.addDocumentListener(textChangeListener);
        itemCopy.addActionListener(handleListener);
        itemPaste.addActionListener(handleListener);
        itemCut.addActionListener(handleListener);
    }
}
