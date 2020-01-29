package myGameProjcet;

public class MonsterAction extends Thread {

	static boolean Pagecheck = false;
	static boolean Monsterrun = true;
	static int RealTime = 0;

	@Override
	public void run() { // 쓰레드를 이용한 몬스터의 실시간 공격

		// 몬스터 던전마다 랜덤하게 넣어주기 (입장 던전 확인
		Monster RealTimeMonster = null;
		int randMonster = (int) (Math.random() * 3) + 1;

		if (RPG.disp == "동굴") { // 동굴에 던전 입장시 랜덤으로 몬스터 출현

			switch (randMonster) { // 몬스터 마다 공격 속도 틀리게
			case 1:
				RealTimeMonster = RPG.GameMonster = new Cave_Bat();
				RealTime = (int) (Math.random() * 2800) + 1400;
				break;
			case 2:
				RealTimeMonster = RPG.GameMonster = new Cave_Gummy();
				RealTime = (int) (Math.random() * 2600) + 1400;
				break;
			case 3:
				RealTimeMonster = RPG.GameMonster = new Cave_domabaem();
				RealTime = (int) (Math.random() * 2600) + 1400;
				break;
			}
		} else if (RPG.disp == "정글") { // 정글에 던전 입장시 랜덤으로 몬스터 출현

			switch (randMonster) { // 몬스터 마다 공격 속도 틀리게
			case 1:
				RealTimeMonster = RPG.GameMonster = new Jungle_Anaconda();
				RealTime = (int) (Math.random() * 2900) + 1600;
				break;
			case 2:
				RealTimeMonster = RPG.GameMonster = new Jungle_Crocodiles();
				RealTime = (int) (Math.random() * 2800) + 1400;
				break;
			case 3:
				RealTimeMonster = RPG.GameMonster = new Jungle_Monkey();
				RealTime = (int) (Math.random() * 1500) + 1000;
				break;
			}

		} else if (RPG.disp == "심해") { // 심해 던전 입장시 랜덤으로 몬스터 출현

			switch (randMonster) { // 몬스터 마다 공격 속도 틀리게
			case 1:
				RealTimeMonster = RPG.GameMonster = new DeepSea_Killerwhale();
				RealTime = (int) (Math.random() * 1500) + 1000;
				break;
			case 2:
				RealTimeMonster = RPG.GameMonster = new DeepSea_jellyfish();
				RealTime = (int) (Math.random() * 1200) + 1000;
				break;
			case 3:
				RealTimeMonster = RPG.GameMonster = new DeepSea_Megalodon();
				RealTime = (int) (Math.random() * 2800) + 1400;
				break;
			}

		}

		// 게임몬스터 공격 디버프 (법사 전용 패시브)
		if (RPG.User.getName() == "법사") {
			int rand = (int) (Math.random() * 5) + 1;

			int debuf = RealTimeMonster.getAttacknum() - rand;
			RealTimeMonster.setAttacknum(debuf);
			System.out.println();
			System.out.println("◈법사의 영롱한 기운이 몬스터의 공격력을 낮추었다." + rand + " 공격력 감소");
		}

		MonsterAction.Pagecheck = false;
		while (Monsterrun) {

			try {
				currentThread().sleep(RealTime); // 시간 딜레이주기

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

				if (RPG.warskillcheck == true) { // 전사 스킬 유무
					RealTimeMonster.setAttacknum(RPG.orignAttNum);
					RPG.warskillcheck = false;
				}

				System.out.println("\t● 현제 " + RPG.User.getName() + " HP:" + RPG.User.getHP());
				System.out.print("선택(>>)");

				if (RPG.User.getHP() <= 0) { // User의 HP가 0이면 반복 중지 (유저 죽음)
					RPG.User.setHP(10);
					RPG.Sound("Lose.wav", false);
					System.out.println();
					System.out.println();
					System.out.println("◈싸울힘이 없다. 마을로 강제 귀환 되며 능력치가 감소합니다...");
					System.out.println();

					if (RPG.User.getName() == "전사") {

						int pointminus = RPG.User.getPower();
						pointminus -= 1;
						RPG.User.setPower(pointminus);

					} else if (RPG.User.getName() == "법사") {

						int pointminus = RPG.User.getIntt();
						pointminus -= 1;
						RPG.User.setIntt(pointminus);

					} else if (RPG.User.getName() == "도적") {

						int pointminus = RPG.User.getDex();
						pointminus -= 1;
						RPG.User.setDex(pointminus);

					}

					Monsterrun = false;

				}

				if (RealTimeMonster.getHP() <= 0) { // 몬스터 채력이 0이면 반복 중지 (몬스터 처지)
					System.out.println();
					System.out.println();
					System.out.println("\t◈" + RealTimeMonster.getName() + "를 처치 하였다.");
					System.out.println("\t◈보상으로 : " + RealTimeMonster.getDropMoney() + "Won 얻었다.");
					System.out.println();
					// 유저 보상 획득
					int Money = RPG.User.getMoney();
					Money += RealTimeMonster.getDropMoney();
					RPG.User.setMoney(Money);
					Monsterrun = false;

				}

			} catch (InterruptedException e) {

			}

		}
		// 메인 메서드 이동시 오류로 임시 해결
		if (RPG.dispcheck == true) { // 영웅 도망칠때 아래 출력 true,false로 해결
			RPG.dispcheck = false;
			Monsterrun = false;
		} else {

			System.out.println("  == 던전으로 돌아갑니다! 숫자를 제외한 아무키나 눌러주세요 ==  ");
			Pagecheck = true;
			Monsterrun = false;
		}

		// Pagecheck = true;

	}

}
