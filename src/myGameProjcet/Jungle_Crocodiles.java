package myGameProjcet;

public class Jungle_Crocodiles extends Monster {

	private String name = "정글악어";
	private int dropMoney;
	private int HP=120;
	private String Attackname = "으깨버리기";
	private int Attacknum = 33;
	
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
		int dropMoney = (int) (Math.random()*15)+8;
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
