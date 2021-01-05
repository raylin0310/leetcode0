/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._127_WordLadder
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * _127_WordLadder
 * @author lilin
 * @date 2021-1-5 10:13
 */
public class _127_WordLadder {
	//不懂

	Map<String, Integer> wordId = new HashMap<>();
	List<List<Integer>> edge = new ArrayList<>();
	int nodeNum = 0;

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		for (String word : wordList) {
			addEdge(word);
		}
		addEdge(beginWord);
		if (!wordId.containsKey(endWord)) {
			return 0;
		}
		int[] dis = new int[nodeNum];
		Arrays.fill(dis, Integer.MAX_VALUE);
		int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
		dis[beginId] = 0;

		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(beginId);
		while (!que.isEmpty()) {
			int x = que.poll();
			if (x == endId) {
				return dis[endId] / 2 + 1;
			}
			for (int it : edge.get(x)) {
				if (dis[it] == Integer.MAX_VALUE) {
					dis[it] = dis[x] + 1;
					que.offer(it);
				}
			}
		}
		return 0;
	}

	public void addEdge(String word) {
		addWord(word);
		int id1 = wordId.get(word);
		char[] array = word.toCharArray();
		int length = array.length;
		for (int i = 0; i < length; ++i) {
			char tmp = array[i];
			array[i] = '*';
			String newWord = new String(array);
			addWord(newWord);
			int id2 = wordId.get(newWord);
			edge.get(id1).add(id2);
			edge.get(id2).add(id1);
			array[i] = tmp;
		}
	}

	public void addWord(String word) {
		if (!wordId.containsKey(word)) {
			wordId.put(word, nodeNum++);
			edge.add(new ArrayList<Integer>());
		}
	}

	public static void main(String[] args) {
		_127_WordLadder test = new _127_WordLadder();
		ArrayList<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(test.ladderLength("hit", "cog", wordList));
	}
}
