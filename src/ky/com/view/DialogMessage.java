package ky.com.view;

import javax.swing.JOptionPane;

public class DialogMessage {
	public DialogMessage() {
		// TODO Auto-generated constructor stub
	}
	public int InputCollectMessage(String message) {
		  int result = JOptionPane.showConfirmDialog(null, message+"는 입차되지 않은 차량입니다.", "message",
                  JOptionPane.OK_CANCEL_OPTION);
		  
		  return result;
	}
	public void InputNonCollectMessage() {
		JOptionPane.showMessageDialog(null, "올바른 차량번호가 아닙니다.", "올바르지 않음.", JOptionPane.WARNING_MESSAGE);
	}
	public void existCarDialogMessage(String message) {
		JOptionPane.showMessageDialog(null, message+" 정산하시겠습니까?","확인", JOptionPane.WARNING_MESSAGE);
	}
	public void lookupBtnWarningMsg() {
		JOptionPane.showMessageDialog(null, "조회버튼을 먼저 눌러주세요","경고", JOptionPane.WARNING_MESSAGE);
	}
	public void btnErrorMsg() {
		JOptionPane.showMessageDialog(null, "입력하신 차량 출차를 먼저 눌러주세요","경고", JOptionPane.WARNING_MESSAGE);
	}
	public void inputMoneyErrorMsg() {
		JOptionPane.showMessageDialog(null, "받은 돈을 입력해주세요","경고", JOptionPane.WARNING_MESSAGE);
	}
	public void chargedErrorMsg() {
		JOptionPane.showMessageDialog(null, "정산을 먼저 해주세요","경고", JOptionPane.WARNING_MESSAGE);
	}
}
