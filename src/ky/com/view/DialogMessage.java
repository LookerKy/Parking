package ky.com.view;

import javax.swing.JOptionPane;

public class DialogMessage {
	public DialogMessage() {
		// TODO Auto-generated constructor stub
	}
	public int InputCollectMessage(String message) {
		  int result = JOptionPane.showConfirmDialog(null, message+"�� �������� ���� �����Դϴ�.", "message",
                  JOptionPane.OK_CANCEL_OPTION);
		  
		  return result;
	}
	public void InputNonCollectMessage() {
		JOptionPane.showMessageDialog(null, "�ùٸ� ������ȣ�� �ƴմϴ�.", "�ùٸ��� ����.", JOptionPane.WARNING_MESSAGE);
	}
	public void existCarDialogMessage(String message) {
		JOptionPane.showMessageDialog(null, message+" �����Ͻðڽ��ϱ�?","Ȯ��", JOptionPane.WARNING_MESSAGE);
	}
	public void lookupBtnWarningMsg() {
		JOptionPane.showMessageDialog(null, "��ȸ��ư�� ���� �����ּ���","���", JOptionPane.WARNING_MESSAGE);
	}
	public void btnErrorMsg() {
		JOptionPane.showMessageDialog(null, "�Է��Ͻ� ���� ������ ���� �����ּ���","���", JOptionPane.WARNING_MESSAGE);
	}
	public void inputMoneyErrorMsg() {
		JOptionPane.showMessageDialog(null, "���� ���� �Է����ּ���","���", JOptionPane.WARNING_MESSAGE);
	}
	public void chargedErrorMsg() {
		JOptionPane.showMessageDialog(null, "������ ���� ���ּ���","���", JOptionPane.WARNING_MESSAGE);
	}
}
