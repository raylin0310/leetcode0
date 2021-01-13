
public class _243_ShortestWordDistance {
	/*
		这道题给了我们一个单词数组，又给定了两个单词，让求这两个单词之间的最小距离，限定了两个单词不同，而且都在数组中

		For example,
		Assume that words =["practice", "makes", "perfect", "coding", "makes"].

		Givenword1=“coding”,word2=“practice”, return 3.
		Givenword1="makes",word2="coding", return 1.
	*/
	/*
	暴力解法 O(n^2)
	 */

	public int shortestDistance(String[] words, String word1, String word2) {
		int distance = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				for (int j = 0; j < words.length; j++) {
					if (words[j].equals(word2)) {
						distance = Math.min(distance, Math.abs(i - j));
					}
				}
			}
		}
		return distance;
	}

	/*
	 原理是题目求最小距离，那么随着index右移，前面出现的单词肯定越来越远，后面出现相同的直接覆盖，肯定比前面出现的近
	 */

	public int shortestDistance1(String[] words, String word1, String word2) {
		int distance = Integer.MAX_VALUE;
		int a = -1;
		int b = -1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				a = i;
			}
			if (words[i].equals(word2)) {
				b = i;
			}
			if (a != -1 && b != -1) {
				distance = Math.min(distance, Math.abs(b - a));
			}
		}
		return distance;
	}

	public static void main(String[] args) {
		_243_ShortestWordDistance test = new _243_ShortestWordDistance();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "makes";
		String word2 = "coding";
		String word3 = "coding";
		String word4 = "practice";
		System.out.println(test.shortestDistance1(words, word1, word2));
		System.out.println(test.shortestDistance1(words, word3, word4));
	}
}
