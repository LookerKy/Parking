package ky.com.controller;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ky.com.domain.InoutCarInfo;
import ky.com.model.Service.ChargingService;
import ky.com.model.Service.InputCarService;

public class InputCarController {
	private String carNum;
	private InputCarService inputCarService;
	private ChargingService chargingService;
	private InoutCarInfo info;

	public InputCarController() {
		// TODO Auto-generated constructor stub
		this.inputCarService = new InputCarService();
		this.chargingService = new ChargingService();
	}
	public Object validateCarNumber(String carNumber){
		System.out.println(carNumber);
	     carNum = carNumber.replaceAll(" ", "");
		 String regex = "^\\d{2}[��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|��|ȣ|��\\x20]\\d{4}/*$";
		 Pattern p = Pattern.compile(regex);
		 Matcher m = p.matcher(carNum);
		 if(m.matches()) {
			 //����ȣ�� 
			 System.out.println("������ȣ ���� ����");
			 boolean lookupResult=inputCarService.lookupCarNumService(carNum);
			 if(!lookupResult) {
				 //object�� true�߰� �� ���� �������� ����
				 info = (InoutCarInfo) inputCarService.nonLookupCar(carNum);
				 info.setCarValidate(true);
				 info.setCarExist(lookupResult);
				 return info;
			 }else {
				 //�����ݱ��� ����ϴ� ���� ȣ��
				 //�ӽ÷� �����ֹ�����~
				 try {
					info = (InoutCarInfo) chargingService.chargingCar(carNumber);
					
				 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 info.setCarExist(lookupResult);
				 info.setCarValidate(true);
				 return info;
			 }
		 }else {
			 //false ����
			 System.out.println("������ȣ ������ �ƴ�");
			 info = new InoutCarInfo();
			 info.setCarValidate(false);
			 return info;
		 }
	
		 
	}
	public void inputCar(Object object) throws SQLException {
		inputCarService.inputCar(object);
	}
	
}
