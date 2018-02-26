package ky.com.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ky.com.domain.InoutCarInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InputCarDao {
	private DataBaseConnection dataBaseConnection;
	private Query query;
	public InputCarDao() {
		// TODO Auto-generated constructor stub
		dataBaseConnection = new DataBaseConnection();
		query = new Query();
	}
	public boolean lookupCarNum(String carNumber) throws SQLException {
		boolean lookupStatus=false;
		try {
			Class.forName(dataBaseConnection.getJdbcDriver());
			Connection connection = DriverManager.getConnection(dataBaseConnection.getUrl(),dataBaseConnection.getUsername(),dataBaseConnection.getPasswd());
			System.out.println("db���� �Ϸ�..");
			PreparedStatement psmt = connection.prepareStatement(query.lookupQuery());
			psmt.setString(1, carNumber);
			ResultSet rs = psmt.executeQuery();
			lookupStatus = rs.isBeforeFirst();
			System.out.println("��ȸ���: "+lookupStatus);
			psmt.clearParameters();
			rs.close();
			psmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lookupStatus;
		
	}
	public void inputCar(Object object) throws SQLException {
		//�����Ϳ��� ����
		InoutCarInfo info = (InoutCarInfo) object;
		try {
			Class.forName(dataBaseConnection.getJdbcDriver());
			Connection connection = DriverManager.getConnection(dataBaseConnection.getUrl(),dataBaseConnection.getUsername(),dataBaseConnection.getPasswd());
			System.out.println("db���� �Ϸ�..");
			PreparedStatement psmt = connection.prepareStatement(query.insertQuery());
			psmt.setString(1, info.getCarNumber());
			psmt.setString(2, info.getDate());
			psmt.setString(3, info.getTime());
			psmt.executeUpdate();
			System.out.println("���� �߰� �Ϸ�");
			psmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
