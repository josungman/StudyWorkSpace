package myGameProjcet;

import java.util.Scanner;

public class RPG {

	// 캐릭터 클래스 참조변수
	static Hero User = null;
	// 클래스 몬스터
	static Monster GameMonster = null;

	// 계정 (클래스 인스턴스 생성할때 앞에 이미 형식을 지정한상태라 메서드 안에서 클래스 변수를 붙이지 마라.)
	static String ID;
	static String PW;
	static boolean run;
	static Scanner scan = new Scanner(System.in);
	static int orignAttNum; // 몬스터 원래 공격력 (전사 특성에 필요)
	static boolean MirrorCheck = false;// 도적 분신에 필요한 변수
	static int cnt = 0; // 도적 분신 횟수 체크

	public static void main(String[] args) {
		// 게임 실행 page1으로 이동
		run = true;
		page1();

	}

	static void page1() {// 페이지1(첫 시작)

		while (run) {
			System.out.println();
			System.out.println("============= Heros Adventure ==============");
			System.out.println();
			System.out.println("(1).새로시작 || (2).불러오기 || (3).종료하기");
			System.out.println();
			System.out.println("============================================");
			System.out.print("선택(👉)");
			int input = scan.nextInt();
			System.out.println();

			switch (input) {
			case 1:
				// 새로시작시 page2로 넘어가기
				run = false;
				page2();
				break;
			case 2:
				// 새로시작시 page3로 넘어가기
				page3();
				break;
			case 3:

				exitApp(); // 종료하기

			}

		}

	}

	static void page3() {// 페이지3(영웅 불러오기)

		try {
			UserLoad.account();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	static void page2() {// 페이지2(영웅선택 및 회원가입)
		run = true;

		while (run) {

			System.out.println("================= Hero Select ===============");
			System.out.println();
			System.out.println("(1).전사 || (2).법사 || (3).도적 || (4).종료");
			System.out.println();
			System.out.println("=============================================");

			System.out.print("선택(👉)");
			int input2 = scan.nextInt();
			System.out.println();

			// 영웅 객체 (클래스 참조변수로 가져옴)
			if (input2 == 1) {
				User = new Warrior();
			} else if (input2 == 2) {
				User = new Wizard();
			} else if (input2 == 3) {
				User = new thief();
			} else if (input2 == 4) {
				exitApp();
			}

			System.out.println();
			System.out.println("    ======== " + User.getName() + " 영웅이 선택되었습니다. ======== ");
			System.out.println();

			// 파일 읽어오기를 통한 ID 비번 저장
			try {
				UserAdd.account();
			} catch (Exception e) {

				e.printStackTrace();
			}

			run = false;
			break;

		}

	}

	static void GamePage() {// 게임실행페이지
		run = true;
		while (run) {
			System.out.println("====================Heors Town=====================");
			System.out.println();
			System.out.println("(1).정보 || (2).던전 || (3).강화&포션 || (4).기록 || (5).종료");
			System.out.println();
			System.out.println("===================================================");
			System.out.print("선택(👉)");
			int input = scan.nextInt();

			System.out.println();

			switch (input) {
			case 1:
				// 영웅 정보 구현
				System.out.println("============= ● " + ID + "님 Status ● ==========");
				System.out.println(" ● Class : " + User.getName());
				System.out.println();
				System.out.println(" ● H.P : " + User.getHP());
				System.out.println(" ● Pow : " + User.getPower());
				System.out.println(" ● Int : " + User.getIntt());
				System.out.println(" ● Dex : " + User.getDex());
				System.out.println(" ● Money : " + User.getMoney() + "(Won)");

				break;
			case 2:
				// 던전으로 이동 (던전 페이지 구현)
				run = false;
				DungeonPage();
				break;
			case 3:
				run = false;
				shop();
				// 상점 구현
				break;
			case 4:
				// 저장 기능 구현
				try {
					UserSave.account();
				} catch (Exception e) {

					e.printStackTrace();
				}
				break;
			case 5:
				exitApp();
				break;
			}

		}

	}

	static void shop() {// 상점
		run = true;

		while (run) {
			System.out.println("=================Shop===================");
			System.out.println();
			System.out.println("(1).강화석 || (2).마을로가기 || (3).종료");
			System.out.println();
			System.out.println("=========================================");

			System.out.print("선택(👉)");
			int input = scan.nextInt();

			boolean run2 = true;

			while (run2) {
				switch (input) {

				case 1: // 물건사기

					System.out.println(
							"====================================Buy the Stone=====================================");
					System.out.println();
					System.out.println("(1).강화석(힘) || (2).강화석(지능) || (3).강화석(민첩) || (4).물약사기 || (5).뒤로가기");
					System.out.println(
							"======W100==============w100================w100================w10===================");
					System.out.println();
					System.out.println(
							"======================================================================================");

					System.out.print("선택(👉)");
					int input2 = scan.nextInt();

					switch (input2) {
					case 1: // 전사 전용 무기 구현

						if (User.getName() == "전사") {

							// 무기 살돈이 있는지 확인
							if (User.getMoney() >= 100) {
								// 무기 구매시 힘 증가 표시
								int accpower = User.getPower();
								accpower += 10;
								System.out.println();
								System.out.println("◈힘이 +10 증가(▲) 하였습니다.");
								User.setPower(accpower);
								System.out.println("힘 능력치 : " + User.getPower());
								System.out.println();
								// 무기를 샀을때 돈 감소
								int money = User.getMoney();
								money -= 100;
								User.setMoney(money);

								System.out.println("남은 자산은 : " + User.getMoney() + "Won");

							} else {
								System.out.println();
								System.out.println("◈돈이 없습니다...");
								System.out.println();
							}

						} else {
							System.out.println();
							System.out.println("◈전용 능력치가 아닙니다...");
							System.out.println();
						}

						break;
					case 2: // 마법사 전용 무기 구현

						if (User.getName() == "법사") {

							// 무기 살돈이 있는지 확인
							if (User.getMoney() >= 100) {
								// 무기 구매시 힘 증가 표시
								int accpower = User.getIntt();
								accpower += 10;
								System.out.println();
								System.out.println("◈지능이 +10 증가(▲) 하였습니다.");
								User.setIntt(accpower);
								System.out.println("지능 능력치 : " + User.getIntt());
								System.out.println();
								// 무기를 샀을때 돈 감소
								int money = User.getMoney();
								money -= 100;
								User.setMoney(money);

								System.out.println("남은 자산은 : " + User.getMoney() + "Won");

							} else {
								System.out.println();
								System.out.println("◈돈이 없습니다...");
								System.out.println();
							}

						} else {
							System.out.println();
							System.out.println("◈전용 능력치가 아닙니다...");
							System.out.println();
						}

						break;
					case 3: // 도적 전용 무기 구현

						if (User.getName() == "도적") {

							// 무기 살돈이 있는지 확인
							if (User.getMoney() >= 100) {
								// 무기 구매시 힘 증가 표시
								int accpower = User.getDex();
								accpower += 10;
								System.out.println();
								System.out.println("◈민첩이 +10 증가(▲) 하였습니다.");
								User.setDex(accpower);
								System.out.println("민첩 능력치 : " + User.getDex());
								System.out.println();
								// 무기를 샀을때 돈 감소
								int money = User.getMoney();
								money -= 100;
								User.setMoney(money);

								System.out.println("남은 자산은 : " + User.getMoney() + "Won");

							} else {
								System.out.println();
								System.out.println("◈돈이 없습니다...");
								System.out.println();
							}

						} else {
							System.out.println();
							System.out.println("◈전용 능력치가 아닙니다...");
							System.out.println();
						}

						break;
					case 4: // 포션
						if (User.getMoney() >= 10 && User.getHP() < 100) { // 돈
																			// 있는지
																			// 확인
							int Money = User.getMoney();// 돈 차감
							Money -= 10;
							User.setMoney(Money);

							// HP 회복 10씩
							int AddHP = User.getHP();
							AddHP += 10;
							User.setHP(AddHP);

							// 정보 출력
							System.out.println();
							System.out.println("◈10원을 주고 물약을 샀습니다 채력 10 회복 됩니다.");
							System.out.println("\t 남은 자산 : " + User.getMoney());
							System.out.println("\t 현제 채력 : " + User.getHP());
							System.out.println();
						} else {
							System.out.println();
							System.out.println("◈채력이 가득차 있거나 물약을 살 돈이 없습니다...");
							System.out.println();
						}

						break;
					case 5: // 뒤로가기
						shop();
						run2 = false;
						run = false;
						break;
					}

					break;

				case 2:// 마을로가기
					GamePage();
					break;
				case 3:// 종료
					exitApp();
					break;

				}
			}
		}
	}

	static void DungeonPage() {// 던전페이지
		run = true;

		while (run) {
			System.out.println("============================Dungeon===========================");
			System.out.println();
			System.out.println("(1).동굴 || (2).심해 || (3).정글 || (4).마을로가기 || (5).종료");
			System.out.println();
			System.out.println("==============================================================");
			System.out.print("선택(👉)");
			int input = scan.nextInt();

			switch (input) {
			case 1: // 던전 공격 화면 구현
				run = false;
				Attack(1);
				break;

			case 2:// 던전 공격 화면 구현
				run = false;
				Attack(2);
				break;
			case 3:// 던전 공격 화면 구현
				run = false;
				Attack(3);
				break;
			case 4:
				GamePage();
				break;
			case 5:
				exitApp();
			}

		}

	}

	static void Attack(int location) { // 공격 화면
		// 입장 알림

		String disp = null;
		switch (location) {
		case 1:
			disp = "동굴";
			break;
		case 2:
			disp = "심해";

			if (User.getPower() >= 25 || User.getIntt() >= 25 || User.getDex() >= 25) {
				break;
			} else {
				System.out.println();
				System.out.println("◈현제 능력치 부족으로 입장이 불가 합니다. 25부터 가능...");
				System.out.println();
				DungeonPage();
			}

		case 3:
			disp = "정글";
			if (User.getPower() >= 35 || User.getIntt() >= 35 || User.getDex() >= 35) {
				break;
			} else {
				System.out.println("◈현제 능력치 부족으로 입장이 불가 합니다. 35부터 가능...");
				DungeonPage();
			}
		}

		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("===============================================");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("======================" + disp + " 입장=================");
		System.out.println("===============================================");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("===============================================");

		System.out.println();
		System.out.println();
		run = true;

		// 몬스터 구현(던전에 따라 다르게)

//		// 박쥐 몬스터로 Test
//		GameMonster = new Bat();

		

		//몬스터 쓰레드 구현
		MonsterAction  Monsteract = new MonsterAction();
		Monsteract.start();
		
		while (run) {

			Monsteract.interrupt();
			
//			GameMonster.getAttackname();
//
//			// 몬스터 정보 및 공격 출력
//			System.out.println("\t◀ " + GameMonster.getName() + "(가) 공격을 하였다. " + GameMonster.getAttackname() + "("
//					+ GameMonster.getAttacknum() + ")");
//			// System.out.println(User.getName() + "HP: " + User.getHP());
//
//			// 몬스터 가 유저한테 공격 하는 소스 코드
//			int UserHP = User.getHP();
//
//			UserHP -= GameMonster.getAttacknum(); // 몬스터 공격
//			User.setHP(UserHP);
//
//			System.out.println("\t◀ " + User.getName() + "의 HP가 " + "(" + GameMonster.getAttacknum()
//					+ ") 감소 하였다. 현제 HP: " + User.getHP() + "...");
//			System.out.println();

			// HP가 0이면 마을로 돌아가기
			if (User.getHP() <= 0) {
				User.setHP(10); // 최소 HP 주기
				System.out.println();
				System.out.println("◈싸울힘이 없다.😂 마을로 강제 귀환 되며 능력치가 감소합니다...");
				System.out.println();
				// 죽을시 직업 능력치 -1
				if (User.getName() == "전사") {

					int pointminus = User.getPower();
					pointminus -= 1;
					User.setPower(pointminus);

				} else if (User.getName() == "법사") {

					int pointminus = User.getIntt();
					pointminus -= 1;
					User.setIntt(pointminus);

				} else if (User.getName() == "도적") {

					int pointminus = User.getDex();
					pointminus -= 1;
					User.setDex(pointminus);

				}

				run = false;
				GamePage();
			}

			System.out.println();

			System.out.println("=================공격화면===============");
			System.out.println("(1).공격 || (2).특수공격 || (3).도망치기");
			System.out.println("\t● 현제 " + User.getName() + " HP:" + User.getHP());
			System.out.print("선택(👉)");
			int input = scan.nextInt();

			switch (input) {
			case 1: // 공격 구현 (직업별 능력치로 공격)

				User.Attach(); // Attack

				int MonsterHP = GameMonster.getHP();

				
				// 직업 능력치별 몬스터한테 타격 입히기
				if (User.getName() == "전사") {

					MonsterHP -= User.getPower();
					GameMonster.setHP(MonsterHP);
					GameMonster.setAttacknum(orignAttNum); // 몬스터의 원래 공격력

					if (Warrior.warriorand == 1) {// 크리티컬 확률은 전사 클래스에서
						System.out.println("\t ▶" + GameMonster.getName() + "한테 " + User.getPower() * 2 + "의 타격을 입혔다.");
					} else {
						System.out.println("\t ▶" + GameMonster.getName() + "한테 " + User.getPower() + "의 타격을 입혔다.");
					}

				} else if (User.getName() == "법사") {

					MonsterHP -= User.getIntt();
					GameMonster.setHP(MonsterHP);
					System.out.println("\t ▶" + GameMonster.getName() + "한테 " + User.getIntt() + "의 타격을 입혔다.");

				} else if (User.getName() == "도적") {

					// 분신여부 체크
					if (MirrorCheck == true) { // 분신은 총 3번 같이 공격 가능하며 3번이 넘어가면
												// 일반공격
						cnt++; // 분신이랑 있을때
						double MirrAtt = User.getDex() - (User.getDex() * 0.05); // 도적
																					// 분신
																					// 공격력
																					// (유저공격력의
																					// 5%)
						MonsterHP -= User.getDex() + MirrAtt;
						GameMonster.setHP(MonsterHP);
						System.out.println();
						System.out.println("\t ▶" + GameMonster.getName() + "한테 " + User.getDex() + "의 타격을 입혔다.");
						System.out.println("\t ▶▶" + GameMonster.getName() + "한테 " + (int) (User.getDex() * 0.2) // 분신의
																													// 공격력
								+ "의 타격을 분신도(함께)입혔다." + "분신 유지 횟수 : " + (3 - cnt));

						if (cnt == 3) {
							MirrorCheck = false;
							cnt = 0;
							System.out.println();
							System.out.println("◈분신 소멸...");
							System.out.println();
						} // 분신 횟수가 3이면 분신여부 False로

					} else if (MirrorCheck == false) {// 일반공격
						MonsterHP -= User.getDex();
						GameMonster.setHP(MonsterHP);
						System.out.println("\t ▶" + GameMonster.getName() + "한테 " + User.getDex() + "의 타격을 입혔다.");
						MirrorCheck = false;
						cnt = 0;
					}

				}

				System.out.println("\t ▶" + GameMonster.getName() + "채력: " + GameMonster.getHP());

				System.out.println();
				//MonsterAction에 구현
//				if (GameMonster.getHP() <= 0) {
//					System.out.println();
//					System.out.println("◈\t" + GameMonster.getName() + "를 처치 하였다.");
//					System.out.println("◈\t 보상으로 : " + GameMonster.getDropMoney() + "Won 얻었다.");
//
//					// 유저 보상 획득
//					int Money = User.getMoney();
//					Money += GameMonster.getDropMoney();
//					User.setMoney(Money);
//					run = false;
//					DungeonPage();
//				}

				break;
			case 2: // 특수공격
					// 구현================================================================

				if (User.getName() == "전사") {

					if (User.getMoney() <= 8) { // 가진 돈 확인

						// 가진 돈이 빵원이면 스킬을 사용할 수 없다.
						System.out.println();
						System.out.println("◈돈이 부족합니다...");
						GameMonster.setAttacknum(orignAttNum); // 몬스터 공격치 원래 대로
						System.out.println();

					} else {
						// 스킬 사용위해 8원 소비
						int UseMoney = User.getMoney();
						UseMoney -= 8;
						User.setMoney(UseMoney);
						orignAttNum = GameMonster.getAttacknum(); // 원래 공격력 미리
																	// 넣어놓기
						GameMonster.setAttacknum(1); // 몬스터 공격을 1로 바꾸기
						System.out.println();
						System.out.println("◈스킬 발동 조건 : 8(Won)차감, " + "현제 자산: " + User.getMoney() + "(Won)");
						System.out.println("◈특수스킬 발동 : 갑옷두르기(싸우는 몬스터 공격력이 1이 된다.)");
						System.out.println();

					}

				} else if (User.getName() == "도적") {

					if (MirrorCheck == true) { // 특수스킬이 적용되었는지 먼저 체크
						System.out.println();
						System.out.println("◈스킬이 이미 사용중입니다...");
						System.out.println();
						break;
					}

					if (User.getMoney() <= 15) {// 가진 돈 확인
						System.out.println();
						System.out.println("◈돈이 부족합니다...");
						System.out.println();
						break;
					}

					int UseMoney = User.getMoney();// 스킬 사용위해 15원 소비
					UseMoney -= 15;
					User.setMoney(UseMoney);

					int UseHP = (int) (User.getHP() - (User.getHP() * 0.2)); // 20%
																				// HP감소
					User.setHP(UseHP);
					System.out.println();
					System.out.println("◈스킬 발동 조건 : 15(Won)차감, " + "현제 자산: " + User.getMoney() + "(Won)");
					System.out.println("◈특수스킬 발동 : 분신소환(현제체력의 20%를 깍고 유저 공격력의 20%인 분신을 소환한다.)");
					System.out.println();
					MirrorCheck = true;

				} else if (User.getName() == "법사") {

					if (User.getMoney() <= 8) {// 가진 돈 확인
						System.out.println();
						System.out.println("◈돈이 부족합니다...");
						System.out.println();
						break;
					}

					int UseMoney = User.getMoney();// 스킬 사용위해 8원 소비
					UseMoney -= 8;
					User.setMoney(UseMoney);
					int UseHP = 0;
					final int MaxHP = User.getHP(); //최대 HP 고정값
					UseHP = (int) (User.getHP() + MaxHP * 0.13); // 25% 
																			// HP증가
					System.out.println();
					if (UseHP >= 80) {
						System.out.println("◈HP가 최대 입니다...");
						break;
					} else {
						User.setHP(UseHP);
						System.out.println("◈스킬 발동 조건 : 8(Won)차감, " + "현제 자산: " + User.getMoney() + "(Won)");
						System.out.println("◈특수스킬 발동 : 물약소환(현제체력의 25%를 채운다.)" + "HP: " + User.getHP());
						System.out.println();
					}

				}

				break;
			case 3: // 도망갈 확률 4분의1
				int random = (int) (Math.random() * 4) + 1;

				if (User.getName() == "도적") { // 도적은 제외 패시브 스킬 (다크사이트)
					System.out.println();
					System.out.println("◈다크 싸이트!!! : 무조건 도망가기");
					run = false;
					GamePage();
				}

				if (random == 1) {
					System.out.println();
					System.out.println("◈성공적으로 도망쳤다.");
					run = false;
					GamePage();
				} else {
					System.out.println();
					System.out.println("◈도망에 실패 하였다...");
				}

				break;

			}
		}
	}

	private static void exitApp() {
		// 프로그램 종료
		System.out.println();
		System.out.println("=============Shut down App==============");
		System.exit(0);
	}
}
