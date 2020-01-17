package chapter15.hashset;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HashSetEx3 {
	public static void main(String[] args) {
		Set<Integer> mylotto = new HashSet<>();
		Set<Integer> computer = new HashSet<>();
		Random random = new Random();

		while (mylotto.size() < 6) {
			mylotto.add(random.nextInt(45) + 1);
		}

		System.out.println("내꺼:" + mylotto);

		long count = 0;
		while (true) {
			count++;
			while (computer.size() < 6) {
				computer.add(random.nextInt(45) + 1);
			}

//			System.out.println("방송:" + computer);

			boolean won = true;

			for (Integer c : computer) {
//			System.out.println(c);
//			System.out.println(mylotto.contains(c));
				if (!mylotto.contains(c)) {
					won = false;
					break;
				}
			}

			if (won) {
				System.out.println("방송:" + computer);
				System.out.println("1등입니다.");
				System.out.println(count + "회에 당첨");
				System.out.println((count/52) + "년 후 당첨");
				break;
			} else {
//				System.out.println("1등이 아닙니다.");
				computer.clear();
			}

		}
	}
}
