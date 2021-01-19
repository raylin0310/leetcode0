public class _245_ShortestWordDistanceIII {
/*
	跟243题不同的是：word1和word2可能会相同

	For example,
	Assume that words =["practice", "makes", "perfect", "coding", "makes"].

	Givenword1=“makes”,word2=“coding”, return 1.
	Givenword1="makes",word2="makes", return 3.

	Note:
	You may assumeword1andword2are both in the list.
*/

	public static int shortestDistance(String[] words, String word1, String word2) {
		int distance = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				for (int j = 0; j < words.length; j++) {
					if (words[j].equals(word2) && i != j) {
						distance = Math.min(distance, Math.abs(i - j));
					}
				}
			}
		}
		return distance;
	}

	public static int shortestDistance2(String[] words, String word1, String word2) {
		int distance = Integer.MAX_VALUE;
		int a = -1;
		int b = -1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				a = i;
			}
			// 相当于先把上一次匹配到的位置赋值给a
			if (words[i].equals(word2)) {
				if (word1.equals(word2)) {
					a = b;
				}
				b = i;
			}
			if (a != -1 && b != -1) {
				distance = Math.min(distance, Math.abs(b - a));
			}
		}
		return distance;
	}

	//这种容易理解
	public static int shortestDistance3(String[] words, String word1, String word2) {
		int distance = Integer.MAX_VALUE;
		int a = -1;
		int b = -1;
		for (int i = 0; i < words.length; i++) {
			int temp = a;
			if (words[i].equals(word1)) {
				a = i;
			}
			if (words[i].equals(word2)) {
				b = i;
			}
			if (a != -1 && b != -1) {
				//为什么要temp != a：在[a,b,c]  w1=w1=b中，当i=2时，不会进入上面的两个判断，此时temp=a=b=1，这时候不应该进行计算距离
				if (word1.equals(word2) && temp != -1 && temp != a) {
					distance = Math.min(distance, Math.abs(temp - a));
				} else if (a != b) {
					distance = Math.min(distance, Math.abs(b - a));
				}
			}
		}
		return distance;
	}

	public static void main(String[] args) {
		String[] words = {"a", "b", "c", "c", "c"};
		String word1 = "c";
		String word2 = "c";
		System.out.println(shortestDistance2(words, word1, word2));
		System.out.println(shortestDistance3(words, word1, word2));
	}

}
