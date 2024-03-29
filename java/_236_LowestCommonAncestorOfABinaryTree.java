/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._236_LowestCommonAncestorOfABinaryTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 二叉树的最近公共祖先
 * @author lilin
 * @date 2020-11-24 15:54
 */
public class _236_LowestCommonAncestorOfABinaryTree {
	/*
	与235题不同的时，这里的树不是二叉搜索树
	
	例如，给定如下二叉树: root =[3,5,1,6,2,0,8,null,null,7,4]

	示例 1:
	
	输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
	输出: 3
	解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
	示例2:
	
	输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
	输出: 5
	解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。

	说明:
	
	所有节点的值都是唯一的。
	p、q 为不同节点且均存在于给定的二叉树中。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	 题解：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/

	 */

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			//即p q在root的两侧
			return root;
		}
		return left == null ? right : left;
	}

	/*
	返回值： 根据 leftleft 和 rightright ，可展开为四种情况；
	1、当 leftleft 和 rightright 同时为空 ：说明 rootroot 的左 / 右子树中都不包含 p,qp,q ，返回 nullnull ；
	2、当 leftleft 和 rightright 同时不为空 ：说明 p, qp,q 分列在 rootroot 的 异侧 （分别在 左 / 右子树），因此 rootroot 为最近公共祖先，返回 rootroot ；
	3、当 leftleft 为空 ，rightright 不为空 ：p,qp,q 都不在 rootroot 的左子树中，直接返回 rightright 。具体可分为两种情况：
		p,qp,q 其中一个在 rootroot 的 右子树 中，此时 rightright 指向 pp（假设为 pp ）；
		p,qp,q 两节点都在 rootroot 的 右子树 中，此时的 rightright 指向 最近公共祖先节点 ；
	4、当 leftleft 不为空 ， rightright 为空 ：与情况 3. 同理；

	 */

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left == null && right == null) {
			return null; // 1.
		}
		if(left == null) {
			return right; // 3.
		}
		if(right == null) {
			return left; // 4.
		}
		return root; // 2. if(left != null and right != null)
	}
}
