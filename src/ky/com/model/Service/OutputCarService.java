package ky.com.model.Service;

import java.sql.SQLException;

import ky.com.model.dao.OutputCarDao;

public class OutputCarService {
	private OutputCarDao outputCarDao;
	public OutputCarService() {
		// TODO Auto-generated constructor stub
		this.outputCarDao = new OutputCarDao();
	}
	public void outPutCar(Object object) throws SQLException {
		outputCarDao.outPutCar(object);
	}
}
