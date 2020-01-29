package myGameProjcet;

public class Cave_Bat extends Monster {

	private String name = "박쥐";
	private int dropMoney;
	private int HP=50;
	private String Attackname = "날개치기";
	private int Attacknum = 10;
	
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
	public int getDropMoney() {//1원에서 5원 사이 머니 드롭
		
		RPG.Sound("MoneyDrop.wav", false);
		int dropMoney = (int) (Math.random()*5)+1;
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
