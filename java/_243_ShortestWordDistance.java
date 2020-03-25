
public class _243_ShortestWordDistance {
	/*
		given a list of words and two words word1 and word2,
		return the shortest distance between these two words in the list.

		For example,
		Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

		Given word1 = “coding”, word2 = “practice”, return 3.
		Given word1 = "makes", word2 = "coding", return 1.
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
