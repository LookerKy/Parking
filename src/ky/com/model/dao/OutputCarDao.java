package ky.com.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ky.com.domain.InoutCarInfo;

public class OutputCarDao {
	private DataBaseConnection dataBaseConnection;
	private Query query;
	public OutputCarDao() {
		// TODO Auto-generated constructor stub
		this.dataBaseConnection = new DataBaseConnection();
		this.query = new Query();
	}
	//delete query + insert query
	public void outPutCar(Object object) throws SQLException{
		InoutCarInfo info = (InoutCarInfo)object;
		Connection connection = null;
		PreparedStatement psmt1 = null;
		PreparedStatement psmt2 = null;
		try {
			Class.forName(dataBaseConnection.getJdbcDriver());
			connection = DriverManager.getConnection(dataBaseConnection.getUrl(),dataBaseConnection.getUsername(),dataBaseConnection.getPasswd());
			System.out.println("db연결 완료..");
			psmt1 = connection.prepareStatement(query.deleteStatus());
			psmt1.setString(1, info.getCarNumber());
			psmt1.executeUpdate();
			System.out.println("컬럼 삭제 완료");
			psmt2 = connection.prepareStatement(query.insertLog());
			psmt2.setString(1, info.getCarNumber());
			psmt2.setString(2, info.getInputTime());
			psmt2.setString(3, info.getOutputTime());
			psmt2.setString(4, info.getCharging());
			psmt2.setBoolean(5, true);
			psmt2.executeUpdate();
			System.out.println("쿼리 추가 완료");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(psmt1 != null) psmt1.close();
			if(psmt2 != null) psmt2.close();
			if(connection !=null) connection.close();
		}
	}
}
