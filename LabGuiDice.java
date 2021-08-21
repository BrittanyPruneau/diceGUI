package guiDice;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Displays a random dice roll and allows the user to click a button to roll a 6 sided 
 * dice and does not roll a number twice. 
 * 
 * @author Brittany Pruneau
 *
 */
public class LabGuiDice extends JFrame
{
	private JPanel contentPane;
	private String[] images =
	{ "die-1.png", "die-2.png", "die-3.png", "die-4.png", "die-5.png", "die-6.png" };
	private int copy = (int) Math.floor(Math.random() * 6) + 1;

	/*
	 * Launch's the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					LabGuiDice frame = new LabGuiDice();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame which contains the dice picture and button to roll a 6 sided dice..
	 */
	public LabGuiDice()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		ImageIcon images2 = new ImageIcon("/images/die-1.png");
		JLabel lblDiceLabel = new JLabel("");

		lblDiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiceLabel
				.setIcon(new ImageIcon(LabGuiDice.class.getResource("/images/die-" + String.valueOf(copy) + ".png")));
		contentPane.add(lblDiceLabel, BorderLayout.CENTER);

		JButton btnNewButton = diceImageChanges(lblDiceLabel);

		diceButton(btnNewButton);
	}

	/*
	 * Creates the look of the button the user clicks to roll the dice.
	 */
	private void diceButton(JButton btnNewButton)
	{
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 20));
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

	/*
	 * Changes the dice image every time the user clicks the button. 
	 */
	private JButton diceImageChanges(JLabel lblDiceLabel)
	{
		final JButton btnNewButton = new JButton("Roll Em'");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setImage(lblDiceLabel);
			}
		});
		return btnNewButton;
	}

	/*
	 * Ensures the same number does not get rolled more than once.  
	 */
	private void setImage(JLabel lblDiceLabel)
	{
		int n = (int) Math.floor(Math.random() * 6) + 1;

		if (copy != n)
		{
			lblDiceLabel
			.setIcon(new ImageIcon(LabGuiDice.class.getResource("/images/die-" + String.valueOf(n) + ".png")));
			copy = n;
		} 
		else
		{
			copy = n;
			setImage(lblDiceLabel);	
		}
	}
}
