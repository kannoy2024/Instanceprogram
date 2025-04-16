package cn.edu.bbc.computer;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GeoVolumeGUI extends JPanel {
	private JScrollPane upperLeftPane, upperRightPane;
	private JTextArea txtVolumeDisplay;
	private JSplitPane bigSplitPane, upSplitPane;
	private JPanel downPanel, upperLeftPanel, geoDataPanel;
	private JComboBox<String> cmbGeoForm;
	private JComboBox<String> cmbMeasure;

	private JTextField txtCylinderRadius_a;
	private JTextField txtCylinderRadius_b;
	private JTextField txtCylinderHeight;
	private JTextField txtCubeLength;
	private JTextField txtCubeWidth;
	private JTextField txtCubeHeight;
	// Ellipsoid
	private JTextField txtEllipsoidRadius_a;
	private JTextField txtEllipsoidRadius_b;
	private JTextField txtEllipsoidRadius_c;

	private ButtonHandler btnHandler;
	static final Dimension minimumSize = new Dimension(230, 200);
	public static final String COMPUTE = "Compute Volume";
	public static final String EXIT = "Exit";
	public static final String CUBE = "Cube  ";
	public static final String CYLINDER = "Cylinder";
	public static final String EllIPSOID = "Ellipsoid";// Ellipsoid
	public static final String BLANK = "Choose geometric form";
	public static final String FEET = "Feet";
	public static final String METERS = "Meters";


	public GeoVolumeGUI() {
		super(new GridLayout(1, 0));
		txtVolumeDisplay = new JTextArea(6, 30);
		txtVolumeDisplay.setFont(new Font("Arial", Font.BOLD, 12));
		txtVolumeDisplay.setBackground(Color.pink);
		txtVolumeDisplay.setText(" Volume Information will be shown here");
		btnHandler = new ButtonHandler();
		setupLowerPanel();
		setupUpperLeftPanel();
		buildUpScrollGUI();
	}

	private void setupLowerPanel() {
		downPanel = new JPanel();
		downPanel.setBackground(Color.gray);
		JButton btnSubmit = new JButton(GeoVolumeGUI.COMPUTE);
		btnSubmit.setMnemonic(KeyEvent.VK_G);
		JButton btnExit = new JButton(GeoVolumeGUI.EXIT);
		btnExit.setMnemonic(KeyEvent.VK_X);
		btnSubmit.addActionListener(btnHandler);
		btnExit.addActionListener(btnHandler);
		downPanel.add(btnSubmit);
		downPanel.add(btnExit);
	}

	private void setupUpperLeftPanel() {
		cmbGeoForm = new JComboBox<String>();
		cmbGeoForm.addItem(BLANK);
		cmbGeoForm.addItem(CUBE);
		cmbGeoForm.addItem(CYLINDER);
		cmbGeoForm.addItem(EllIPSOID);	
		cmbGeoForm.addActionListener(btnHandler);

		// For layout purposes, put the buttons in a separate panel
		upperLeftPanel = new JPanel();
		// geoDataPanel is used for loading another panel dynamically
		geoDataPanel = new JPanel();
		geoDataPanel.setPreferredSize(new Dimension(250, 180));

		GridBagLayout gridBag = new GridBagLayout();
		upperLeftPanel.setLayout(gridBag);
		GridBagConstraints gbc = new GridBagConstraints();
		upperLeftPanel.add(cmbGeoForm);
		upperLeftPanel.add(geoDataPanel);

		gbc.insets.top = 5;
		gbc.insets.bottom = 5;
		gbc.insets.left = 5;
		gbc.insets.left = 1;
		gbc.insets.right = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gridBag.setConstraints(cmbGeoForm, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gridBag.setConstraints(geoDataPanel, gbc);
	}

	public void displayVolume(String str) {
		txtVolumeDisplay.setText(str);
	}

	public String getGeoType() {
		return (String) cmbGeoForm.getSelectedItem();
	}

	public String getMeasureChoice() {
		return (String) cmbMeasure.getSelectedItem();
	}

	public JComboBox<String> getGeoShapeComBox() {
		return cmbGeoForm;
	}

	public void displayNewGUI(JPanel panel) {
		geoDataPanel.removeAll();
		geoDataPanel.add(panel);
		geoDataPanel.validate();
		validate();
	}

	private void buildUpScrollGUI() {
		upperLeftPane = new JScrollPane(upperLeftPanel);
		upperLeftPane.setMinimumSize(minimumSize);
		upperRightPane = new JScrollPane(txtVolumeDisplay);

		upSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		upSplitPane.setDividerLocation(280);
		upSplitPane.setPreferredSize(new Dimension(600, 200));
		upSplitPane.setLeftComponent(upperLeftPane);
		upSplitPane.setRightComponent(upperRightPane);

		bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upSplitPane, downPanel);
		bigSplitPane.setDividerLocation(200);

		add(bigSplitPane);
		setSize(new Dimension(600, 300));
		setVisible(true);
	}

	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Bridge Pattern- Computation of Geo Form");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GeoVolumeGUI newContentPane = new GeoVolumeGUI();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}

	static public void main(String argv[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	class ButtonHandler implements ActionListener {
		String selection = null;
		String measure = null;

		public void actionPerformed(ActionEvent e) {
			selection = getGeoType();
			Measure m = null;
			double v = 0.0d;
			GeoForm form = null;
			String suffix = null;

			if (e.getActionCommand().equals(EXIT)) {
				System.exit(1);
			}
			if (e.getActionCommand().equals(COMPUTE)) {
				if (selection.equals(CUBE)) {
					String len = txtCubeLength.getText();
					String width = txtCubeWidth.getText();
					String height = txtCubeHeight.getText();
					double l = Double.valueOf(len);
					double w = Double.valueOf(width);
					double h = Double.valueOf(height);

					form = new Cube(l, w, h);
				} else if (selection.equals(CYLINDER)) {
					String a_radius = txtCylinderRadius_a.getText();
					String b_radius = txtCylinderRadius_b.getText();
					String height = txtCylinderHeight.getText();
					double a = Double.valueOf(a_radius);
					double b = Double.valueOf(b_radius);
					double h = Double.valueOf(height);

					form = new EllipseCylinder(a, b, h);
				} else if (selection.equals((EllIPSOID))) {
					String a_radius = txtEllipsoidRadius_a.getText();
					String b_radius = txtEllipsoidRadius_b.getText();
					String c_radius = txtEllipsoidRadius_c.getText();
					double a = Double.valueOf(a_radius);
					double b = Double.valueOf(b_radius);
					double c = Double.valueOf(c_radius);
				
					form = new Ellipsoid(a, b, c);
				}

				measure = getMeasureChoice();
				if (measure.equals(FEET)) {
					m = new FootMeasure(form);
					suffix = "Cubic " + FEET;
				} else if (measure.equals(METERS)) {
					m = new MeterMeasure(form);
					suffix = "Cubic " + METERS;
				}
				v = m.findVolume();
				String description = m.convert();

				displayVolume("Volume = " + v + " " + suffix + " \n" + description);
			}
			if (e.getSource() == getGeoShapeComBox()) {
				selection = getGeoType();
				if (selection.equals(CUBE))
					displayNewGUI(getTypePanel(CUBE));
				else if (selection.equals(CYLINDER))
					displayNewGUI(getTypePanel(CYLINDER));
				else if (selection.equals(EllIPSOID)) {
					displayNewGUI(getTypePanel(EllIPSOID));
				}
				upperLeftPanel.repaint();
			}
		}
	}

	private JPanel getTypePanel(String type) {
		JPanel typePanel = new JPanel();
		cmbMeasure = new JComboBox<String>();
		cmbMeasure.addItem(FEET);
		cmbMeasure.addItem(METERS);
	
		JLabel lblMeasure = new JLabel("Measured by");
	
		if (type.equals(CUBE)) {
			JLabel lblLength = new JLabel("Input Length");
			JLabel lblWidth = new JLabel("Input width");
			JLabel lblHeight = new JLabel("Input Height");
			txtCubeLength = new JTextField(8);
			txtCubeWidth = new JTextField(8);
			txtCubeHeight = new JTextField(8);
	
			GridBagLayout gridBag = new GridBagLayout();
			typePanel.setLayout(gridBag);
			GridBagConstraints gbc = new GridBagConstraints();
	
			typePanel.add(lblLength);
			typePanel.add(lblWidth);
			typePanel.add(lblHeight);
			typePanel.add(lblMeasure);
	
			typePanel.add(txtCubeLength);
			typePanel.add(txtCubeWidth);
			typePanel.add(txtCubeHeight);
			typePanel.add(cmbMeasure);
	
			gbc.insets.top = 5;
			gbc.insets.bottom = 5;
			gbc.insets.left = 1;
			gbc.insets.right = 8;
	
			gbc.anchor = GridBagConstraints.WEST;
			gbc.gridx = 0;
			gbc.gridy = 0;
			gridBag.setConstraints(lblLength, gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			gridBag.setConstraints(txtCubeLength, gbc);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gridBag.setConstraints(lblWidth, gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			gridBag.setConstraints(txtCubeWidth, gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gridBag.setConstraints(lblHeight, gbc);
			gbc.gridx = 1;
			gbc.gridy = 2;
			gridBag.setConstraints(txtCubeHeight, gbc);
			gbc.gridx = 0;
			gbc.gridy = 3;
			gridBag.setConstraints(lblMeasure, gbc);
			gbc.gridx = 1;
			gbc.gridy = 3;
			gridBag.setConstraints(cmbMeasure, gbc);
		} else if (type.equals(CYLINDER)) {
			JLabel lblRadius_a = new JLabel("Input Radius a");
			JLabel lblRadius_b = new JLabel("Input Radius b");
			JLabel lblHeight = new JLabel("Input Height");
	
			txtCylinderRadius_a = new JTextField(8);
			txtCylinderRadius_b = new JTextField(8);
			txtCylinderHeight = new JTextField(8);
	
			GridBagLayout gridBag = new GridBagLayout();
			typePanel.setLayout(gridBag);
			GridBagConstraints gbc = new GridBagConstraints();
	
			typePanel.add(lblRadius_a);
			typePanel.add(lblRadius_b);
			typePanel.add(lblHeight);
	
			typePanel.add(txtCylinderRadius_a);
			typePanel.add(txtCylinderRadius_b);
	
			typePanel.add(txtCylinderHeight);
			typePanel.add(lblMeasure);
			typePanel.add(cmbMeasure);
	
			gbc.insets.top = 5;
			gbc.insets.bottom = 5;
			gbc.insets.left = 1;
			gbc.insets.right = 8;
	
			gbc.anchor = GridBagConstraints.WEST;
			gbc.gridx = 0;
			gbc.gridy = 0;
			gridBag.setConstraints(lblRadius_a, gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			gridBag.setConstraints(txtCylinderRadius_a, gbc);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gridBag.setConstraints(lblRadius_b, gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			gridBag.setConstraints(txtCylinderRadius_b, gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gridBag.setConstraints(lblHeight, gbc);
			gbc.gridx = 1;
			gbc.gridy = 2;
			gridBag.setConstraints(txtCylinderHeight, gbc);
			gbc.gridx = 0;
			gbc.gridy = 3;
			gridBag.setConstraints(lblMeasure, gbc);
			gbc.gridx = 1;
			gbc.gridy = 3;
			gridBag.setConstraints(cmbMeasure, gbc);
		} else if (type.equals(EllIPSOID)) {
			JLabel lblRadius_a = new JLabel("Input Radius a");
			JLabel lblRadius_b = new JLabel("Input Radius b");
			JLabel lblRadius_c = new JLabel("Input Radius c");
	
			// 使用类级别的成员变量
			txtEllipsoidRadius_a = new JTextField(8);
			txtEllipsoidRadius_b = new JTextField(8);
			txtEllipsoidRadius_c = new JTextField(8);
	
			GridBagLayout gridBag = new GridBagLayout();
			typePanel.setLayout(gridBag);
			GridBagConstraints gbc = new GridBagConstraints();
	
			typePanel.add(lblRadius_a);
			typePanel.add(lblRadius_b);
			typePanel.add(lblRadius_c);
			typePanel.add(lblMeasure);
	
			typePanel.add(txtEllipsoidRadius_a);
			typePanel.add(txtEllipsoidRadius_b);
			typePanel.add(txtEllipsoidRadius_c);
			typePanel.add(cmbMeasure);
	
			gbc.insets.top = 5;
			gbc.insets.bottom = 5;
			gbc.insets.left = 1;
			gbc.insets.right = 8;
	
			gbc.anchor = GridBagConstraints.WEST;
			gbc.gridx = 0;
			gbc.gridy = 0;
			gridBag.setConstraints(lblRadius_a, gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			gridBag.setConstraints(txtEllipsoidRadius_a, gbc);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gridBag.setConstraints(lblRadius_b, gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			gridBag.setConstraints(txtEllipsoidRadius_b, gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gridBag.setConstraints(lblRadius_c, gbc);
			gbc.gridx = 1;
			gbc.gridy = 2;
			gridBag.setConstraints(txtEllipsoidRadius_c, gbc);
			gbc.gridx = 0;
			gbc.gridy = 3;
			gridBag.setConstraints(lblMeasure, gbc);
			gbc.gridx = 1;
			gbc.gridy = 3;
			gridBag.setConstraints(cmbMeasure, gbc);
		}
		return typePanel;
	}
}