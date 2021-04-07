public class _啤酒兑换 {

	 public static int maxBox2(int beerNum) {
		int allBox = beerNum;
		int allGai = beerNum;
		int allbear = beerNum;
		while (allBox >= 2 || allGai >= 4) {
			int x = allBox / 2; // 可以兑换到的新酒
			int x1 = allBox % 2; //剩余的空瓶子
			int y = allGai / 4; // 可以兑换到的新酒
			int y1 = allGai % 4; //剩余的盖子
			allBox = x + x1 + y;
			allGai = x + y + y1;
			allbear += x + y;
		}
		return allbear;
	}

	public static void main(String[] args) {
		System.out.println(maxBox2(10));
	}
}
