package myGameProjcet;

public class thief extends Hero { // 도적
	// 능력치 초기값
	private int power = 0;
	private int intt = 0;
	private int dex = 10;
	private int HP = 90;
	private int Money = 1000;

	public int getMoney() {
		return Money;
	}

	public void setMoney(int money) {
		if (money >= 0) {
			this.Money = money;
		}
	}

	private String name = "도적";

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getIntt() {
		return intt;
	}

	public void setIntt(int intt) {
		this.intt = intt;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {//능력치 최소보장
		if(dex >= 2){
			this.dex = dex;
		}
	}

	@Override
	void Attach() {
		RPG.Sound("ThiefAttack.wav", false);
		System.out.println("● 공격발동 : 럭키세븐★★");
	}

}
