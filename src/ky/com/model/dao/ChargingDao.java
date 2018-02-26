package ky.com.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ky.com.domain.InoutCarInfo;

public class ChargingDao {
	private DataBaseConnection dataBaseConnection;
	private Query query;
	public ChargingDao() {
		// TODO Auto-generated constructor stub
		this.dataBaseConnection = new DataBaseConnection();
		this.query = new Query();
	}
	public Object chargingCar(String carNumber) throws SQLException {
		InoutCarInfo info = new InoutCarInfo();
		try {
			Class.forName(dataBaseConnection.getJdbcDriver());
			Connection connection = DriverManager.getConnection(dataBaseConnection.getUrl(),dataBaseConnection.getUsername(),dataBaseConnection.getPasswd());
			System.out.println("db연결 완료..");
			PreparedStatement psmt = connection.prepareStatement(query.lookupQuery());
			psmt.setString(1, carNumber);
			ResultSet rs =psmt.executeQuery();
			while(rs.next()) {
				info.setDate(rs.getString("inputDate"));
				info.setTime(rs.getString("inputTime"));
			}
			rs.close();
			psmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}
	
	
}
