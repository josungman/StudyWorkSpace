package myGameProjcet;

public class DeepSea_Killerwhale extends Monster {

	private String name = "범고래";
	private int dropMoney;
	private int HP=100;
	private String Attackname = "꼬리치기";
	private int Attacknum = 45;
	
	public String getAttackname() {
		return Attackname;
	}
	public void setAttackname(String attackname) {
		Attackname = attackname;
	}
	public int getAttacknum() {
		RPG.Sound("Bat.wav", false); //사운드
		return Attacknum;
	}
	public void setAttacknum(int attacknum) {
		Attacknum = attacknum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDropMoney() {//10원에서 13원 사이 머니 드롭
		RPG.Sound("MoneyDrop.wav", false);
		int dropMoney = (int) (Math.random()*15)+13;
		return dropMoney;
	}
	public void setDropMoney(int dropMoney) {
		this.dropMoney = dropMoney;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	
	
	
	
}
