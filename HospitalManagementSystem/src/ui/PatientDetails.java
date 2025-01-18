package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import operations.OperationImplent;

public class PatientDetails extends JFrame {

	JLabel ptid, ptname, ptage, ptdate, ptdocname, ptPayment;
	JTextField intid, strname, intage, strdate, strdocname, intpayment;
	JButton insert, show, reset;

	public PatientDetails() {
		setLayout(new FlowLayout());
		setTitle("Patient Details");
		ptid = new JLabel("Id");
		intid = new JTextField(20);
		ptname = new JLabel("Name");
		strname = new JTextField(20);
		ptage = new JLabel("Age");
		intage = new JTextField(20);
		ptdate = new JLabel("Date");
		strdate = new JTextField(20);
		ptdocname = new JLabel("Doctor Name");
		strdocname = new JTextField(20);
		ptPayment = new JLabel("Amount");
		intpayment = new JTextField(20);

		Details detailsobj = new Details();
		insert = new JButton("Book Appointment");
		insert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detailsobj.setIntId(Integer.parseInt(intid.getText()));
				detailsobj.setStrName(strname.getText());
				detailsobj.setIntAge(Integer.parseInt(intage.getText()));
				detailsobj.setStrDate(strdate.getText());
				detailsobj.setStrDocName(strdocname.getText());
				detailsobj.setIntPayment(Integer.parseInt(intpayment.getText()));

				new OperationImplent().insertPatients(detailsobj);

			}
		});
		show = new JButton("Show Details");
		show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int intId = Integer.parseInt(intid.getText());

				new OperationImplent().showPatientdetails(intId);
			}
		});
		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				intid.setText("");
				strname.setText("");
				intage.setText("");
				strdate.setText("");
				strdocname.setText("");
				intpayment.setText("");

			}
		});
		add(ptid);
		add(intid);
		add(ptname);
		add(strname);
		add(ptage);
		add(intage);
		add(ptdate);
		add(strdate);
		add(ptdocname);
		add(strdocname);
		add(ptPayment);
		add(intpayment);
		add(insert);
		add(show);
		add(reset);

		setVisible(true);
		setSize(1900,500);
	}
}