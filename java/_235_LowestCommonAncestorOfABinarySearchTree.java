/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._235_LowestCommonAncestorOfABinarySearchTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 二叉搜索树的最近公共祖先
 * @author lilin
 * @date 2020-11-24 15:36
 */
public class _235_LowestCommonAncestorOfABinarySearchTree {
	/*
	给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

	百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
	
	例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
	
	示例 1:
	
	输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
	输出: 6 
	解释: 节点 2 和节点 8 的最近公共祖先是 6。
	示例 2:
	
	输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
	输出: 2
	解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。

	说明:
	
	所有节点的值都是唯一的。
	p、q 为不同节点且均存在于给定的二叉搜索树中。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}

	public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode ancestor = root;
		while (true) {
			if (p.val < ancestor.val && q.val < ancestor.val) {
				ancestor = ancestor.left;
			} else if (p.val > ancestor.val && q.val > ancestor.val) {
				ancestor = ancestor.right;
			} else {
				break;
			}
		}
		return ancestor;
	}


	public static void main(String[] args) {
	}
}
