package myGameProjcet;

public class Warrior extends Hero {
	// 능력치 초기값
	private int power = 10;
	private int intt = 0;
	private int dex = 0;
	private int HP = 100;
	private int Money = 1000;
	public static int warriorand; // 패시브 스킬

	public int getMoney() {
		return Money;
	}

	public void setMoney(int money) {
		if (money >= 0) {
			this.Money = money;
		}

	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	private String name = "전사";

	public int getPower() {
		return power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPower(int power) {// 능력치 최소 보장
		if (power >= 2) {
			this.power = power;
		}
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

	@Override
	void Attach() {

		warriorand = (int) (Math.random() * 2) + 1;

		if (warriorand == 1) {// 패시브 스킬 크리티컬 5분의 1확률
			System.out.println("● 공격발동(패시브) : 격노🏃‍♀️🏃‍♀️");
		} else {
			System.out.println("● 공격발동 : 휘두르기🏃‍♀️🏃‍♀️");
		}

	}

}
