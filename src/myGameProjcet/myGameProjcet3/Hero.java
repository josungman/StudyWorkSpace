package myGameProjcet;

public abstract class Hero { // 영웅 기본 속성 및 기능 설계

	// 힘,지능,민첩,영웅클래스이름
	int power;
	int intt;
	int dex;
	String name;
	int HP;
	int Money;
	
	public int getMoney() {
		return Money;
	}

	public void setMoney(int money) {
		Money = money;
	}

	// 공격
	abstract void Attach();

	public int getPower() {
		return power;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
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

	public void setDex(int dex) {
		this.dex = dex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
