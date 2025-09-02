package org.example.team1.clock;

public class DartGun {
	// 마취침 개수 (0~999)
	private int needleCnt;
	// 남은 마취약 약 (0mg~100mg)
	private int remainingAnesthetic;
	// 최대 바늘 개수
	private final int MAX_NEDDLE_CNT = 999;
	// 최소 바늘 개수
	private final int MIN_NEDDLE_CNT = 0;
	// 최대 마취약 양
	private final int MAX_REMAININGANCESTHETIC = 100;
	// 최소 마취약 양
	private final int MIN_REMAININGANCESTHETIC = 0;
	
	DartGun(){
		this.needleCnt=0;
		this.remainingAnesthetic=0;
	}
	
	public void shootNeedle() {
		if(needleCnt > MIN_NEDDLE_CNT ) {
			needleCnt--;
			System.out.println("마취침 발사");
		}else {
			System.out.println("마취침 개수 부족");
		}
	}
	
	public void setNeedle(int needleCnt) {
		int remain = this.needleCnt + needleCnt - MAX_NEDDLE_CNT; //남은 공간 계산
		if(remain<=MIN_NEDDLE_CNT) {
			this.needleCnt+=needleCnt;
			System.out.println(this.needleCnt+"개 충전 완료");
		}else {
			System.out.println("충전 가능한 양을 넘었습니다.");
		}
	}
	
	public void setRemainingAnesthetic(int remainingAnesthetic) {
		int remain = this.remainingAnesthetic + remainingAnesthetic - MAX_REMAININGANCESTHETIC;
		if(remain<=MIN_REMAININGANCESTHETIC) {
			this.remainingAnesthetic+=remainingAnesthetic;
			System.out.println(this.remainingAnesthetic+"개 충전 완료");
		}else {
			System.out.println("충전 가능한 양을 넘었습니다.");
		}
	}
}
