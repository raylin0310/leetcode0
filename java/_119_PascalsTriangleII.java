import java.util.ArrayList;
import java.util.List;

public class _119_PascalsTriangleII {
	/*
		Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

		给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

		Example:

		Input: 3
		Output: [1,3,3,1]
		Follow up:

		Could you optimize your algorithm to use only O(k) extra space?

		[
			     [1],           i:0
			    [1,1],          i:1
			   [1,2,1],         i:2
		      [1,3,3,1],        i:3
			 [1,4,6,4,1]        i:4
			[1,5,10,10,5,1]     i:5
		]
	*/

	/*
	 *  [1,2,1] -> [1,1,2,1]
	 * [1,3,3,1] -> [1,1,3,3,1]
	 * [1,4,6,4,1]
	 *
	 * 动态规划
	 */

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> triangle = new ArrayList<>();
		for (int i = 0; i <= rowIndex; i++) {
			triangle.add(0, 1);
			for (int j = 1; j < i; j++) {
				triangle.set(j, triangle.get(j) + triangle.get(j + 1));
			}
		}
		return triangle;
	}

	public static void main(String[] args) {
		System.out.println(getRow(2));
	}
}
