package ky.com.controller;

import ky.com.domain.SharedMemory;
import ky.com.view.IndexView;

public class MainController {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		SharedMemory sharedMemory = SharedMemory.getInstance();
		IndexView indexView = new IndexView();
		indexView.MainFrame();
	}

}
