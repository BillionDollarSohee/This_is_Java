package org.example.team1.clock;

import java.util.UUID;

public class Battery {
	private String SerialNumber;
	private BatteryCell[] cells;
	private int chargingPercent; // 0~100
	public Battery(BatteryCell[] cells){
		this.cells = cells;
		this.SerialNumber = initSerial();
	}
	private String initSerial() {
		// �̴ֽø��� ����
		return UUID.randomUUID().toString().replace("-", "").substring(0,10);
	}
	public void charging(Battery battery) {
		if(0<= battery.chargingPercent && battery.chargingPercent <=95 ) {
			battery.chargingPercent += 5;
			System.out.println("5% charging, 현재 배터리: " + battery.chargingPercent + "%");
		}
	}
	public void change(Battery battery) {
		this.SerialNumber = battery.SerialNumber;
		this.cells = battery.cells;
		this.chargingPercent = battery.chargingPercent;
	}
}
