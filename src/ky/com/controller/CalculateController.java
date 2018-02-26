package ky.com.controller;

import java.util.StringTokenizer;

import ky.com.model.Service.CalculateService;

public class CalculateController {
	CalculateService calculateService;
	public CalculateController() {
		// TODO Auto-generated constructor stub
		calculateService = new CalculateService();
	}
	public String calcuating(String rcvMoney , String charging) {
		StringTokenizer token = new StringTokenizer(charging, " ");
		charging = token.nextToken();
		return calculateService.calcuating(rcvMoney, charging);
	}
}
