package PasswordGenerator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// This is the frontEnd.

public class frontEnd extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel label1, label2, label3;
	private JTextField textField1, textField2;
	private JButton button5, button6, button7;
	private JCheckBox check1, check2, check3, check4;
	
	public frontEnd() {
		
		BackEnd passwordGenerator = new BackEnd();

		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Password Generator || The_Astro_Coder");
		
		label1 = new JLabel("Password Generator");
		label1.setBounds(100, 10, 300, 30);
		label1.setFont(new Font("Calibri", 1, 20));
		label1.setForeground(new Color(0, 0, 0));
		add(label1); 
		
		label2 = new JLabel("Password length: ");
		label2.setBounds(20, 60, 300, 30);
		label2.setFont(new Font("Calibri", 1, 15));
		label2.setForeground(new Color(0, 0, 0));
		add(label2);	
		
		label3 = new JLabel("The_Astro_Coder");
		label3.setBounds(150,450,200,30);
		label3.setFont(new Font("Calibri", 2, 13));
		label3.setForeground(new Color(0, 0, 0));
		add(label3);
		
		textField1 = new JTextField();
		textField1.setBounds(160, 60, 100, 30);
		textField1.setBackground(new Color(224, 224, 224));
		textField1.setFont(new Font("Calibri", 1, 14));
		textField1.setForeground(new Color(0, 0, 0));
		add(textField1);
		
		textField2 = new JTextField();
		textField2.setBounds(20, 300, 360, 100);
		textField2.setBackground(new Color(224, 224, 224));
		textField2.setFont(new Font("Calibri", 1, 14));
		textField2.setForeground(new Color(0, 0, 0));
		add(textField2);
		
		check1 = new JCheckBox("Uppercase");
		check1.setBounds(20, 115, 150, 60);
		add(check1);
		
		check2 = new JCheckBox("Lowercase");
		check2.setBounds(20, 180, 150, 60);
		add(check2);
		
		check3 = new JCheckBox("Numbers");
		check3.setBounds(230, 115, 150, 60);
		add(check3);
		
		check4 = new JCheckBox("Symbols");
		check4.setBounds(230, 180, 150, 60);
		add(check4);
		
		button5 = new JButton("CLEAR");
		button5.setBounds(160, 405, 80, 40);
		button5.setFont(new Font("Calibri", 1, 14));
		
		button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField1.setText("");	
				textField2.setText("");
			}
		});
		add(button5);
		

		button6 = new JButton("EXIT");
		button6.setBounds(303, 410, 80, 30);
		
		button6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
			
		});
		
		add(button6);
		
		
		button7 = new JButton("GENERATE PASSWORD");
		button7.setBounds(100, 250, 200, 40);
		button7.setBackground(new Color(244, 244, 244));
		button7.setFont(new Font("Calibri", 2, 14));
		button7.setForeground(new Color(0, 0, 0));
		
		button7.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//this generates a password only when length > 0 and one of the buttons is pressed.
				if(textField1.getText().length() <= 0) return;
				boolean anyButtonSelected = check1.isSelected() ||
						check2.isSelected() || 
						check3.isSelected() || 
						check4.isSelected();
				
				//generate password
				//converts the texts to an integer value
				int passwordLength = Integer.parseInt(textField1.getText());
				if(anyButtonSelected) {
					String generatedPassword = passwordGenerator.generatePassword(passwordLength,
							check1.isSelected(),
							check2.isSelected(),
							check3.isSelected(),
							check4.isSelected()); 
							
				//display password back to the user
					textField2.setText(generatedPassword);
				
					
				}
			}
		});
		
		add(button7);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


public static void main(String[] args) {
	
	frontEnd main = new frontEnd();
	main.setBounds(0, 0, 400, 500);
	main.setVisible(true);
	main.setResizable(false);
	main.setLocationRelativeTo(null);
	

	}	
}
