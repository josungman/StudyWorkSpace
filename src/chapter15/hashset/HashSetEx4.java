package chapter15.hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class HashSetEx4 {
	private static Random random = new Random();
	public static void main(String[] args) {
		List<Set<Integer>> mylottos = getMylottos();
		
		for (Set<Integer> lotto : mylottos) {
			System.out.println("내꺼:" + lotto);
		}
		
		boolean run = true;
		long cnt = 0;
		while (run) {
			cnt++;
			Set<Integer> computer = getNewLotto();
			for (Set<Integer> lotto : mylottos) {
				boolean won = isSame(lotto, computer);
				if (won) {
					System.out.println("1등당첨");
					System.out.println("방송:" + computer);
					System.out.println(cnt + "회에 당첨");
					System.out.println((cnt/52) + "년 후 당첨");
					run = false;
					break;
				}
			}
		}
	}
	
	private static boolean isSame(Set<Integer> lotto, Set<Integer> computer) {
		for (Integer l : lotto) {
			if (!computer.contains(l)) {
				return false;
			}
		}
		return true;
	}

	private static Set<Integer> getNewLotto() {
		Set<Integer> lotto = new HashSet<>();
		while (lotto.size() < 6) {
			lotto.add(random.nextInt(45) + 1);
		}
		return lotto;
	}

	private static List<Set<Integer>> getMylottos() {
		List<Set<Integer>> mylottos = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			mylottos.add(getNewLotto());
		}
		return mylottos;
	}
}
