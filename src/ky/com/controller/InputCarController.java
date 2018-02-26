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
		 String regex = "^\\d{2}[가|나|다|라|마|거|너|더|러|머|버|서|어|저|고|노|도|로|모|보|소|오|조|구|누|두|루|무|부|수|우|주|바|사|아|자|허|배|호|하\\x20]\\d{4}/*$";
		 Pattern p = Pattern.compile(regex);
		 Matcher m = p.matcher(carNum);
		 if(m.matches()) {
			 //서비스호출 
			 System.out.println("차량번호 형식 맞음");
			 boolean lookupResult=inputCarService.lookupCarNumService(carNum);
			 if(!lookupResult) {
				 //object에 true추가 후 입차 정보까지 날려
				 info = (InoutCarInfo) inputCarService.nonLookupCar(carNum);
				 info.setCarValidate(true);
				 info.setCarExist(lookupResult);
				 return info;
			 }else {
				 //정산요금까지 계산하는 서비스 호출
				 //임시로 만들어둬버리기~
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
			 //false 리턴
			 System.out.println("차량번호 형식이 아님");
			 info = new InoutCarInfo();
			 info.setCarValidate(false);
			 return info;
		 }
	
		 
	}
	public void inputCar(Object object) throws SQLException {
		inputCarService.inputCar(object);
	}
	
}
