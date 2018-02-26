package ky.com.model.Service;

import java.sql.SQLException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import ky.com.domain.InoutCarInfo;
import ky.com.model.dao.ChargingDao;

public class ChargingService {
	private ChargingDao chargingDao;
	
	public ChargingService() {
		// TODO Auto-generated constructor stub
		chargingDao = new ChargingDao();
	}
	public Object chargingCar(String carNumber) throws SQLException{
		InoutCarInfo info = (InoutCarInfo) chargingDao.chargingCar(carNumber);
		String date = info.getDate();
		String time = info.getTime();
		String outputTime = outputTimeCal();
		info.setInputTime(date+" "+time);
		info.setOutputTime(outputTime);
		info.setCharging(calfee(date+" "+time,outputTime));
		return info;
	}
	public String outputTimeCal() {
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd HH:mm", Locale.KOREA ); 
		Date currentTime = new Date ( ); 
		String outputTime = formatter.format ( currentTime );
		return outputTime;
	}
	public String calfee(String inputTime , String outputTime) {
		SimpleDateFormat inft = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
		SimpleDateFormat outft= new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
		Date inFtime = inft.parse(inputTime,new ParsePosition(0));
		Date outFtime = outft.parse(outputTime,new ParsePosition(0));
		long inFulltime = inFtime.getTime();
		long outFulltime = outFtime.getTime();
		long totalmin = (outFulltime - inFulltime)/60000;
		System.out.println("������ ������ "+totalmin+" �����Դϴ�.");
		long totalfee = totalmin*100;
		String result = String.valueOf(totalfee+" ��");
		System.out.println("�����ݾ��� "+result+" �� �Դϴ�.");
		return result;
	}
}
