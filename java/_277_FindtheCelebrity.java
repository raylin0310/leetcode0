
/**
 * _277_FindtheCelebrity
 * @author lilin
 * @date 2020-3-5 15:46
 */
public class _277_FindtheCelebrity {
/*
	Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
	The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
	You are given a helper function bool knows(a, b) which tells you whether A knows B.
	Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
    0 1 2 3 4 5

	celebrity = 3
*/

	public int findCelebrity(int n) {
		if (n < 2) {
			return -1;
		}
		//假设有一个明星，可通过‘擂台’方式筛选出
		int celebrity = 0;
		for (int i = 1; i < n; i++) {
			/*  A、B两人
			    假如A认识B，A肯定不是明星
			    假如A不认识B，B肯定不是明星
			 */
			if (knows(celebrity, i)) {
				celebrity = i;
			}
		}
		// 可能一个明星都没有，校验
		for (int i = 0; i < n; i++) {
			if (celebrity != i && ((knows(celebrity, i) || !knows(i, celebrity)))) {
				return -1;
			}
		}
		return celebrity;
	}

	public static final int CELEBRITY = 20;

	public boolean knows(int a, int b) {
		// 设CELEBRITY为明星
		return b == CELEBRITY;
	}

	public static void main(String[] args) {
		System.out.println(new _277_FindtheCelebrity().findCelebrity(60));
	}
}
