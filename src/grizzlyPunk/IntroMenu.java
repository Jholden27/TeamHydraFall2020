package grizzlyPunk;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntroMenu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static IntroMenu dialog = new IntroMenu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			//IntroMenu dialog = new IntroMenu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IntroMenu() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(150, 149, 135, 104);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton NewGame = new JButton("New Game");
				NewGame.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dialog.dispose();
						GUI.main(null);
					}
				});
				NewGame.setBorder(new MatteBorder(1, 5, 1, 5, (Color) new Color(85, 107, 47)));
				NewGame.setFocusable(false);
				NewGame.setBounds(26, 5, 83, 21);
				NewGame.setActionCommand("New Game");
				buttonPane.add(NewGame);
				getRootPane().setDefaultButton(NewGame);
			}
			{
				JButton exitButton = new JButton("Exit Game");
				exitButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				exitButton.setBorder(new MatteBorder(1, 5, 1, 5, (Color) new Color(85, 107, 47)));
				exitButton.setFocusable(false);
				exitButton.setBounds(26, 38, 83, 21);
				exitButton.setActionCommand("exitButton");
				buttonPane.add(exitButton);
			}
		}
		
		JLabel lblNewLabel_2_1 = new JLabel("GrizzlyPunk");
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_1.setFont(new Font("OCR A Extended", Font.BOLD, 45));
		lblNewLabel_2_1.setBounds(57, 24, 321, 46);
		contentPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("GrizzlyPunk");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setForeground(new Color(85, 107, 47));
		lblNewLabel_2.setFont(new Font("OCR A Extended", Font.BOLD, 45));
		lblNewLabel_2.setBounds(59, 26, 318, 46);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("2070");
		lblNewLabel_2_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_1_1.setFont(new Font("OCR A Extended", Font.BOLD, 45));
		lblNewLabel_2_1_1.setBounds(156, 71, 124, 46);
		contentPanel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("2070");
		lblNewLabel_2_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2.setForeground(new Color(85, 107, 47));
		lblNewLabel_2_2.setFont(new Font("OCR A Extended", Font.BOLD, 45));
		lblNewLabel_2_2.setBounds(156, 73, 123, 46);
		contentPanel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("GrizzlyPunk");
		lblNewLabel_2_1_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1_2.setForeground(new Color(154, 205, 50));
		lblNewLabel_2_1_2.setFont(new Font("OCR A Extended", Font.BOLD, 45));
		lblNewLabel_2_1_2.setBounds(55, 22, 322, 46);
		contentPanel.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("2070");
		lblNewLabel_2_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1_1_1.setForeground(new Color(154, 205, 50));
		lblNewLabel_2_1_1_1.setFont(new Font("OCR A Extended", Font.BOLD, 45));
		lblNewLabel_2_1_1_1.setBounds(154, 69, 125, 46);
		contentPanel.add(lblNewLabel_2_1_1_1);
	}
}
