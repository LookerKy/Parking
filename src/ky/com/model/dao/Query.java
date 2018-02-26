package ky.com.model.dao;

public class Query {
	public String insertQuery() {
		StringBuffer sql = new StringBuffer("INSERT INTO parkingstatus(carNumber,inputDate,inputTime) VALUES(?,?,?)");
		return sql.toString();
	}
	public String lookupQuery() {
		StringBuffer sql = new StringBuffer("SELECT*FROM parkingstatus WHERE carNumber = ?");
		return sql.toString();
	}
	//출차시 parkingstatus 에서 차량정보 삭제 -> parking log table기록 
	public String deleteStatus() {
		StringBuffer sql = new StringBuffer("DELETE FROM parkingstatus WHERE carNumber = ?");
		return sql.toString();
	}
	public String insertLog() {
		StringBuffer sql = new StringBuffer("INSERT INTO parking_log(carNumber,inputTime,outputTime,charging,inoutstatus) VALUES(?,?,?,?,?)");
		return sql.toString();
	}
}
