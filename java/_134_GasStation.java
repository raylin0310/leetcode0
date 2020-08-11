/**
 * _134_GasStation
 * @author lilin
 * @date 2020-3-17 13:45
 */
public class _134_GasStation {
/*
	There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

	You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).

	You begin the journey with an empty tank at one of the gas stations.

	Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

	在一条环路上有N个加油站，其中第i个加油站有汽油gas[i]升。

	你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。

	如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

	Note:

	If there exists a solution, it is guaranteed to be unique.
	Both input arrays are non-empty and have the same length.
	Each element in the input arrays is a non-negative integer.
	Example 1:

	Input:
	gas  = [1,2,3,4,5]
	cost = [3,4,5,1,2]

	Output: 3

	Explanation:
	Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
	Travel to station 4. Your tank = 4 - 1 + 5 = 8
	Travel to station 0. Your tank = 8 - 2 + 1 = 7
	Travel to station 1. Your tank = 7 - 3 + 2 = 6
	Travel to station 2. Your tank = 6 - 4 + 3 = 5
	Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
	Therefore, return 3 as the starting index.
	Example 2:

	Input:
	gas  = [2,3,4]
	cost = [3,4,3]

	Output: -1

	Explanation:
	You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
	Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
	Travel to station 0. Your tank = 4 - 3 + 2 = 3
	Travel to station 1. Your tank = 3 - 3 + 3 = 3
	You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
	Therefore, you can't travel around the circuit once no matter where you start.

	*/

	/**
	 * 整个路程总的油量 gasSum 小于总的耗油量 costSum，则无论从哪个点触发，都肯定无法绕行一周。
	 * 从i到j的剩余油量如果小于0，则下一个开始的节点就为j+1
	 * 如果i到j剩余油量小于0，那么i+1到j的剩余油量肯定也小于1；
	 * 因为i->j  等于 i->i+1->j，i->i+1肯定大于零才能继续出发到达j，
	 * 如果从i+1出发，则相当于少了i->i+1的剩余油量，则到达j的总剩余油量只会更少
	 */


	public int canCompleteCircuit(int[] gas, int[] cost) {
		int sum = 0;
		int start = 0;
		int total = 0;
		for (int i = 0; i < gas.length; i++) {
			total += (gas[i] - cost[i]);

			if (sum < 0) {
				start = i;
				sum = (gas[i] - cost[i]);
			} else {
				sum += (gas[i] - cost[i]);
			}
		}
		return total < 0 ? -1 : start;
	}

	/**
	 * 暴力破解
	 */

	public int canCompleteCircuit2(int[] gas, int[] cost) {
		int n = gas.length;
		for (int i = 0; i < n; i++) {
			int remain = gas[i];
			int j = i;
			while (remain - cost[j] >= 0) {
				remain = remain - cost[j] + gas[(j + 1) % n];
				j = (j + 1) % n;
				if (j == i) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * 应用了1的优化版本
	 */

	public int canCompleteCircuit3(int[] gas, int[] cost) {
		int n = gas.length;
		for (int i = 0; i < n; i++) {
			int remain = gas[i];
			int j = i;
			while (remain - cost[j] >= 0) {
				remain = remain - cost[j] + gas[(j + 1) % n];
				j = (j + 1) % n;
				if (j == i) {
					return i;
				}
			}
			// j跑到了i前面，所以i后面的都不用判断了
			if (j < i) {
				return -1;
			}
			i = j;
		}
		return -1;
	}

	public static void main(String[] args) {
		_134_GasStation test = new _134_GasStation();
		int[] gas = {1, 2, 3, 4, 5};
		int[] cost = {3, 4, 5, 1, 2};
		System.out.println(test.canCompleteCircuit(gas, cost));

		int[] gas2 = {2, 3, 4};
		int[] cost2 = {3, 4, 3};
		System.out.println(test.canCompleteCircuit(gas2, cost2));

		int[] gas3 = {5, 8, 2, 8};
		int[] cost3 = {6, 5, 6, 6};
		System.out.println(test.canCompleteCircuit(gas3, cost3));
	}
}
