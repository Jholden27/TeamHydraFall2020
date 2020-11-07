package grizzlyPunk;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JTree;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Component;
import javax.swing.Box;

public class GUI {

	private JFrame frame;
	private JTextField txtInventory;
	private JTextField txtEquippedWeapon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(960, 720));
		frame.setSize(new Dimension(960, 720));
		frame.getContentPane().setSize(new Dimension(960, 720));
		frame.getContentPane().setMinimumSize(new Dimension(960, 720));
		frame.setResizable(false);
		frame.getContentPane().setPreferredSize(new Dimension(960, 720));
		frame.setPreferredSize(new Dimension(960, 720));
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		
		txtInventory = new JTextField();
		txtInventory.setBorder(null);
		txtInventory.setEditable(false);
		txtInventory.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		txtInventory.setOpaque(false);
		txtInventory.setText("Inventory");
		txtInventory.setBounds(746, 45, 75, 20);
		frame.getContentPane().add(txtInventory);
		txtInventory.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setName("Map");
		panel.setBackground(new Color(85, 107, 47));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(85, 107, 47), 1, true), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(313, 18, 265, 318);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(6, 15, 253, 297);
		panel.add(canvas);
		canvas.setBackground(new Color(255, 248, 220));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(85, 107, 47), 5));
		panel_2.setBackground(new Color(255, 248, 220));
		panel_2.setBounds(0, 340, 946, 60);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JProgressBar shieldBar = new JProgressBar();
		shieldBar.setValue(100);
		shieldBar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		shieldBar.setName("Shield:");
		shieldBar.setBounds(345, 10, 200, 15);
		panel_2.add(shieldBar);
		shieldBar.setBackground(Color.GRAY);
		shieldBar.setForeground(new Color(176, 224, 230));
		
		JProgressBar healthBar = new JProgressBar();
		healthBar.setValue(100);
		healthBar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		healthBar.setName("HP:");
		healthBar.setBounds(365, 35, 160, 15);
		panel_2.add(healthBar);
		healthBar.setBackground(Color.GRAY);
		healthBar.setForeground(new Color(205, 92, 92));
		
		txtEquippedWeapon = new JTextField();
		txtEquippedWeapon.setText("Equipped Weapon:");
		txtEquippedWeapon.setOpaque(false);
		txtEquippedWeapon.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		txtEquippedWeapon.setEditable(false);
		txtEquippedWeapon.setColumns(10);
		txtEquippedWeapon.setBorder(null);
		txtEquippedWeapon.setBounds(695, 15, 178, 23);
		panel_2.add(txtEquippedWeapon);
		
		JLabel lblNewLabel_1 = new JLabel("\t\t\tMemories");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setToolTipText("Memories collected.");
		lblNewLabel_1.setBounds(62, 138, 183, 192);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea console = new JTextArea();
		console.setBackground(Color.GRAY);
		console.setBorder(new LineBorder(new Color(85, 107, 47), 9));
		console.setBounds(0, 435, 946, 247);
		frame.getContentPane().add(console);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 399, 923, 34);
		frame.getContentPane().add(toolBar);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.setMargin(new Insets(0, 100, 0, 100));
		toolBar.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Move");
		mnNewMenu.setBackground(Color.GRAY);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Move North");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Move South");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Move East");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Move West");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_1);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuBar_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		menuBar_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		menuBar_1.setMargin(new Insets(0, 100, 0, 100));
		toolBar.add(menuBar_1);
		
		JMenu mnAttack = new JMenu("Attack");
		mnAttack.setBorder(null);
		mnAttack.setBackground(Color.GRAY);
		menuBar_1.add(mnAttack);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Move North");
		mnAttack.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Move South");
		mnAttack.add(mntmNewMenuItem_1_1);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("Move East");
		mnAttack.add(mntmNewMenuItem_2_1);
		
		JMenuItem mntmNewMenuItem_3_1 = new JMenuItem("Move West");
		mnAttack.add(mntmNewMenuItem_3_1);
		
		JList list = new JList();
		list.setBackground(new Color(255, 248, 220));
		list.setBounds(679, 66, 205, 225);
		frame.getContentPane().add(list);
		
		JLabel lblNewLabel = new JLabel("GrizzlyPunk");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(new Color(85, 107, 47));
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		lblNewLabel.setBounds(34, 18, 246, 84);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(85, 107, 47));
		panel_1.setBounds(679, 46, 205, 20);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(85, 107, 47));
		panel_1_1.setBounds(679, 291, 205, 20);
		frame.getContentPane().add(panel_1_1);
	}
}
