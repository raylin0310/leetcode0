import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 加油站
 *
 * @author lilin
 * @date 2020-3-17 13:45
 */
public class _134_GasStation {
/*
	在一条环路上有N个加油站，其中第i个加油站有汽油gas[i]升。
	
	你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
	
	如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
	
	说明:
	
	如果题目有解，该答案即为唯一答案。
	输入数组均为非空数组，且长度相同。
	输入数组中的元素均为非负数。
	示例1:
	
	输入: 
	gas  = [1,2,3,4,5]
	cost = [3,4,5,1,2]
	
	输出: 3
	
	解释:
	从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
	开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
	开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
	开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
	开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
	开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
	因此，3 可为起始索引。
	示例 2:
	
	输入: 
	gas  = [2,3,4]
	cost = [3,4,3]
	
	输出: -1
	
	解释:
	你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
	我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
	开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
	开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
	你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
	因此，无论怎样，你都不可能绕环路行驶一周。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/gas-station
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	*/

	/*
	 * 整个路程总的油量 gasSum 小于总的耗油量 costSum，则无论从哪个点触发，都肯定无法绕行一周。
	 * 从i到j的剩余油量如果小于0，则下一个开始的节点就为j+1
	 * 如果i到j剩余油量小于0，那么i+1到j的剩余油量肯定也小于0；
	 * 因为i->j  等于 i->i+1->j，i->i+1肯定大于零才能继续出发到达j，
	 * 如果从i+1出发，则相当于少了i->i+1的剩余油量，则到达j的总剩余油量只会更少
	 * https://leetcode.cn/problems/gas-station/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--30/
	 */

	/*
	该算法基于一个事实：如果i能走到最远的距离是j，那么从i+1最远的距离也不回超过j，因为如果i能达到i+1，
	那么到达i+1时的油量H肯定是>=0的，如果从i+1出发的话，那么就会少了H的油量
	 */

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int sum = 0;
		int start = 0;
		int total = 0;
		for (int i = 0; i < gas.length; i++) {
			total += (gas[i] - cost[i]);
			sum += (gas[i] - cost[i]);
			if (sum < 0) {
				start = i + 1;
				sum = 0;
			}
		}
		return total < 0 ? -1 : start;
	}

	/*
	 * 应用了1的优化版本
	 */

	public static int canCompleteCircuit3(int[] gas, int[] cost) {
		int n = gas.length;
		for (int i = 0; i < n; i++) {
			int remain = gas[i];
			int j = i;
			while (remain - cost[j] >= 0) {
				//减去花费的加上新的点的补给
				remain = remain - cost[j] + gas[(j + 1) % n];
				j = (j + 1) % n;
				//j 回到了 i
				if (j == i) {
					return i;
				}
			}
			// j跑到了i前面，所以i后面的都不用判断了
			// 原理就是 假如i=5,j=2就没法继续走了，那从3开始，最多也就走到5，因为出发点一定是上一次能到达的最远的距离
			if (j < i) {
				return -1;
			}
			i = j;
		}
		return -1;
	}

	// 同上
	public static int canCompleteCircuit4(int[] gas, int[] cost) {
		int n = gas.length;
		for (int i = 0; i < n; i++) {
			int j = i;
			int remain = gas[i];
			while (remain - cost[j] >= 0) {
				//减去花费的加上新的点的补给
				remain = remain - cost[j] + gas[(j + 1) % n];
				j = (j + 1) % n;
				//j 回到了 i
				if (j == i) {
					return i;
				}
			}
			//最远距离绕到了之前，所以 i 后边的都不可能绕一圈了
			if (j < i) {
				return -1;
			}
			//i 直接跳到 j，外层 for 循环执行 i++，相当于从 j + 1 开始考虑
			i = j;

		}
		return -1;
	}

	public static void main(String[] args) {
		int[] gas = {1, 2, 3, 4, 5};
		int[] cost = {3, 4, 5, 1, 2};
		System.out.println(canCompleteCircuit3(gas, cost));
	}
}
