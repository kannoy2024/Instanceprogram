import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;

public class WindowReader extends JFrame implements ActionListener {
    JFileChooser fileChooser;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem itemSave, itemOpen;
    JTextArea textArea;

    WindowReader() {
        init();
        setVisible(true);
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 修复：将 Void 改为 void
    void init() {
        textArea = new JTextArea(10, 10);
        textArea.setFont(new Font("正楷", Font.PLAIN, 20));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        menuBar = new JMenuBar();
        menu = new JMenu("文件");
        itemSave = new JMenuItem("保存");
        itemOpen = new JMenuItem("打开");

        itemSave.addActionListener(this);
        itemOpen.addActionListener(this);

        menu.add(itemSave);
        menu.add(itemOpen);
        menuBar.add(menu);

        setJMenuBar(menuBar);

        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Java 文件", "java");
        fileChooser.setFileFilter(filter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemSave) {
            int state = fileChooser.showSaveDialog(this);
            if (state == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (BufferedWriter out = new BufferedWriter(new FileWriter(selectedFile))) { // 使用 try-with-resources
                    out.write(textArea.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "保存失败: " + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == itemOpen) {
            int state = fileChooser.showOpenDialog(this);
            if (state == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                textArea.setText(""); // 清空文本区域
                try (BufferedReader in = new BufferedReader(new FileReader(selectedFile))) { // 使用 try-with-resources
                    String line;
                    while ((line = in.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "打开失败: " + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}