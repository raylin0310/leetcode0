/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._146_LRUCache
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * _146_LRUCache
 * @author lilin
 * @date 2021-1-7 14:08
 */
public class _146_LRUCache {
	/*
	运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
	实现 LRUCache 类：
	
	LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
	int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
	void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
	当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
	
	
	进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/lru-cache
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
		 */

	static class LRUCache {

		Map<Integer, Integer> map;
		Deque<Integer> deque;
		int capacity;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			this.map = new HashMap<>();
			this.deque = new LinkedList<>();
		}

		public int get(int key) {
			Integer val = map.get(key);
			if (val == null) {
				return -1;
			}
			// 因为这里存的是值，并不是链表里面的node，所以这里删除的时间复杂度是O(n)
			// 要想达到O(1)，map就要存链表的node才行，这样子只有自己写链表了，参考LRUCache2
			deque.remove(key);
			deque.addFirst(key);
			return val;
		}

		public void put(int key, int value) {
			if (map.containsKey(key)) {
				// 更新
				map.put(key, value);
				deque.remove(key);
				deque.addFirst(key);
				return;
			}
			// 新增
			if (map.size() == capacity) {
				Integer last = deque.removeLast();
				map.remove(last);
			}
			map.put(key, value);
			deque.addFirst(key);
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.get(2);
		cache.put(2, 6);
		cache.get(1);
		cache.put(1, 5);
		cache.put(1, 2);
		cache.get(1);
		cache.get(2);
	}

	class LRUCache2 {
		LinkedNodeList list;
		Map<Integer, Node> map;
		int cap;
		public LRUCache2(int capacity) {
			list = new LinkedNodeList();
			map = new HashMap(capacity);
			cap = capacity;
		}

		public int get(int key) {
			Node node = map.get(key);
			if(node == null){
				return -1;
			}
			list.moveToHead(node);
			return node.val;
		}

		public void put(int key, int value) {
			Node node = map.get(key);
			if(node != null){
				list.moveToHead(node);
				node.val = value;

			}else{
				Node newNode = new Node(key, value);
				if(map.size() == cap){
					Node tail = list.getTail();
					map.remove(tail.key);
					list.removeTail();
				}
				map.put(key, newNode);
				list.addToHead(newNode);
			}
		}
	}

	class LinkedNodeList{
		Node dummyHead;
		Node dummyTail;

		LinkedNodeList(){
			dummyHead = new Node(0,0);
			dummyTail = new Node(0,0);
			dummyHead.next = dummyTail;
			dummyTail.prev = dummyHead;
		}

		void moveToHead(Node node){
			node.prev.next = node.next;
			node.next.prev = node.prev;
			addToHead(node);
		}

		void addToHead(Node node){
			Node tmp = dummyHead.next ;
			dummyHead.next = node;
			node.next = tmp;
			node.prev = dummyHead;
			tmp.prev = node;
		}

		void removeTail(){
			Node newTail = dummyTail.prev.prev;
			newTail.next = dummyTail;
			dummyTail.prev = newTail;
		}

		Node getTail(){
			return dummyTail.prev;
		}

	}

	class Node{
		int key;
		int val;
		Node next;
		Node prev;
		Node(int key, int value){
			this.key = key;
			this.val =value;
		}
	}


}
