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
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.event.CaretListener;


import javax.swing.event.CaretEvent;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.border.SoftBevelBorder;

public class GUI {
	public static String readFile(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }


	private JFrame frmGrizzlyPunk;
	private JTextField txtInventory;
	private JTextField txtEquippedWeapon;
	private JTextField txtShield;
	private JTextField txtHp;
	private final Component horizontalStrut_1_1 = Box.createHorizontalStrut(120);
	private JTextField txtMemories;
	private JLabel lblNewLabel;
	public static PrintStream printStream;
	
	
	private JList list;
	private JList goList;
	public static JTextArea console = new JTextArea();
	private JTextField txtTypeInputHere;
	private JTextField textFieldAP;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmGrizzlyPunk.setVisible(true);
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
		frmGrizzlyPunk = new JFrame();
		frmGrizzlyPunk.setIconImage(Toolkit.getDefaultToolkit().getImage("\\src\\grizzlyPunk\\Mem10.png"));
		frmGrizzlyPunk.setTitle("Grizzly Punk 2070");
		frmGrizzlyPunk.setMinimumSize(new Dimension(1280, 1024));
		frmGrizzlyPunk.setSize(new Dimension(1280, 1024));
		frmGrizzlyPunk.getContentPane().setSize(new Dimension(1280, 1024));
		frmGrizzlyPunk.getContentPane().setMinimumSize(new Dimension(1280, 1024));
		frmGrizzlyPunk.setResizable(false);
		frmGrizzlyPunk.getContentPane().setPreferredSize(new Dimension(1280, 1024));
		frmGrizzlyPunk.setPreferredSize(new Dimension(1280, 1024));
		frmGrizzlyPunk.getContentPane().setBackground(Color.GRAY);
		frmGrizzlyPunk.getContentPane().setLayout(null);
		frmGrizzlyPunk.setLocationRelativeTo(null);
		
		txtMemories = new JTextField();
		txtMemories.setDisabledTextColor(Color.BLACK);
		txtMemories.setForeground(Color.BLACK);
		txtMemories.setBounds(267, 283, 105, 20);
		txtMemories.setText("Memories");
		txtMemories.setOpaque(false);
		txtMemories.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		txtMemories.setEditable(false);
		txtMemories.setColumns(10);
		txtMemories.setBorder(null);
		frmGrizzlyPunk.getContentPane().add(txtMemories);
		
		JLabel lblNewLabel_2_1 = new JLabel("GrizzlyPunk");
		lblNewLabel_2_1.setBorder(null);
		lblNewLabel_2_1.setBounds(51, 1, 321, 46);
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_1.setFont(new Font("OCR A Extended", Font.BOLD, 45));
		frmGrizzlyPunk.getContentPane().add(lblNewLabel_2_1);
		
		txtInventory = new JTextField();
		txtInventory.setDisabledTextColor(Color.BLACK);
		txtInventory.setForeground(Color.BLACK);
		txtInventory.setBounds(956, 44, 75, 20);
		txtInventory.setBorder(null);
		txtInventory.setEditable(false);
		txtInventory.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		txtInventory.setOpaque(false);
		txtInventory.setText("Inventory");
		frmGrizzlyPunk.getContentPane().add(txtInventory);
		txtInventory.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(433, 0, 420, 367);
		panel.setName("Map");
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(85, 107, 47), 5));
		frmGrizzlyPunk.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBorder(new LineBorder(Color.DARK_GRAY, 5));
		lblNewLabel_1.setBounds(10, 10, 400, 350);
		panel.add(lblNewLabel_1);
		Image gpMap = new ImageIcon (this.getClass().getResource("GP-" + Player.getCurrentRoom().getRoomID() + ".png")).getImage();
		Image scaled = gpMap.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(scaled));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 362, 1271, 60);
		panel_2.setBorder(new LineBorder(new Color(85, 107, 47), 7));
		panel_2.setBackground(new Color(255, 248, 220));
		frmGrizzlyPunk.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		txtHp = new JTextField();
		txtHp.setText("Health: " + Player.getCurrentHP());
		txtHp.setOpaque(false);
		txtHp.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		txtHp.setEditable(false);
		txtHp.setColumns(10);
		txtHp.setBorder(null);
		txtHp.setBounds(553, 37, 125, 17);
		panel_2.add(txtHp);
		
		txtShield = new JTextField();
		txtShield.setText("Shield: " + Player.getSp());
		txtShield.setOpaque(false);
		txtShield.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		txtShield.setEditable(false);
		txtShield.setColumns(10);
		txtShield.setBorder(null);
		txtShield.setBounds(515, 14, 75, 14);
		panel_2.add(txtShield);
		
		JProgressBar shieldBar = new JProgressBar();
		shieldBar.setMaximum(50);
		shieldBar.setValue(Player.getSp());
		shieldBar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		shieldBar.setName("Shield:");
		shieldBar.setBounds(510, 9, 250, 20);
		panel_2.add(shieldBar);
		shieldBar.setBackground(Color.GRAY);
		shieldBar.setForeground(new Color(176, 224, 230));
		
		JProgressBar healthBar = new JProgressBar();
		healthBar.setMaximum(Player.getMaxHP());
		healthBar.setValue(Player.getCurrentHP());
		healthBar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		healthBar.setName("HP:");
		healthBar.setBounds(548, 33, 175, 20);
		panel_2.add(healthBar);
		healthBar.setBackground(Color.GRAY);
		healthBar.setForeground(new Color(240, 128, 128));
		
		//EQUIPPED WEAPON
		txtEquippedWeapon = new JTextField();
		txtEquippedWeapon.setText("Equipped Weapon: " + Player.equippedWeapon);
		txtEquippedWeapon.setOpaque(false);
		txtEquippedWeapon.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		txtEquippedWeapon.setEditable(false);
		txtEquippedWeapon.setColumns(10);
		txtEquippedWeapon.setBorder(null);
		txtEquippedWeapon.setBounds(878, 10, 275, 23);
		panel_2.add(txtEquippedWeapon);
		
		textFieldAP = new JTextField();
		textFieldAP.setText("Attack Power: " + Player.getAp());
		textFieldAP.setOpaque(false);
		textFieldAP.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		textFieldAP.setEditable(false);
		textFieldAP.setColumns(10);
		textFieldAP.setBorder(null);
		textFieldAP.setBounds(908, 30, 250, 23);
		panel_2.add(textFieldAP);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(75, 102, 250, 250);
		lblNewLabel.setBorder(null);
		lblNewLabel.setPreferredSize(new Dimension(225, 225));
		lblNewLabel.setMinimumSize(new Dimension(225, 225));
		lblNewLabel.setMaximumSize(new Dimension(225, 225));
		Image mem = new ImageIcon (this.getClass().getResource("Mem" + Player.memoryFragments + ".png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(mem));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setToolTipText("Memories collected.");
		frmGrizzlyPunk.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 482, 1266, 514);
		scrollPane.setAutoscrolls(true);
		frmGrizzlyPunk.getContentPane().add(scrollPane);
		scrollPane.setViewportView(console);
		console.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
			}
		});
		
		
		
		console.setLineWrap(true);
		console.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		
		console.setBackground(new Color(255, 248, 220));
		console.setBorder(new CompoundBorder(new MatteBorder(15, 1, 20, 1, (Color) new Color(85, 107, 47)), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		console.setEditable (false);
		
		txtTypeInputHere = new JTextField();
		txtTypeInputHere.setBackground(new Color(255, 248, 220));
		txtTypeInputHere.setBorder(new CompoundBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(85, 107, 47)), new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Type Input Here:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		txtTypeInputHere.setToolTipText("");
		scrollPane.setColumnHeaderView(txtTypeInputHere);
		txtTypeInputHere.setColumns(10);
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(31, 427, 1213, 50);
		toolBar.setBackground(Color.LIGHT_GRAY);
		toolBar.setForeground(Color.GRAY);
		toolBar.setBorder(new CompoundBorder(new MatteBorder(5, 1, 5, 1, (Color) new Color(64, 64, 64)), new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(64, 64, 64)), "Action Bar", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
		frmGrizzlyPunk.getContentPane().add(toolBar);
		
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
		//goList = new JList(Player.getCurrentRoom().getRoomConnections().toArray());
		goList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Player.move((String) goList.getSelectedValue());
				Image gpMap = new ImageIcon (this.getClass().getResource("GP-" + (String) goList.getSelectedValue() + ".png")).getImage();
				Image scaled = gpMap.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),Image.SCALE_SMOOTH);
				lblNewLabel_1.setIcon(new ImageIcon(scaled));
				GUI.main(null);
				frmGrizzlyPunk.dispose();
				
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
		mnAttack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Player.currentRoom.getMonsters().isEmpty())
				{
					System.out.println("Theres nothing here to attack.");
				}
			}
		});
		mnAttack.setVisible(true);		
		mnAttack.setBorder(null);
		mnAttack.setBackground(Color.GRAY);
		menuBar_1.add(mnAttack);
		if(!Player.currentRoom.getMonsters().isEmpty())
		{
			JMenuItem mntmNewMenuItem_4 = new JMenuItem("Attack the head");
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Player.combatMonster("head");
					GUI.main(null);
					frmGrizzlyPunk.dispose();
				}
			});
			mnAttack.add(mntmNewMenuItem_4);
			
			JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Attack the arms");
			mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Player.combatMonster("arms");
					GUI.main(null);
					frmGrizzlyPunk.dispose();
				}
			});
			mnAttack.add(mntmNewMenuItem_1_1);
			
			JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("Attack the legs");
			mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Player.combatMonster("legs");
					GUI.main(null);
					frmGrizzlyPunk.dispose();
				}
			});
			mnAttack.add(mntmNewMenuItem_2_1);

		}
		
				
		
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
				Player.getCurrentRoom().getPuzzles().toString();
				//Puzzles.solvePuzzle();
			}
		});
		mnNewMenu_2.add(explore1);
		
		JMenuItem explore2 = new JMenuItem("Pickup Items in Area");
		explore2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Player.pickupItem(txtTypeInputHere.getText());
				GUI.main(null);
				frmGrizzlyPunk.dispose();
				
				
			}
		});
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
				frmGrizzlyPunk.dispose();
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
		Player.checkInventory();
		list = new JList(Player.itemNames.toArray());
		list.setBorder(new MatteBorder(3, 0, 3, 0, (Color) Color.LIGHT_GRAY));
		list.setBounds(889, 65, 205, 225);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					list.setSelectedIndex(list.locationToIndex(e.getPoint()));
				
					JPopupMenu popupMenu = new JPopupMenu();
					//popupMenu.setBounds(0, 0, 200, 50);
					JMenuItem equipW = new JMenuItem("Equip Weapon");
					JMenuItem equipI = new JMenuItem("Equip Item");
					JMenuItem lookAt = new JMenuItem("Look at Item");
					JMenuItem itemDrop = new JMenuItem("Drop Item");
					equipW.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Player.equipWeapon(list.getSelectedValue().toString());
							GUI.main(null);
							frmGrizzlyPunk.dispose();
						}	
				
						});
					equipI.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Player.equipItem(list.getSelectedValue().toString());
							GUI.main(null);
							frmGrizzlyPunk.dispose();
						}	
				
						});
					itemDrop.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Remove the item in position " + list.getSelectedValue());
					}	
			
					});
					lookAt.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println("Look at the item in position " + list.getSelectedValue());
						}	
				
					});
				popupMenu.add(equipW);
				popupMenu.add(equipI);
				popupMenu.add(lookAt);
				popupMenu.add(itemDrop);
				popupMenu.show(list, e.getPoint().x, e.getPoint().y);
				}
			}
		});
		list.setBackground(new Color(255, 248, 220));
		frmGrizzlyPunk.getContentPane().add(list);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(889, 45, 205, 20);
		panel_1.setBackground(new Color(85, 107, 47));
		frmGrizzlyPunk.getContentPane().add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(889, 290, 205, 20);
		panel_1_1.setBackground(new Color(85, 107, 47));
		frmGrizzlyPunk.getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("GrizzlyPunk");
		lblNewLabel_2.setBounds(54, 3, 318, 46);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setForeground(new Color(85, 107, 47));
		lblNewLabel_2.setFont(new Font("OCR A Extended", Font.BOLD, 45));
		frmGrizzlyPunk.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("2070");
		lblNewLabel_2_1_1.setBounds(143, 45, 121, 46);
		lblNewLabel_2_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_1_1.setFont(new Font("OCR A Extended", Font.BOLD, 45));
		frmGrizzlyPunk.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("2070");
		lblNewLabel_2_2.setBounds(146, 47, 118, 46);
		lblNewLabel_2_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2.setForeground(new Color(85, 107, 47));
		lblNewLabel_2_2.setFont(new Font("OCR A Extended", Font.BOLD, 45));
		frmGrizzlyPunk.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("GrizzlyPunk");
		lblNewLabel_2_1_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1_2.setForeground(new Color(240, 255, 240));
		lblNewLabel_2_1_2.setFont(new Font("OCR A Extended", Font.BOLD, 45));
		lblNewLabel_2_1_2.setBounds(50, 0, 322, 46);
		frmGrizzlyPunk.getContentPane().add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("2070");
		lblNewLabel_2_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1_1_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_2_1_1_1.setFont(new Font("OCR A Extended", Font.BOLD, 45));
		lblNewLabel_2_1_1_1.setBounds(142, 44, 122, 46);
		frmGrizzlyPunk.getContentPane().add(lblNewLabel_2_1_1_1);
		
		
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
