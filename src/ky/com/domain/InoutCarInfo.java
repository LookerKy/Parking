package ky.com.domain;

public class InoutCarInfo {
	private String carNumber;
	private String inputTime;
	private String outputTime;
	private String charging;
	private boolean carValidate;
	private boolean carExist;
	private String date;
	private String time;
	
	public String getInputTime() {
		return inputTime;
	}
	public void setInputTime(String inputTime) {
		this.inputTime = inputTime;
	}
	public String getOutputTime() {
		return outputTime;
	}
	public void setOutputTime(String outputTime) {
		this.outputTime = outputTime;
	}
	public String getCharging() {
		return charging;
	}
	public void setCharging(String charging) {
		this.charging = charging;
	}
	public boolean isCarValidate() {
		return carValidate;
	}
	public void setCarValidate(boolean carValidate) {
		this.carValidate = carValidate;
	}
	public boolean isCarExist() {
		return carExist;
	}
	public void setCarExist(boolean carExist) {
		this.carExist = carExist;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
