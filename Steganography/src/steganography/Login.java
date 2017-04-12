/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

/**
 *
 * @author ATIF ADIB
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;


class Login extends JFrame implements ActionListener {
	
		private static final long serialVersionUID = -3010597082691149848L;
	
	final JTextField nameInput, passInput;
	JLabel username, password;
	JButton submit;
	JPanel panel;
	
	Login() {
		
		try
		{
		  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){}
		
		//Create field for "Username:" input
		username = new JLabel();
		username.setText("USERNAME  :");
		username.setForeground(Color.WHITE);
		nameInput = new JTextField(15);
		
		//Create field for "Password:" input
		password = new JLabel();
		password.setText("PASSWORD :");
		password.setForeground(Color.WHITE);
		passInput = new JPasswordField(15);
		
		//SUBMIT button. User can also press ENTER on keyboard to submit credential details.
		submit = new JButton("SUBMIT");
		submit.setMnemonic(KeyEvent.VK_ENTER);
		getRootPane().setDefaultButton(submit);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel() {
			private static final long serialVersionUID = 7202207766947468085L;
			
			//setting background
			public void paintComponent(Graphics g) {
				Image background = null;
				try {
					background = ImageIO.read(getClass().getResource("login_background.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        g.drawImage(background,0,0,this);
			} //end of paintComponent()
		};
		
		//Creating the panel and adding all elements
		panel.setLayout(null);
		username.setBounds(50,125,150,50);
		nameInput.setBounds(130,135,150,30);
		password.setBounds(50,175,150,50);
		passInput.setBounds(130,185,150,30);
		submit.setBounds(130,230,150,30);
		panel.add(username);
		panel.add(nameInput);
		panel.add(password);
		panel.add(passInput);
		panel.add(submit);
		submit.addActionListener(this);
		add(panel);
		
		//modifying attributes of login window
		setResizable(false);
	    setSize(370, 480);
	    setVisible(true);
	    setLocation(350,100);
		setTitle("LOGIN FORM");
	} //end of Login() constructor
	
	public void actionPerformed(ActionEvent submitCredentials) {
		String name = nameInput.getText();
		String pass = passInput.getText();
		//Authentication process
		if (name.equals("admin") && pass.equals("password")) {
			SteganoMain page = new SteganoMain();
			dispose();
			page.setVisible(true);
		} else {
			System.out.println("enter the valid username and password");
			JOptionPane.showMessageDialog(this,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
		}
	} //end of actionPerformed()

} //end of Login Class

