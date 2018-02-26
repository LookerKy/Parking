package ky.com.controller;

import java.sql.SQLException;

import ky.com.model.Service.OutputCarService;

public class OutputCarController {
	private OutputCarService outputCarService;
	public OutputCarController() {
		// TODO Auto-generated constructor stub
		this.outputCarService = new OutputCarService();
	}
	public void outPutCar(Object object) throws SQLException {
		outputCarService.outPutCar(object);
	}
	
}
