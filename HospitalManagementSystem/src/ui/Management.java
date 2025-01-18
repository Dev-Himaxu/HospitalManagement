package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import operations.OperationImplent;

public class Management extends JFrame {

	JLabel mgid;
	JTextField id;
	JButton paymentdetails, docdelete, patientdelete;

	public Management() {
		setLayout(new FlowLayout());
		setTitle("Management");

		mgid = new JLabel("Id");
		id = new JTextField(20);

		Details detailsobj = new Details();

		paymentdetails = new JButton("Show Payment details");
		paymentdetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int intId = Integer.parseInt(id.getText());

				new OperationImplent().showPaymentdetails(intId);

			}
		});
		docdelete = new JButton("Delete doctor details");
		docdelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detailsobj.setIntId(Integer.parseInt(id.getText()));

				new OperationImplent().deleteDoctordetails(detailsobj);

			}
		});

		patientdelete = new JButton("Delete patient details");
		patientdelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detailsobj.setIntId(Integer.parseInt(id.getText()));

				new OperationImplent().deletePatientdetails(detailsobj);

			}
		});
		add(mgid);
		add(id);
		add(paymentdetails);
		add(patientdelete);
		add(docdelete);
		setVisible(true);
		setSize(300, 500);

	}
}
