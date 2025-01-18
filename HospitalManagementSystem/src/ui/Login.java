package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dbconnection.Getconnection;

public class Login extends JFrame {

	JLabel username, password;
	JTextField ufield, pfield;
	JButton Login, reset;

	public Login() {
		setLayout(new FlowLayout());
		setTitle("Login");

		username = new JLabel("Username");
		ufield = new JTextField(20);
		password = new JLabel("Password");
		pfield = new JTextField(20);
		Login = new JButton("Login");
		reset = new JButton("Reset");

		Details detailsobj = new Details();
		Login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResultSet rs;
				try {
					rs = Getconnection.getconnection().prepareStatement("select * from login").executeQuery();
					rs.next();
					String u = rs.getString(1);
					String p = rs.getString(2);

					if (ufield.getText().equals(u) && pfield.getText().equals(p)) {
						new Dashboard(); 
						System.out.println("Logged in Successfully...");
					} else {
						System.out.println("Username or Password Wrong !!!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ufield.setText("");
				pfield.setText("");
			}
		});

		add(username);
		add(ufield);
		add(password);
		add(pfield);
		add(Login);
		add(reset);

		setVisible(true);
		setSize(1900, 500);
	}

	public static void main(String[] args) {
		new Login();
	}
}
