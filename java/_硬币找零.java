public class _硬币找零 {
	/*
	 硬币找零的解决方法有两种，动态规划和贪心算法
	 什么时候用动态规划呢？那就是硬币之间相差一倍，
	 如果硬币分别为1，3，4。需要找零6元，那么按照贪心算法的结果是4+1+1，总共3个硬币，显然不符合要求的
	 如果硬币为1，3，6.就可以采用贪心算法了
	 */

	// 动态规划
	public static void makeChange(int[] coins, int money, int[] coinsUsed) {
		coinsUsed[0] = 0;
		for (int i = 1; i <= money; i++) {
			int min = money;
			//对每一种硬币进行查表
			for (int coin : coins) {
				if (coin <= i) {
					int temp = coinsUsed[i - coin] + 1;
					min = Math.min(min, temp);
				}
			}
			coinsUsed[i] = min;
			System.out.println("面值为 " + (i) + " 的最小硬币数 : " + coinsUsed[i]);
		}
	}

	// 贪心算法
	public static void makeChange2(int[] coins, int money) {
		int min = 0;
		for (int coin : coins) {
			while (money - coin >= 0) {
				min++;
				money = money - coin;
			}
		}
		System.out.println("最少硬币为：" + min);
	}

	//这种更好
	public static void greedyGiveMoney(int[] coins, int money) {
		int min = 0;
		for (int coin : coins) {
			int num = money / coin;
			int mod = money % coin;
			min += num;
			if (mod == 0) {
				break;
			}
			money = mod;
		}
		System.out.println("最少硬币为：" + min);
	}

	public static void main(String[] args) {

		// 硬币面值预先已经按降序排列
		int[] coinValue = new int[]{25, 21, 10, 5, 1};
		// 需要找零的面值
		int money = 63;
		// 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1
		int[] coinsUsed = new int[money + 1];

		//makeChange(coinValue, money, coinsUsed);

		int[] c2 = {10, 5, 1};
		makeChange2(c2, 28);
		greedyGiveMoney(c2, 28);

	}
}
