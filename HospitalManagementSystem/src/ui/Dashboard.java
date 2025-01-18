package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame {

	JMenuBar bar;
	JMenu doctor, patient, management;
	JMenuItem docdetails, ptDetails, mgdetails;

	public Dashboard() {
		setLayout(new FlowLayout());
		setTitle("Dashboard");
		bar = new JMenuBar();
		setBounds(0, 0, 600, 50);

		doctor = new JMenu("Doctor");
		patient = new JMenu("Patient");
		management = new JMenu("Management");
		docdetails = new JMenuItem("Doctor Details");
		docdetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Doctordetails();

			}
		});
		ptDetails = new JMenuItem("Patient details");
		ptDetails.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PatientDetails();
				
			}
		});
		mgdetails = new JMenuItem("Manage Details");
		mgdetails.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Management();
				
			}
		});

		doctor.add(docdetails);
		patient.add(ptDetails);
		management.add(mgdetails);

		bar.add(doctor);
		bar.add(patient);
		bar.add(management);

		add(bar);
		setVisible(true);
		setSize(1900, 500);
	}
}
