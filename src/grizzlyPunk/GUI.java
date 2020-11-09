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
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
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
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.DebugGraphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;

public class GUI {
	public static String readFile(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }


	private JFrame frame;
	private JTextField txtInventory;
	private JTextField txtEquippedWeapon;
	private JTextField txtShield;
	private JTextField txtHp;
	private final Component horizontalStrut_1_1 = Box.createHorizontalStrut(120);
	private JTextField txtMemories;
	private JLabel lblNewLabel;
	public static PrintStream printStream;
	
	//TEST 
	int getMemoryFragments = 0;
	String getWeapon = "Plasma Sword";
	//TEST
	private JList list;
	private JList goList;
	public static JTextArea console = new JTextArea();
	
	

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
		frame.setMinimumSize(new Dimension(1280, 1024));
		frame.setSize(new Dimension(1280, 1024));
		frame.getContentPane().setSize(new Dimension(1280, 1024));
		frame.getContentPane().setMinimumSize(new Dimension(1280, 1024));
		frame.setResizable(false);
		frame.getContentPane().setPreferredSize(new Dimension(1280, 1024));
		frame.setPreferredSize(new Dimension(1280, 1024));
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		
		txtMemories = new JTextField();
		txtMemories.setText("Memories");
		txtMemories.setOpaque(false);
		txtMemories.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 23));
		txtMemories.setEditable(false);
		txtMemories.setColumns(10);
		txtMemories.setBorder(null);
		txtMemories.setBounds(267, 290, 105, 20);
		frame.getContentPane().add(txtMemories);
		
		JLabel lblNewLabel_2_1 = new JLabel("GrizzlyPunk");
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1.setForeground(new Color(85, 107, 47));
		lblNewLabel_2_1.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblNewLabel_2_1.setBounds(62, 16, 300, 46);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		txtInventory = new JTextField();
		txtInventory.setBorder(null);
		txtInventory.setEditable(false);
		txtInventory.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		txtInventory.setOpaque(false);
		txtInventory.setText("Inventory");
		txtInventory.setBounds(956, 44, 75, 20);
		frame.getContentPane().add(txtInventory);
		txtInventory.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setName("Map");
		panel.setBackground(new Color(85, 107, 47));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(85, 107, 47), 1, true), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(433, 0, 420, 367);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 5));
		lblNewLabel_1.setBounds(10, 10, 400, 350);
		panel.add(lblNewLabel_1);
		Image gpMap = new ImageIcon (this.getClass().getResource("GP-" + Player.getCurrentRoom().getRoomID() + ".png")).getImage();
		Image scaled = gpMap.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(scaled));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(85, 107, 47), 7));
		panel_2.setBackground(new Color(255, 248, 220));
		panel_2.setBounds(0, 362, 1271, 60);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		txtHp = new JTextField();
		txtHp.setText("Health: " + Player.getCurrentHP());
		txtHp.setOpaque(false);
		txtHp.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		txtHp.setEditable(false);
		txtHp.setColumns(10);
		txtHp.setBorder(null);
		txtHp.setBounds(560, 32, 125, 20);
		panel_2.add(txtHp);
		
		txtShield = new JTextField();
		txtShield.setText("Shield: " + Player.getSp());
		txtShield.setOpaque(false);
		txtShield.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		txtShield.setEditable(false);
		txtShield.setColumns(10);
		txtShield.setBorder(null);
		txtShield.setBounds(540, 7, 75, 20);
		panel_2.add(txtShield);
		
		JProgressBar shieldBar = new JProgressBar();
		shieldBar.setMaximum(50);
		shieldBar.setValue(Player.getSp());
		shieldBar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		shieldBar.setName("Shield:");
		shieldBar.setBounds(533, 10, 200, 15);
		panel_2.add(shieldBar);
		shieldBar.setBackground(Color.GRAY);
		shieldBar.setForeground(new Color(176, 224, 230));
		
		JProgressBar healthBar = new JProgressBar();
		healthBar.setMaximum(Player.getMaxHP());
		healthBar.setValue(Player.getCurrentHP());
		healthBar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		healthBar.setName("HP:");
		healthBar.setBounds(553, 35, 160, 15);
		panel_2.add(healthBar);
		healthBar.setBackground(Color.GRAY);
		healthBar.setForeground(new Color(240, 128, 128));
		
		txtEquippedWeapon = new JTextField();
		txtEquippedWeapon.setText("Equipped Weapon: " + getWeapon);
		txtEquippedWeapon.setOpaque(false);
		txtEquippedWeapon.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		txtEquippedWeapon.setEditable(false);
		txtEquippedWeapon.setColumns(10);
		txtEquippedWeapon.setBorder(null);
		txtEquippedWeapon.setBounds(878, 10, 250, 23);
		panel_2.add(txtEquippedWeapon);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(null);
		lblNewLabel.setSize(new Dimension(225, 225));
		lblNewLabel.setPreferredSize(new Dimension(225, 225));
		lblNewLabel.setMinimumSize(new Dimension(225, 225));
		lblNewLabel.setMaximumSize(new Dimension(225, 225));
		Image mem = new ImageIcon (this.getClass().getResource("Mem" + getMemoryFragments + ".png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(mem));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setToolTipText("Memories collected.");
		lblNewLabel.setBounds(90, 119, 225, 225);
		frame.getContentPane().add(lblNewLabel);
		console.setLineWrap(true);
		console.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		
		
		
		
		console.setBackground(new Color(255, 248, 220));
		console.setBorder(new MatteBorder(20, 1, 20, 1, (Color) new Color(85, 107, 47)));
		console.setBounds(0, 482, 1266, 514);
		frame.getContentPane().add(console);
		console.setEditable (false);		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.LIGHT_GRAY);
		toolBar.setForeground(Color.GRAY);
		toolBar.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(85, 107, 47), new Color(160, 160, 160)), "ActionBar", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		toolBar.setBounds(31, 427, 1213, 50);
		frame.getContentPane().add(toolBar);
		
		Component horizontalStrut = Box.createHorizontalStrut(210);
		toolBar.add(horizontalStrut);
		
		//GO TO MENU
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLocation(new Point(0, 10));
		menuBar.setBorder(new MatteBorder(1, 5, 1, 5, (Color) new Color(85, 107, 47)));
		menuBar.setMargin(new Insets(0, 100, 10, 100));
		toolBar.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Go To...");
		mnNewMenu.setBorder(null);
		mnNewMenu.setBackground(new Color(192, 192, 192));
		menuBar.add(mnNewMenu);
		
		//JList goList = new JList();
		goList = new JList(Player.getCurrentRoom().roomConnections.toArray());
		goList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Player.move((String) goList.getSelectedValue());
				Image gpMap = new ImageIcon (this.getClass().getResource("GP-" + (String) goList.getSelectedValue() + ".png")).getImage();
				Image scaled = gpMap.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),Image.SCALE_SMOOTH);
				lblNewLabel_1.setIcon(new ImageIcon(scaled));
				System.out.println((String) goList.getSelectedValue());
			}
		});
		//list.setBackground(new Color(255, 248, 220));
		//list.setBounds(889, 65, 205, 225);
		//frame.getContentPane().add(list);
		mnNewMenu.add(goList);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(120);
		toolBar.add(horizontalStrut_1);
		
		
		//ATTACK MENU
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuBar_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		menuBar_1.setBorder(new MatteBorder(1, 5, 1, 5, (Color) new Color(85, 107, 47)));
		menuBar_1.setMargin(new Insets(0, 100, 0, 100));
		toolBar.add(menuBar_1);
		
		JMenu mnAttack = new JMenu("Attack");
		mnAttack.setBorder(null);
		mnAttack.setBackground(Color.GRAY);
		menuBar_1.add(mnAttack);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Attack the head");
		mnAttack.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Attack the arms");
		mnAttack.add(mntmNewMenuItem_1_1);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("Attack the legs");
		mnAttack.add(mntmNewMenuItem_2_1);
		
		JMenuItem mntmNewMenuItem_3_1 = new JMenuItem("Flail wildly");
		mnAttack.add(mntmNewMenuItem_3_1);
		toolBar.add(horizontalStrut_1_1);
		
		
		//EXPLORE MENU
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setBorder(new MatteBorder(1, 5, 1, 5, (Color) new Color(85, 107, 47)));
		toolBar.add(menuBar_3);
		
		JMenu mnNewMenu_2 = new JMenu("Explore");
		mnNewMenu_2.setBorder(null);
		menuBar_3.add(mnNewMenu_2);
		
		JMenuItem explore1 = new JMenuItem("Explore Area");
		explore1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Player.explore();
			}
		});
		mnNewMenu_2.add(explore1);
		
		JMenuItem explore2 = new JMenuItem("Pickup Items in Area");
		mnNewMenu_2.add(explore2);
		
		Component horizontalStrut_1_1_1 = Box.createHorizontalStrut(120);
		toolBar.add(horizontalStrut_1_1_1);
		
		
		//HELP MENU
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBorder(new MatteBorder(1, 5, 1, 5, (Color) new Color(85, 107, 47)));
		toolBar.add(menuBar_2);
		
		JMenu mnNewMenu_1 = new JMenu("Help");
		mnNewMenu_1.setBorder(null);
		menuBar_2.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Command List");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.help();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		Component horizontalStrut_1_1_2 = Box.createHorizontalStrut(120);
		toolBar.add(horizontalStrut_1_1_2);
		
		
		//GAME OPTIONS MENU
		JMenuBar menuBar_4 = new JMenuBar();
		menuBar_4.setBorder(new MatteBorder(1, 5, 1, 5, (Color) new Color(85, 107, 47)));
		toolBar.add(menuBar_4);
		
		JMenu mnNewMenu_4 = new JMenu("Game Options");
		mnNewMenu_4.setBorder(null);
		menuBar_4.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Save Game");
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		//SAVE ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
		
				mntmNewMenuItem_8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {				
						try {
						      FileWriter myWriter = new FileWriter("SAVEDGAME.txt");
						      myWriter.write("" + Player.getCurrentRoom().getRoomID());
						      myWriter.close();
						      System.out.println("Game Saved.");
						    } catch (IOException e2) {
						      System.out.println("An error occurred.");
						      e2.printStackTrace();
						    }	
					}
				});

				
				//SAVE ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
				
				mnNewMenu_4.add(mntmNewMenuItem_8);
				
				JMenuItem mntmNewMenuItem_9 = new JMenuItem("Load Game");
				
				// ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


//		        String filePath = "SAVEDGAME.txt";
//		        
//		        String content = null;
//		        try {
//		            content = readFile(filePath);
//		        } catch (IOException e) {
//		            e.printStackTrace();
//		        }
		// 
//		        System.out.println(content);
		        System.out.println(Player.getCurrentRoom().getRoomID());
		        
				mntmNewMenuItem_9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {				
				        String filePath = "SAVEDGAME.txt";
				        
				        String loadRoom = null;
				        try {
				            loadRoom = readFile(filePath);
				        } catch (IOException e5) {
				            e5.printStackTrace();
				        }
				 
				        
				        Player.setCurrentRoom(loadRoom);
						System.out.println("Moving to room "+ Player.getCurrentRoom().getRoomID());
						Image gpMap = new ImageIcon (this.getClass().getResource("GP-" + Player.getCurrentRoom().getRoomID() + ".png")).getImage();
						Image scaled = gpMap.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),Image.SCALE_SMOOTH);
						lblNewLabel_1.setIcon(new ImageIcon(scaled));
				        
				        
				        
				        
				        System.out.println(loadRoom);
					}
				});

				
				//LOAD ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
		
		
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("New Game");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				GUI.main(null);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Exit Game");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_11);
		
		//INVENTORY TAB
		list = new JList(Player.inventory.toArray());
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					list.setSelectedIndex(list.locationToIndex(e.getPoint()));
				
					JPopupMenu popupMenu = new JPopupMenu();
					//popupMenu.setBounds(0, 0, 200, 50);
					JMenuItem itemDrop = new JMenuItem("Drop Item");
					JMenuItem lookAt = new JMenuItem("Look at Item");
					itemDrop.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Remove the element in position " + list.getSelectedValue());
					}	
			
				});
					lookAt.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println("Look at the element in position " + list.getSelectedValue());
						}	
				
					});
				popupMenu.add(itemDrop);
				popupMenu.add(lookAt);
				popupMenu.show(list, e.getPoint().x, e.getPoint().y);
				}
			}
		});
		list.setBackground(new Color(255, 248, 220));
		list.setBounds(889, 65, 205, 225);
		frame.getContentPane().add(list);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(85, 107, 47));
		panel_1.setBounds(889, 45, 205, 20);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(85, 107, 47));
		panel_1_1.setBounds(889, 290, 205, 20);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("GrizzlyPunk");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblNewLabel_2.setBounds(65, 18, 282, 46);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("2070");
		lblNewLabel_2_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1_1.setForeground(new Color(85, 107, 47));
		lblNewLabel_2_1_1.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblNewLabel_2_1_1.setBounds(149, 63, 300, 46);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("2070");
		lblNewLabel_2_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblNewLabel_2_2.setBounds(152, 65, 282, 46);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		
	}
	protected JLabel getLblNewLabel_1() {
		return lblNewLabel;
	}
	public JList getList() {
		return list;
	}
	public JTextArea getConsole() {
		return console;
	}
	
	
		
	
}
