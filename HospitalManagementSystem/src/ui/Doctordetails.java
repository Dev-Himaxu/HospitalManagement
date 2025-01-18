package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import operations.OperationImplent;

public class Doctordetails extends JFrame {

	JLabel docid, docname, docspecialisation;
	JTextField id, name, specialisation;
	JButton register,update, show, reset;

	public Doctordetails() {
		setLayout(new FlowLayout());
		setTitle("Doctor Details");

		docid = new JLabel("Id");
		id = new JTextField(20);
		docname = new JLabel("Name");
		name = new JTextField(20);
		docspecialisation = new JLabel("Specialisation");
		specialisation = new JTextField(20);
		register = new JButton("Register");
		update = new JButton("Update");
		show = new JButton("Show Details ");
		reset = new JButton("Reset");
		

		Details detailsobj = new Details();
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detailsobj.setIntId(Integer.parseInt(id.getText()));
				detailsobj.setStrName(name.getText());
				detailsobj.setSpecialisation(specialisation.getText());
				new OperationImplent().insertDoctor(detailsobj);
			}
		});
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				detailsobj.setIntId(Integer.parseInt(id.getText()));
				detailsobj.setStrName(name.getText());
				detailsobj.setSpecialisation(specialisation.getText());
				
				new OperationImplent().update(detailsobj);
			}
		});
		show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int intid = Integer.parseInt(id.getText());
				new OperationImplent().showDoctordetails(intid);

			}
		});
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText("");
				specialisation.setText("");

			}
		});
		add(docid);
		add(id);
		add(docname);
		add(name);
		add(docspecialisation);
		add(specialisation);
		add(register);
		add(update);
		add(show);
		add(reset);

		setVisible(true);
		setSize(1900, 500);
	}
}
