package ky.com.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ky.com.controller.CalculateController;
import ky.com.controller.InputCarController;
import ky.com.controller.OutputCarController;
import ky.com.domain.InoutCarInfo;
import ky.com.domain.SharedMemory;

public class IndexView {
	/**
	 * 
	 */
	private boolean lookupbtn_status;
	private boolean inputcarbtn_status;
	private boolean chargedbtn_status;

	private JFrame mainFrame;
	private Container container;
	private JPanel firstPanel;
	private JPanel secondPanel;
	private JTextField carNumber;
	private JTextField inputTime;
	private JTextField outputTime;
	private JTextField charging;
	private JTextField charged;
	private JTextField change;
	private JLabel carNumberString;
	private JLabel inputTimeString;
	private JLabel outputTimeString;
	private JLabel chargingString;
	private JLabel chargedString;
	private JLabel changeString;
	private Button checkbtn;
	private Button inputbtn;
	private Button outputbtn;
	private Button chargebtn;
	private GridBagConstraints gridBagConstraints;

	private InputCarController inputCarController;
	private CalculateController calculateController;
	private OutputCarController outputCarController;
	@SuppressWarnings("unused")
	private SharedMemory sharedMemory;
	private DialogMessage dialogMessage;

	public IndexView() {
		// TODO Auto-generated constructor stub
		mainFrame = new JFrame();
		container = new Container();
		firstPanel = new JPanel();
		secondPanel = new JPanel();
		carNumber = new JTextField(20);
		inputTime = new JTextField(20);
		outputTime = new JTextField(20);
		charging = new JTextField(20);
		charged = new JTextField(20);
		change = new JTextField(20);
		carNumberString = new JLabel("���� ��ȣ");
		inputTimeString = new JLabel("���� �ð�");
		outputTimeString = new JLabel("���� �ð�");
		chargingString = new JLabel("���� �ݾ�");
		chargedString = new JLabel("�����ݾ�");
		changeString = new JLabel("�Ž��� ��");
		checkbtn = new Button("��ȸ");
		inputbtn = new Button("����");
		outputbtn = new Button("����");
		chargebtn = new Button("����");
		gridBagConstraints = new GridBagConstraints();
		this.inputCarController = new InputCarController();
		this.calculateController = new CalculateController();
		this.outputCarController = new OutputCarController();
		sharedMemory = SharedMemory.getInstance();
		dialogMessage = new DialogMessage();
		lookupbtn_status = false;
		inputcarbtn_status = true;
		chargedbtn_status = false;
	}

	public void MainFrame() {
		mainFrame.setTitle("���� �ý���");
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		int width = res.width - 800;
		int height = res.height - 500;
		// System.out.println(res.width + " "+ res.height);
		mainFrame.setSize(width, height);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		settingComponent();
		// setting_gridbag();
		settingFirstPanel();
		settingSecondPanel();
		container = mainFrame.getContentPane();
		container.add(firstPanel, BorderLayout.CENTER);
		container.add(secondPanel, BorderLayout.SOUTH);
		mainFrame.setVisible(true);
	}

	private void settingComponent() {
		carNumberString.setFont(carNumberString.getFont().deriveFont(15.0f));
		inputTimeString.setFont(inputTimeString.getFont().deriveFont(15.0f));
		outputTimeString.setFont(outputTimeString.getFont().deriveFont(15.0f));
		chargingString.setFont(chargingString.getFont().deriveFont(20.0f));
		chargedString.setFont(chargedString.getFont().deriveFont(20.0f));
		changeString.setFont(changeString.getFont().deriveFont(20.0f));

		checkbtn.setPreferredSize(new Dimension(50, 25));
		inputbtn.setPreferredSize(new Dimension(80, 35));
		outputbtn.setPreferredSize(new Dimension(80, 35));
		chargebtn.setPreferredSize(new Dimension(80, 35));

		inputTime.setEditable(false);
		outputTime.setEditable(false);
		charging.setEditable(false);
		change.setEditable(false);

		charged.setText(null);
	}

	private void settingFirstPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		firstPanel.setLayout(gridBagLayout);
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		gridBagConstraints.insets = new Insets(24, 30, 0, 4);
		firstPanel.add(carNumberString, gridBagConstraints);

		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.fill = GridBagConstraints.NONE;
		gridBagConstraints.ipady = 7;
		gridBagConstraints.insets = new Insets(20, 0, 0, 0);
		firstPanel.add(carNumber, gridBagConstraints);

		gridBagConstraints.weightx = 3.0;
		gridBagConstraints.insets = new Insets(18, 0, 0, 4);
		firstPanel.add(checkbtn, gridBagConstraints);

		gridBagConstraints.gridy = 10;
		gridBagConstraints.weightx = 0.0;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.ipady = 0;
		gridBagConstraints.insets = new Insets(24, 30, 0, 4);
		firstPanel.add(inputTimeString, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.ipady = 7;
		gridBagConstraints.insets = new Insets(20, 0, 0, 2);
		firstPanel.add(inputTime, gridBagConstraints);

		gridBagConstraints.gridy = 20;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.ipady = 0;
		gridBagConstraints.weighty = 0.2;
		gridBagConstraints.weightx = 0.0;
		gridBagConstraints.insets = new Insets(24, 30, 0, 4);
		firstPanel.add(outputTimeString, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.ipady = 7;
		gridBagConstraints.insets = new Insets(20, 0, 0, 2);
		firstPanel.add(outputTime, gridBagConstraints);

		gridBagConstraints.gridy = 30;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.ipady = 0;
		gridBagConstraints.weighty = 0.4;
		gridBagConstraints.weightx = 0.0;
		gridBagConstraints.insets = new Insets(40, 30, 0, 6);
		firstPanel.add(chargingString, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.ipady = 15;
		gridBagConstraints.insets = new Insets(36, 0, 0, 2);
		firstPanel.add(charging, gridBagConstraints);

		gridBagConstraints.gridy = 40;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.ipady = 0;
		gridBagConstraints.weighty = 0.5;
		gridBagConstraints.weightx = 0.0;
		gridBagConstraints.insets = new Insets(40, 30, 0, 6);
		firstPanel.add(chargedString, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.ipady = 15;
		gridBagConstraints.insets = new Insets(36, 0, 0, 2);
		firstPanel.add(charged, gridBagConstraints);

		gridBagConstraints.gridy = 50;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.ipady = 0;
		gridBagConstraints.weighty = 0.6;
		gridBagConstraints.weightx = 0.0;
		gridBagConstraints.insets = new Insets(38, 30, 0, 6);
		firstPanel.add(changeString, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.ipady = 15;
		gridBagConstraints.insets = new Insets(34, 0, 0, 2);
		firstPanel.add(change, gridBagConstraints);
	}

	private void settingSecondPanel() {
		FlowLayout btnLayout = new FlowLayout(FlowLayout.CENTER, 20, 3);
		secondPanel.setLayout(btnLayout);
		checkbtn.addActionListener(btnActionHandler());
		inputbtn.addActionListener(btnActionHandler());
		chargebtn.addActionListener(btnActionHandler());
		outputbtn.addActionListener(btnActionHandler());
		secondPanel.add(inputbtn);
		secondPanel.add(chargebtn);
		secondPanel.add(outputbtn);
	}

	private ActionListener btnActionHandler() {

		ActionListener handler = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getActionCommand().equals("��ȸ")) {
					String s = carNumber.getText();
					// ���� ��ȣ ���� Ȯ��
					InoutCarInfo info = (InoutCarInfo) inputCarController.validateCarNumber(s);
					if (info.isCarValidate()) {
						// ���̾�α� ȣ��
						if (!info.isCarExist()) {
							int result = dialogMessage.InputCollectMessage(carNumber.getText());
							if (result == 0) {
								carNumber.setEnabled(false);
								inputTime.setText(info.getInputTime());
								outputTime.setText(info.getOutputTime());
								charging.setText(info.getCharging());
								lookupbtn_status = true; // ���ȴٴ� �ǹ�
								System.out.println("��");
							}
						} else {
							/** ���������� ���� **/
							// ������ �̹� ������ ���
							dialogMessage.existCarDialogMessage(carNumber.getText());
							carNumber.setEnabled(false);
							inputTime.setText(info.getInputTime());
							outputTime.setText(info.getOutputTime());
							charging.setText(info.getCharging());
							lookupbtn_status = true;
							inputcarbtn_status = false;
							System.out.println(charged.getText());
							// �����ÿ� �ٽ� ��ư �������� lookup => false , inputcar => true
							System.out.println("����2");
						}
					} else {
						// ���̾�α� ȣ��
						dialogMessage.InputNonCollectMessage();
						setText();
						lookupbtn_status = false;
						System.out.println("����");
					}
				} else if (e.getActionCommand().equals("����")) {
					if (lookupbtn_status && inputcarbtn_status) {
						try {
							InoutCarInfo info = new InoutCarInfo();
							info.setCarNumber(carNumber.getText());
							info.setInputTime(inputTime.getText());
							System.out.println(info.getCarNumber() + info.getInputTime());
							inputCarController.inputCar(info);
							setText();
							carNumber.setEnabled(true);
							lookupbtn_status = false;
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (!lookupbtn_status && inputcarbtn_status)// ��ȸ��ư�� �������ʾѰ� ������ư Ȱ��ȭ�� ��
					{
						dialogMessage.lookupBtnWarningMsg();
					} else // ���� ��� ���쵵 �������� ��
					{
						dialogMessage.btnErrorMsg();
					}
				} else if (e.getActionCommand().equals("����")) {
					if (charged.getText().equals("") && !lookupbtn_status) {
						// ���̾�α� ȣ��
						dialogMessage.inputMoneyErrorMsg();
					} else {
						// ��Ʈ�ѷ��� �ݾ� ������
						// ���񽺿��� �ݾ� ���� �޾Ƽ� setting
						String result = calculateController.calcuating(charged.getText(), charging.getText());
						change.setText(result);
						chargedbtn_status = true;
					}

				} else if (e.getActionCommand().equals("����")) {
					if (lookupbtn_status && chargedbtn_status) {
						InoutCarInfo info = new InoutCarInfo();
						info.setCarNumber(carNumber.getText());
						info.setInputTime(inputTime.getText());
						info.setOutputTime(outputTime.getText());
						info.setCharging(charging.getText());
						try {
							outputCarController.outPutCar(info);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						setText();
						carNumber.setEnabled(true);
						lookupbtn_status = false;
						chargedbtn_status = false;
						inputcarbtn_status = true;
					} else {
						dialogMessage.chargedErrorMsg();
					}

				}
			}

		};
		return handler;
	}

	// esc enter ��� ����� , ����
	public void setText() {
		carNumber.setText(null);
		inputTime.setText(null);
		outputTime.setText(null);
		charging.setText(null);
		charged.setText(null);
		change.setText(null);
	}
}
