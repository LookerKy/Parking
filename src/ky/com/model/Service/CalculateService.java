package ky.com.model.Service;

public class CalculateService {
	public CalculateService() {
		// TODO Auto-generated constructor stub
	}
	public String calcuating(String rcvMoney , String charging) {
		int result = Integer.parseInt(rcvMoney) - Integer.parseInt(charging);
		String s = String.valueOf(result);
		return s;
	}
}
