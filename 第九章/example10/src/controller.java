import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controller implements ActionListener {
    private windowTriangleView windowTriangleView;

    public void setView(windowTriangleView windowTriangleView) {
        this.windowTriangleView = windowTriangleView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // 获取用户输入的三边长度
            double a = Double.parseDouble(windowTriangleView.sideA.getText().trim());
            double b = Double.parseDouble(windowTriangleView.sideB.getText().trim());
            double c = Double.parseDouble(windowTriangleView.sideC.getText().trim());

            // 设置三角形的三边
            windowTriangleView.triangle.setSideA(a);
            windowTriangleView.triangle.setSideB(b);
            windowTriangleView.triangle.setSideC(c);

            // 计算并格式化面积
            String areaText = String.format("%.3f", windowTriangleView.triangle.getArea());

            // 更新界面显示
            windowTriangleView.showArea.setText("\nTriangle:\n" + areaText);
        } catch (Exception ex) {
            // 捕获异常并提示无效输入
            windowTriangleView.showArea.setText("\nTriangle:\nInvalid input");
        }
    }
}