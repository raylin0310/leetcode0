/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._278_FirstBadVersion
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 第一个错误的版本
 * @author lilin
 * @date 2020-9-4 15:15
 */
public class _278_FirstBadVersion {
	/*
	你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
	
	假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
	
	你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
	
	示例:
	
	给定 n = 5，并且 version = 4 是第一个错误的版本。
	
	调用 isBadVersion(3) -> false
	调用 isBadVersion(5)-> true
	调用 isBadVersion(4)-> true
	
	所以，4 是第一个错误的版本。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/first-bad-version
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int firstBadVersion(int n) {
		int start = 1;
		int end = n;
		while (start < end) {
			int mid = (end - start) / 2 + start;
			//int mid = (end + start) >>> 1 ; jdk中取中位数的
			if (isBadVersion(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	public static boolean isBadVersion(int mid) {
		return mid==10;
	}

	public static void main(String[] args) {
		System.out.println(firstBadVersion(10));
	}
}
