import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _244_ShortestWordDistanceII {
/*
	Design a class which receives a list of words in the constructor,
	and implements a method that takes two wordsword1andword2and
	return the shortest distance between these two words in the list.
	Your method will be calledrepeatedlymany times with different parameters.

	请设计一个类，使该类的构造函数能够接收一个单词列表。
	然后再实现一个方法，该方法能够分别接收两个单词 word1 和 word2，并返回列表中这两个单词之间的最短距离。
	您的方法将被以不同的参数调用多次。

	Example:
	Assume that words =["practice", "makes", "perfect", "coding", "makes"].

	Input: word1 = “coding”, word2 = “practice”

	Output: 3

	Input: word1 = "makes", word2 = "coding"

	Output: 1

	Note: You may assume thatword1does not equal toword2, andword1andword2are both in the list.
	*/

	Map<String, List<Integer>> map = new HashMap<>();

	public _244_ShortestWordDistanceII(String[] words) {
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			List<Integer> index = map.computeIfAbsent(word, k -> new ArrayList<>());
			index.add(i);
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> index1 = map.get(word1);
		List<Integer> index2 = map.get(word2);
		int distance = Integer.MAX_VALUE;
		for (Integer i : index1) {
			for (Integer j : index2) {
				distance = Math.min(distance, Math.abs(j - i));
			}
		}
		return distance;
	}

	public int shortest2(String word1, String word2) {
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		int distance = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		// 类似与归并？
		while (i < list1.size() && j < list2.size()) {
			Integer index1 = list1.get(i);
			Integer index2 = list2.get(j);
			distance = Math.min(distance, Math.abs(index1 - index2));
			if (index1 < index2) {
				i++;
			} else {
				j++;
			}
		}
		return distance;

	}

	public static void main(String[] args) {
		String[] words = {"a", "b", "c", "d", "a"};
		_244_ShortestWordDistanceII test = new _244_ShortestWordDistanceII(words);
		String word1 = "b";
		String word2 = "d";
		System.out.println(test.shortest2(word1, word2));
	}
}
