package operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbconnection.Getconnection;
import ui.Details;

public class OperationImplent implements Operations {

	@Override
	public void insertDoctor(Details obj) {
		try {
			PreparedStatement ps = Getconnection.getconnection().prepareStatement("insert into doctor values(?,?,?)");

			ps.setInt(1, obj.getIntId());
			ps.setString(2, obj.getStrName());
			ps.setString(3, obj.getSpecialisation());

			ps.executeUpdate();
			System.out.println("Doctor details inserted in doctor table");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insertPatients(Details obj) {
		try {
			PreparedStatement ps = Getconnection.getconnection()
					.prepareStatement("insert into patient values(?,?,?,?,?,?) ");

			ps.setInt(1, obj.getIntId());
			ps.setString(2, obj.getStrName());
			ps.setInt(3, obj.getIntAge());
			ps.setString(4, obj.getStrDate());
			ps.setString(5, obj.getStrDocName());
			ps.setInt(6, obj.getIntPayment());

			ps.executeUpdate();
			System.out.println("Patient details inserted in patient table.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(Details obj) {
		try {
			PreparedStatement ps = Getconnection.getconnection()
					.prepareStatement("update doctor set specialisation =?, name=? where id =?");

			ps.setInt(3, obj.getIntId());
			ps.setString(1, obj.getSpecialisation());
			ps.setString(2, obj.getStrName());

			ps.executeUpdate();
			System.out.println("Doctor details updated");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletePatientdetails(Details obj) {
		try {
			PreparedStatement ps = Getconnection.getconnection().prepareStatement("delete from patient where id =?");

			ps.setInt(1, obj.getIntId());
			ps.executeUpdate();
			System.out.println("Patient details are deleted from patient table");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDoctordetails(Details obj) {
		try {
			PreparedStatement ps = Getconnection.getconnection().prepareStatement("delete from doctor where id =?");

			ps.setInt(1, obj.getIntId());
			ps.executeUpdate();
			System.out.println("Doctor details are deleted from doctor table");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void showPaymentdetails(int intid) {
		try {
			PreparedStatement ps = Getconnection.getconnection().prepareStatement("select id,name,date, payment from patient where id =?");
			
			ps.setInt(1, intid);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void showDoctordetails(int intid) {
		try {
			PreparedStatement ps = Getconnection.getconnection().prepareStatement("select * from doctor where id =?");
			
			ps.setInt(1, intid);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void showPatientdetails(int intid) {
		try {
			PreparedStatement ps = Getconnection.getconnection().prepareStatement("select * from patient where id =?");
			
			ps.setInt(1, intid);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getInt(6));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
