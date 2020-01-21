package myGameProjcet;

public class MonsterAction extends Thread {

	@Override
	public void run() { // 쓰레드를 이용한 몬스터의 실시간 공격
		boolean run = true;

		// 박쥐 몬스터로 Test
		Monster RealTimeMonster = RPG.GameMonster = new Bat();

		// 게임몬스터 공격 디버프 (법사 전용 패시브)
		if (RPG.User.getName() == "법사") {
			int rand = (int) (Math.random() * 5) + 1;

			int debuf = RealTimeMonster.getAttacknum() - rand;
			RealTimeMonster.setAttacknum(debuf);
			System.out.println();
			System.out.println("◈법사의 영롱한 기운이 몬스터의 공격력을 낮추었다." + rand + "디버프");
		}

		while (run) {

			try {
				currentThread().sleep(3000); // 3초마다 한번씩 반복

				RealTimeMonster.getAttackname();

				System.out.println();
				// 몬스터 정보 및 공격 출력

				System.out.println("\t◀ " + RealTimeMonster.getName() + "(가) 공격을 하였다. "
						+ RealTimeMonster.getAttackname() + "(" + RealTimeMonster.getAttacknum() + ")");
				// System.out.println(User.getName() + "HP: " + User.getHP());

				// 몬스터 가 유저한테 공격 하는 소스 코드
				int UserHP = RPG.User.getHP();

				UserHP -= RealTimeMonster.getAttacknum(); // 몬스터 공격
				RPG.User.setHP(UserHP);

				System.out.println("\t◀ " + RPG.User.getName() + "의 HP가 " + "(" + RealTimeMonster.getAttacknum()
						+ ") 감소 하였다. 현제 HP: " + RPG.User.getHP() + "...");
				System.out.println();

				System.out.println("\t● 현제 " + RPG.User.getName() + " HP:" + RPG.User.getHP());
				System.out.print("선택(👉)");

				if (RPG.User.getHP() <= 0) { // User의 HP가 0이면 반복 중지 (유저 죽음)
					run = false;

				}

				if (RealTimeMonster.getHP() <= 0) { // 몬스터 채력이 0이면 반복 중지 (몬스터 처지)
					System.out.println();
					System.out.println("◈\t" + RealTimeMonster.getName() + "를 처치 하였다.");
					System.out.println("◈\t 보상으로 : " + RealTimeMonster.getDropMoney() + "Won 얻었다.");

					// 유저 보상 획득
					int Money = RPG.User.getMoney();
					Money += RealTimeMonster.getDropMoney();
					RPG.User.setMoney(Money);
					run = false;

				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				// 주의!!!! 오류무시!!!!
				// e.printStackTrace();
			}

		}
		RPG.DungeonPage(); // 던전페이지로 이동
	}

}
