/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._297_SerializeAndDeserializeBinaryTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *  二叉树的序列化与反序列化
 * @author lilin
 * @date 2020-11-27 14:52
 */
public class _297_SerializeAndDeserializeBinaryTree {
	/*
	序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

	请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
	
	示例:
	
	你可以将以下二叉树：
	
	    1
	   / \
	  2   3
	     / \
	    4   5
	
	序列化为 "[1,2,3,null,null,4,5]"
	提示:这与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
	
	说明:不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	树的序列化
	官方题解更丰富：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/er-cha-shu-de-xu-lie-hua-yu-fan-xu-lie-hua-by-le-2/

	下面用到了层序遍历
	 */

	public static String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder res = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				res.append("null,");
				continue;
			}
			res.append(cur.val + ",");
			queue.offer(cur.left);
			queue.offer(cur.right);
		}
		return res.toString();
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		if (data == "") {
			return null;
		}
		String[] str = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(str[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		for (int i = 1; i < str.length; i++) {
			TreeNode cur = queue.poll();
			if (!"null".equals(str[i])) {
				cur.left = new TreeNode(Integer.parseInt(str[i]));
				queue.offer(cur.left);
			}
			i++;
			if (!"null".equals(str[i])) {
				cur.right = new TreeNode(Integer.parseInt(str[i]));
				queue.offer(cur.right);
			}
		}
		return root;
	}


	public static void main(String[] args) {
		String se = serialize(TreeNode.stringToTreeNode("[1,2,3,null,null,4,5]"));
		System.out.println(se);
		System.out.println(deserialize(se));
	}
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));