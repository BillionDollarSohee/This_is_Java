package org.basic.team1.clock;

import java.util.UUID;

public class BatteryCell {
	private String SerialNumber;
	public BatteryCell() {
		SerialNumber = initSerial();
	}
	private String initSerial() {
		return UUID.randomUUID().toString().replace("-", "").substring(0,9);
	}
}
