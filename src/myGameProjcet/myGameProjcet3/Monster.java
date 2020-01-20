package myGameProjcet;

public abstract class Monster {

	String name = null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDropMoney() {
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
	public String getAttackname() {
		return Attackname;
	}
	public void setAttackname(String attackname) {
		Attackname = attackname;
	}
	public int getAttacknum() {
		return Attacknum;
	}
	public void setAttacknum(int attacknum) {
		Attacknum = attacknum;
	}
	int dropMoney =0;
	int HP;
	String Attackname;
	int Attacknum;

}
