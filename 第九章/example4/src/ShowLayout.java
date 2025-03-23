import javax.swing.*;
import java.awt.*;

public class ShowLayout extends JFrame{
    PanelGridLayout panelGrid;
    PanelNullLayout panelNull;
    
    JTabbedPane tabbedPane;
    ShowLayout(){
        panelGrid = new PanelGridLayout();
        panelNull = new PanelNullLayout();
        tabbedPane = new JTabbedPane();
        tabbedPane.add("Grid layout panel",panelGrid);
        tabbedPane.add("Null layout panel",panelNull);
        add(tabbedPane,BorderLayout.CENTER);
        add(new JButton("This window is BorderLayout panel"),BorderLayout.NORTH);
        add(new JButton("south"),BorderLayout.SOUTH);
        add(new JButton("west"),BorderLayout.WEST);
        add(new JButton("east"),BorderLayout.EAST);
        setBounds(10,10,400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }
}
