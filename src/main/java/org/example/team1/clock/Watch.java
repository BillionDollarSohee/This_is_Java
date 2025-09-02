package org.example.team1.clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Watch {
	private String watchSerialNum;	//시계 시리얼 넘버
	private int watchSize;	//시계 직경
	private String ownerName;	//소유자 이름
	//부품
	private Battery battery;
	private Display display;
	private DartGun dartGun;
	private Gps gps;
	private Radio radio;
	
	public Watch() {
		this("소유자");
	}
	
	public Watch(String ownerName) {
		this.watchSerialNum = createWatchSerialNum();
		this.watchSize = 28;
		this.ownerName = ownerName;
		this.battery = getBattery();
		this.display = new Display();
		this.dartGun = new DartGun();
		this.gps = new Gps();
		this.radio = new Radio();
	}
	
	private String createWatchSerialNum(){
		return UUID.randomUUID().toString().replace("-", "").substring(0,11);
	}
	
	//battery 함수 접근
	public void chargeBattery() {
		this.battery.charging(getBattery());
	}
	public void changeBattery() {
		this.battery.change(getBattery());
	}
	
	//Display 클래스 함수 접근
	public void brightnessUp() {
		this.display.brightnessUp();
	}
	public void brightnessDown() {
		this.display.brightnessDown();
	}
	public void changeScreenState() {
		this.display.changeScreenState();
	}
	public void changeBlockBlueLight() {
		this.display.changeBlockBlueLight();
	}
	
	//마취총 클래스 함수 접근
	public void shootNeedle() {
		this.dartGun.shootNeedle();
	}
	public void setNeedle(int needleCnt) {
		this.dartGun.setNeedle(needleCnt);
	}
	public void shootNeedle(int remainingAnesthetic) {
		this.dartGun.setRemainingAnesthetic(remainingAnesthetic);
	}
	
	//gps 클래스 함수 접근
	public void gpsUpdate(double lon, double lat) {
		this.gps.gpsUpdate(lon, lat);
	}
	
	//radio 클래스 함수 접근
	public void HertzToTime(int Hertz) {
		this.radio.HertzToTime(Hertz);
	}
	
	//시계 고유 기능
	public void printTime() {
		System.out.println(LocalDateTime.now());
	}
	public void printDate() {		
		System.out.println(LocalDate.now());
	}
	public Battery getBattery() {
		return new Battery(new BatteryCell[] {new BatteryCell(),new BatteryCell()});
	}
}
