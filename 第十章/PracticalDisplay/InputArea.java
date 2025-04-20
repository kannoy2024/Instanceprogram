
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

public class InputArea extends JPanel implements ActionListener {
    File file = null;
    RandomAccessFile out;
    Box baseBox, box1, box2;
    JTextField name, email, phone;
    JButton button;

    InputArea(File file) {
        this.file = file;
        setBackground(Color.white);

        name = new JTextField(12);
        email = new JTextField(12);
        phone = new JTextField(12);
        button = new JButton("提交");
        button.addActionListener(this);

        box1 = Box.createHorizontalBox();
        box1.add(new JLabel("请输入姓名"));
        box1.add(Box.createHorizontalStrut(8));
        box1.add(new JLabel("请输入邮箱"));
        box1.add(Box.createHorizontalStrut(8));
        box1.add(new JLabel("请输入电话"));
        box1.add(Box.createHorizontalStrut(8));
        box1.add(button);

        box2 = Box.createVerticalBox(); // 初始化 box2
        box2.add(name);
        box2.add(Box.createVerticalStrut(8));
        box2.add(email);
        box2.add(Box.createVerticalStrut(8));
        box2.add(phone);
        box2.add(Box.createVerticalStrut(8));

        baseBox = Box.createVerticalBox();
        baseBox.add(box1);
        baseBox.add(Box.createVerticalStrut(10));
        baseBox.add(box2);
        add(baseBox);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            RandomAccessFile out = new RandomAccessFile(file, "rw");
            if (file.exists()) {
                out.seek(out.length());
            }
            out.writeUTF(name.getText());
            out.writeUTF(email.getText());
            out.writeUTF(phone.getText());
            out.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}