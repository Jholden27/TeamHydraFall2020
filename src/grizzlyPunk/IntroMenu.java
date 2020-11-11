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
		
		JLabel lblNewLabel_2_1 = new JLabel("GrizzlyPunk");
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1.setForeground(new Color(85, 107, 47));
		lblNewLabel_2_1.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblNewLabel_2_1.setBounds(74, 25, 288, 46);
		contentPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("GrizzlyPunk");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblNewLabel_2.setBounds(75, 27, 285, 46);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("2070");
		lblNewLabel_2_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1_1.setForeground(new Color(85, 107, 47));
		lblNewLabel_2_1_1.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblNewLabel_2_1_1.setBounds(164, 81, 107, 46);
		contentPanel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("2070");
		lblNewLabel_2_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblNewLabel_2_2.setBounds(166, 83, 104, 46);
		contentPanel.add(lblNewLabel_2_2);
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
	}
}
