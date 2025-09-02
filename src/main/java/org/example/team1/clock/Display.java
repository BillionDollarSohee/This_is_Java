package org.example.team1.clock;

import java.util.UUID;

public class Display {
	private String displaySerialNum;	//화면 시리얼 넘버
	private int displaySize;	//화면 크기
	
	private int brightness;	//화면 밝기
	private boolean screenState;	//화면 전원 상태
	private boolean blockBlueLight;	//블루라이트 차단 기능 상태
	
	public Display(){
		this.displaySerialNum = createDisplaySerialNum();
		this.displaySize = 10;
		this.brightness = 50;
		this.screenState = false;
		this.blockBlueLight = false;
	}
	
	//시리얼 넘버 생성
	private String createDisplaySerialNum(){
		return UUID.randomUUID().toString().replace("-", "").substring(0,12);
	}
	
	//화면 밝기 높이기(최대 100)
	public void brightnessUp() {
		if(this.brightness<95) this.brightness += 5;
		else this.brightness = 100;
	}
	//화면 밝기 낮추기(최소 0)
	public void brightnessDown() {
		if(this.brightness>5) this.brightness -= 5;
		else this.brightness = 0;
	}
	
	//화면 전원 on/off
	public void changeScreenState() {
		this.screenState = !this.screenState;
	}
	
	//블루라이트 차단 기능 on/off
	public void changeBlockBlueLight() {
		this.blockBlueLight = !this.blockBlueLight;
	}

}
