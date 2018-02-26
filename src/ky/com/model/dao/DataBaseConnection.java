package ky.com.model.dao;

public class DataBaseConnection {
	private String username;
	private String passwd;
	private String url;
	private String jdbcDriver;
	
	public DataBaseConnection() {
		// TODO Auto-generated constructor stub
		username = "root";
		passwd = "1234";
		url = "jdbc:mysql://127.0.0.1:3306/parking?useUnicode=true&characterEncoding=utf8&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC";
		jdbcDriver ="com.mysql.jdbc.Driver";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}
	
}
