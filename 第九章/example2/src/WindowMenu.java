import javax.swing.*;

public class WindowMenu extends JFrame {
    JMenuBar menuBar;
    JMenu menuFruit;
    JMenuItem bananaItem,pearItem;
    JMenu appleMenu;
    JMenuItem appleItem,orangeItem;
    public WindowMenu() {
    }
    public WindowMenu(String s,int x,int y,int w,int h){
        init(s);
        setLocation(x, y);
        setSize(w, h);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    void init(String s){
        setTitle(s);
        menuBar = new JMenuBar();
        menuFruit = new JMenu("水果菜单");
        bananaItem = new JMenuItem("香蕉");
        bananaItem.setIcon(new ImageIcon("banana.jpg"));
        pearItem = new JMenuItem("梨");
        pearItem.setIcon(new ImageIcon("pear.jpg"));
        appleMenu = new JMenu("苹果，和橙子");
        appleItem = new JMenuItem("苹果");
        appleItem.setIcon(new ImageIcon("apple.jpg"));
        orangeItem = new JMenuItem("橙子");
        orangeItem.setIcon(new ImageIcon("orange.jpg"));

        menuFruit.add(bananaItem);//add menu items to menu
        menuFruit.add(pearItem);
        menuFruit.addSeparator();//add a dividing line in the menu
        menuFruit.add(appleMenu);
        appleMenu.add(appleItem);
        appleMenu.add(orangeItem);

        menuBar.add(menuFruit);
        setJMenuBar(menuBar);
    }

}

