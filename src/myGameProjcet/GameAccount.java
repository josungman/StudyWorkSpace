package myGameProjcet;

public class GameAccount {

	private String ID;
	private String PW;
	
	
	public GameAccount(String ID,String PW) {
		this.ID = ID;
		this.PW = PW;
	}
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	
	
	
}
