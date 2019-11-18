package nameGenerator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import java.util.Random;

public class Jframe extends javax.swing.JFrame {
	private String UppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String LowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
	private String Numbers = "123456789";

	private JPanel contentPane;
	private JTextField resultField;
	private JTextField sizet;
	StringBuilder str = new StringBuilder();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframe frame = new Jframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Jframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel radioButtons = new JPanel();

		JRadioButton upperCase = new JRadioButton("uppercase");

		radioButtons.add(upperCase);

		JRadioButton lowerCase = new JRadioButton("lowercase");

		radioButtons.add(lowerCase);

		JRadioButton number = new JRadioButton("number");
		radioButtons.add(number);

		JPanel result = new JPanel();

		JPanel max = new JPanel();

		JPanel panel = new JPanel();

		JButton btnNewButton = new JButton("create");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
								.addComponent(radioButtons, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
								.addComponent(max, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
								.addComponent(result, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(25)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(radioButtons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(max, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnNewButton).addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
				.addComponent(result, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(21)));

		JLabel lblPasswordGenerator = new JLabel("Password generator");
		panel.add(lblPasswordGenerator);

		JLabel resultl = new JLabel("pass word");
		result.add(resultl);

		resultField = new JTextField();
		result.add(resultField);
		resultField.setColumns(10);

		JLabel sizel = new JLabel("size");
		max.add(sizel);

		sizet = new JTextField();

		max.add(sizet);
		sizet.setColumns(10);
		contentPane.setLayout(gl_contentPane);
		
		

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(upperCase.isSelected()) {
					str.append(UppercaseLetters);
				}
				if(lowerCase.isSelected()) {
					str.append(LowercaseLetters);
				}
				if(number.isSelected()) {
					str.append(Numbers);
				}
				
				
				int string_length = Integer.parseInt(sizet.getText());
				StringBuilder result = new StringBuilder();
				
				for (int i = 0; i < string_length; i++) {
					int num = getRandomNum();
					char ch = str.charAt(num);
					result.append(ch);
				}
				resultField.setText(result.toString());
			}
		});
		
	}

	private int getRandomNum() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(str.length());
		return randomInt;
		
//		if (randomInt == -1) {
//			return randomInt;
//		} else
//			return randomInt - 1;

	}
}
