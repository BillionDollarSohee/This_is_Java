package org.example.team1.clock;

public class WatchApp {

	public static void main(String[] args) {
		 Watch watch = new Watch("John Doe");        
	        // 배터리 충전 테스트
	        watch.chargeBattery(); // 5% 충전
	        
	        // 배터리 교체 테스트
	        watch.changeBattery(); // 새로운 배터리로 교체
	        
	        // 디스플레이 테스트
	        watch.brightnessUp();  // 밝기 증가
	        watch.brightnessDown(); // 밝기 감소
	        watch.changeScreenState(); // 화면 전원 상태 변경
	        watch.changeBlockBlueLight(); // 블루라이트 차단 상태 변경

	        // 마취총 테스트
	        watch.setNeedle(10); // 마취침 10개 충전
	        watch.shootNeedle(); // 마취침 발사
	        watch.shootNeedle(20); // 마취약 20mg 충전
	        
	        // GPS 테스트
	        watch.gpsUpdate(37.5665, 126.9780); // 서울의 위도, 경도 업데이트

	        // 라디오 테스트
	        watch.HertzToTime(10); // 시간 변환 (주파수: 10)
	        
	        // 시계 시간 출력 테스트
	        watch.printTime(); // 현재 시간 출력
	        
	        // 시계 날짜 출력 테스트
	        watch.printDate(); // 현재 날짜 출력
	}
}
