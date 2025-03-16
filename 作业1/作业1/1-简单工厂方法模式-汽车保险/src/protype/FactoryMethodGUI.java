package protype;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class FactoryMethodGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSplitPane bigSplitPane;
	private JScrollPane showInfoPane;
	private JPanel btnPanel;
	private JComboBox<String> cmbInsuranceType;
	private JLabel lblInsureType;
	private JTextArea txtForInfo;

	public static final String SHOW = "显示信息";
	public static final String EXIT = "退出";
	public static final String BODYINJURE = "人身伤害责任险";
	public static final String COLLISION = "碰撞保险";
	public static final String PERSONINJURE = "个人伤害保护";
	public static final String RentalReimbursement = "租赁费用报销";

	public FactoryMethodGUI() {
		super("工厂方法模式-汽车保险");
		new Dimension(130, 100);
		setUpChoicePanel();
		setUpScrollPanes();
	}

	private void setUpChoicePanel() {
		cmbInsuranceType = new JComboBox<String>();
		cmbInsuranceType.addItem(BODYINJURE);
		cmbInsuranceType.addItem(COLLISION);
		cmbInsuranceType.addItem(PERSONINJURE);
		cmbInsuranceType.addItem(RentalReimbursement);

		lblInsureType = new JLabel("保险类型");

		// 创建显示信息按钮
		JButton showInfoBtn = new JButton(SHOW);
		showInfoBtn.setMnemonic(KeyEvent.VK_S);
		JButton exitButton = new JButton(EXIT);
		exitButton.setMnemonic(KeyEvent.VK_X);

		ButtonListener btnListener = new ButtonListener();

		// 添加动作监听器
		showInfoBtn.addActionListener(btnListener);
		exitButton.addActionListener(btnListener);

		btnPanel = new JPanel();

		// ------------------------------------------------
		GridBagLayout gridbag = new GridBagLayout();
		btnPanel.setLayout(gridbag);
		GridBagConstraints gbc = new GridBagConstraints();

		btnPanel.add(lblInsureType);
		btnPanel.add(cmbInsuranceType);
		btnPanel.add(showInfoBtn);
		btnPanel.add(exitButton);

		gbc.insets.top = 5;
		gbc.insets.bottom = 5;
		gbc.insets.left = 5;
		gbc.insets.right = 5;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gridbag.setConstraints(lblInsureType, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gridbag.setConstraints(cmbInsuranceType, gbc);

		gbc.insets.left = 2;
		gbc.insets.right = 2;
		gbc.insets.top = 15;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gridbag.setConstraints(showInfoBtn, gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 5;
		gridbag.setConstraints(exitButton, gbc);
		// -----------------------------------------------
	}

	private void setUpScrollPanes() {
		txtForInfo = new JTextArea("汽车保险信息将在此显示", 20, 30);
		txtForInfo.setFont(new Font("Helvetica", Font.BOLD, 15));

		txtForInfo.setLineWrap(true);
		txtForInfo.setBackground(Color.pink);

		showInfoPane = new JScrollPane(txtForInfo);

		bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, showInfoPane, btnPanel);
		bigSplitPane.setDividerLocation(220);

		getContentPane().add(bigSplitPane);
		setSize(new Dimension(559, 419));
		setVisible(true);
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			if (ae.getActionCommand().equals(EXIT)) {
				System.exit(1);
			}
			if (ae.getActionCommand().equals(SHOW)) {
				String type = (String) cmbInsuranceType.getSelectedItem();
				String description = "";

				if (type.equals(BODYINJURE)) {
					description = "人身伤害责任险: \n\n此保险支付因您的车辆造成他人受伤或死亡的医疗费用、"
							+ "误工费、康复治疗费用以及/或丧葬费用。当第三方成功起诉时，该保险还支付痛苦赔偿金。";
				} else if (type.equals(COLLISION)) {
					description = "碰撞保险: \n\n无论谁是责任方，此保险支付您车辆的损坏费用，减去任何免赔额。"
							+ "如果您的车辆是贷款购买的，贷款方可能会要求您购买此保险，并可能要求特定的免赔额金额。";
				} else if (type.equals(PERSONINJURE)) {
					description = "个人伤害保护 \n\n无论事故是谁引起的，此保险支付您或任何授权驾驶您车辆的人的医疗费用和部分误工费。";
				} else if (type.equals(RentalReimbursement)){
					description = "租赁费用报销 \n\n此保险支付您为租赁车辆支付的费用，包括但不限于："
							+ "租赁费用、租赁服务、租赁车辆、租赁车辆租赁服务";
				}

				txtForInfo.setText(description);
			}
		}
	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception evt) {
		}

		FactoryMethodGUI frame = new FactoryMethodGUI();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setSize(500, 420);
		frame.setVisible(true);
	}
}