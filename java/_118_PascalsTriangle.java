import java.util.ArrayList;
import java.util.List;

public class _118_PascalsTriangle {
/*
	Given a non-negative integer numRows, generate the first numRows of triangle's triangle.

	给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

	In triangle's triangle, each number is the sum of the two numbers directly above it.
	Input: 5
	Output:
		[
			     [1],           i:0
			    [1,1],          i:1
			   [1,2,1],         i:2
		      [1,3,3,1],        i:3
			 [1,4,6,4,1]        i:4
			[1,5,10,10,5,1]     i:5
		]
*/

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>();
		if (numRows == 0) {
			return triangle;
		}
		List<Integer> one = new ArrayList<>();
		one.add(1);
		triangle.add(one);

		for (int i = 1; i < numRows; i++) {
			List<Integer> pre = triangle.get(i - 1);
			List<Integer> now = new ArrayList<>();
			now.add(1);
			// 设置中间部分的值
			for (int j = 1; j < i; j++) {
				now.add(pre.get(j - 1) + pre.get(j));
			}
			now.add(1);
			triangle.add(now);
		}
		return triangle;
	}

	/*
	 *  [1,2,1] -> [1,1,2,1]
	 * [1,3,3,1]
	 */

	public List<List<Integer>> generate2(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			list.add(0, 1);
			for (int j = 1; j < list.size() - 1; j++) {
				list.set(j, list.get(j) + list.get(j + 1));
			}
			res.add(new ArrayList<>(list));
		}
		return res;
	}

	public static void main(String[] args) {
		_118_PascalsTriangle test = new _118_PascalsTriangle();
		List<List<Integer>> res = test.generate2(6);
		for (List<Integer> re : res) {
			System.out.println(re.toString());
		}
	}

}
