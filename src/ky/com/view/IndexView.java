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
		carNumberString = new JLabel("차량 번호");
		inputTimeString = new JLabel("입차 시간");
		outputTimeString = new JLabel("출차 시간");
		chargingString = new JLabel("산출 금액");
		chargedString = new JLabel("받은금액");
		changeString = new JLabel("거스름 돈");
		checkbtn = new Button("조회");
		inputbtn = new Button("입차");
		outputbtn = new Button("출차");
		chargebtn = new Button("정산");
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
		mainFrame.setTitle("주차 시스템");
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
				if (e.getActionCommand().equals("조회")) {
					String s = carNumber.getText();
					// 차량 번호 형식 확인
					InoutCarInfo info = (InoutCarInfo) inputCarController.validateCarNumber(s);
					if (info.isCarValidate()) {
						// 다이얼로그 호출
						if (!info.isCarExist()) {
							int result = dialogMessage.InputCollectMessage(carNumber.getText());
							if (result == 0) {
								carNumber.setEnabled(false);
								inputTime.setText(info.getInputTime());
								outputTime.setText(info.getOutputTime());
								charging.setText(info.getCharging());
								lookupbtn_status = true; // 눌렸다는 의미
								System.out.println("참");
							}
						} else {
							/** 출차데이터 산출 **/
							// 차량이 이미 입차된 경우
							dialogMessage.existCarDialogMessage(carNumber.getText());
							carNumber.setEnabled(false);
							inputTime.setText(info.getInputTime());
							outputTime.setText(info.getOutputTime());
							charging.setText(info.getCharging());
							lookupbtn_status = true;
							inputcarbtn_status = false;
							System.out.println(charged.getText());
							// 출차시에 다시 버튼 돌려놓기 lookup => false , inputcar => true
							System.out.println("들어옴2");
						}
					} else {
						// 다이얼로그 호출
						dialogMessage.InputNonCollectMessage();
						setText();
						lookupbtn_status = false;
						System.out.println("거짓");
					}
				} else if (e.getActionCommand().equals("입차")) {
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
					} else if (!lookupbtn_status && inputcarbtn_status)// 조회버튼이 눌리지않앗고 입차버튼 활성화일 때
					{
						dialogMessage.lookupBtnWarningMsg();
					} else // 위의 경우 어떤경우도 맞지않을 때
					{
						dialogMessage.btnErrorMsg();
					}
				} else if (e.getActionCommand().equals("정산")) {
					if (charged.getText().equals("") && !lookupbtn_status) {
						// 다이얼로그 호출
						dialogMessage.inputMoneyErrorMsg();
					} else {
						// 컨트롤러에 금액 던지고
						// 서비스에서 금액 리턴 받아서 setting
						String result = calculateController.calcuating(charged.getText(), charging.getText());
						change.setText(result);
						chargedbtn_status = true;
					}

				} else if (e.getActionCommand().equals("출차")) {
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

	// esc enter 기능 만들고 , 출차
	public void setText() {
		carNumber.setText(null);
		inputTime.setText(null);
		outputTime.setText(null);
		charging.setText(null);
		charged.setText(null);
		change.setText(null);
	}
}
