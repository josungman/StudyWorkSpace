package myGameProjcet;

public class Wizard extends Hero {
	//능력치 초기값
	private int power = 0;
	private int intt = 10;
	public int getMoney() {
		return Money;
	}

	public void setMoney(int money) {
		if (money >= 0) {
			this.Money = money;
		}
		
	}


	private int dex = 0;
	private int Money = 1000;
	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}


	private int HP = 80;
	private String name = "법사";
	
	
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
		if(intt >= 2){
			this.intt = intt;
		}
		
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	
	@Override
	void Attach() {
		System.out.println("● 공격발동 : 매직클로🙏‍🙏");
	}

	
	
}
