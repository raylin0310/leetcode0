
/**
 * 找名人
 * @author lilin
 * @date 2020-3-5 15:46
 */
public class _277_FindtheCelebrity {
/*
	这道题让我们在一群人中寻找名人，所谓名人就是每个人都认识他，他却不认识任何人，限定了只有1个或0个名人，
	给定了一个 API 函数，输入a和b，用来判断a是否认识b，让我们尽可能少的调用这个函数，来找出人群中的名人。
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
		_277_FindtheCelebrity test = new _277_FindtheCelebrity();
		System.out.println(test.findCelebrity(60));
	}
}
