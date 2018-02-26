package ky.com.model.Service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Locale;

import ky.com.domain.InoutCarInfo;
import ky.com.model.dao.InputCarDao;

public class InputCarService {
	private String inputTime;
	private InputCarDao inputCarDao;
	private boolean lookupStatus;
	public InputCarService() {
		// TODO Auto-generated constructor stub
		inputTime = "";
		inputCarDao = new InputCarDao();
	}
	public boolean lookupCarNumService(String carNumber){
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd HH:mm", Locale.KOREA ); 
		Date currentTime = new Date ( ); 
		inputTime = formatter.format ( currentTime ); 
		lookupStatus = false;
		try {
		lookupStatus = inputCarDao.lookupCarNum(carNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("서비스 조회결과:"+lookupStatus);
		return lookupStatus;

		
	}
	public Object nonLookupCar(String carNumber){
		InoutCarInfo carinfo = new InoutCarInfo();
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd HH:mm", Locale.KOREA ); 
		Date currentTime = new Date ( ); 
		inputTime = formatter.format ( currentTime );
		carinfo.setCarNumber(carNumber);
		carinfo.setInputTime(inputTime);
		carinfo.setOutputTime("-");
		carinfo.setCharging("-");
		return carinfo;
	}
	public void inputCar(Object object) throws SQLException {
		InoutCarInfo info = (InoutCarInfo) object;
		String fullTime[] = info.getInputTime().split(" ");
		String date = fullTime[0];
		String time = fullTime[1];
		info.setDate(date);
		info.setTime(time);
		inputCarDao.inputCar(info);
	}

	
}
