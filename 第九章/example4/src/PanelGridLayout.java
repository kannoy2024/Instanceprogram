import javax.swing.*;
import java.awt.*;

public class PanelGridLayout extends JPanel{
    PanelGridLayout(){
        GridLayout gridLayout = new GridLayout(12,12);
        setLayout(gridLayout);
        Label label[][]= new Label[12][12];
        for(int i=0;i<12;i++){
            for(int j=0;j<12;j++){
                label[i][j]=new Label();
                if((i+j)%2==0){
                    label[i][j].setBackground(Color.white);
                }else{
                    label[i][j].setBackground(Color.black);
                }
                add(label[i][j]);
            }
        }
    }
}
