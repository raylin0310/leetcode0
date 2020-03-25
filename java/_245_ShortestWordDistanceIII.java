public class _245_ShortestWordDistanceIII {
/*
	This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same a sword2.

	Given a list of words and two words word1 and word2,
	return the shortest distance between these two words in the list.

	word1 and word2 may be the same and they represent two individual words in the list.

	For example,
	Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

	Given word1 = “makes”, word2 = “coding”, return 1.
	Given word1 = "makes", word2 = "makes", return 3.

	Note:
	You may assume word1 and word2 are both in the list.
*/

	public int shortestDistance(String[] words, String word1, String word2) {
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

	public int shortestDistance2(String[] words, String word1, String word2) {
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

	public static void main(String[] args) {
		_245_ShortestWordDistanceIII test = new _245_ShortestWordDistanceIII();
		String[] words = {"a", "b", "c", "c", "c"};
		String word1 = "c";
		String word2 = "c";
		System.out.println(test.shortestDistance2(words, word1, word2));
	}

}
