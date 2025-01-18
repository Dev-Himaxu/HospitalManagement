package operations;

import ui.Details;

public interface Operations {
	void insertDoctor(Details obj);

	void insertPatients(Details obj);

	void update(Details obj);

	void deletePatientdetails(Details obj);

	void deleteDoctordetails(Details obj);

	void showPaymentdetails(int intid);

	void showDoctordetails(int intid);

	void showPatientdetails(int intid);
}
