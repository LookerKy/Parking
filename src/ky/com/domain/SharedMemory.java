package ky.com.domain;

import javax.swing.JTextField;

public class SharedMemory {
    private static SharedMemory sharedMemory = null;

    public static synchronized SharedMemory getInstance() {
        if (sharedMemory == null) {
            sharedMemory = new SharedMemory();
        }
        return sharedMemory;
    }

   private String carNumber;
   private JTextField outputTime;
   private JTextField charing;
   private JTextField charged;
   private String inputTime;
   
public String getCarNumber() {
	return carNumber;
}
public void setCarNumber(String carNumber) {
	this.carNumber = carNumber;
}
public String getInputTime() {
	return inputTime;
}
public void setInputTime(String inputTime) {
	this.inputTime = inputTime;
}
public JTextField getOutputTime() {
	return outputTime;
}
public void setOutputTime(JTextField outputTime) {
	this.outputTime = outputTime;
}
public JTextField getCharing() {
	return charing;
}
public void setCharing(JTextField charing) {
	this.charing = charing;
}
public JTextField getCharged() {
	return charged;
}
public void setCharged(JTextField charged) {
	this.charged = charged;
}

   

}
