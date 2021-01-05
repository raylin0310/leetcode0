/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._150_EvaluateReversePolishNotation
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Stack;

/**
 * 逆波兰表达式求值
 * @author lilin
 * @date 2021-1-5 17:01
 */
public class _150_EvaluateReversePolishNotation {
	/*
	根据 逆波兰表示法，求表达式的值。

	有效的运算符包括+,-,*,/ 每个运算对象可以是整数，也可以是另一个逆波兰表达式。

	说明：
	
	整数除法只保留整数部分。
	给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

	示例1：
	
	输入: ["2", "1", "+", "3", "*"]
	输出: 9
	解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
	示例2：
	
	输入: ["4", "13", "5", "/", "+"]
	输出: 6
	解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
	示例3：
	
	输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
	输出: 22
	解释: 
	该算式转化为常见的中缀算术表达式为：
	  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
	= ((10 * (6 / (12 * -11))) + 17) + 5
	= ((10 * (6 / -132)) + 17) + 5
	= ((10 * 0) + 17) + 5
	= (0 + 17) + 5
	= 17 + 5
	= 22

	逆波兰表达式：
	
	逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
	
	平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
	该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
	逆波兰表达式主要有以下两个优点：
	
	去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
	适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String s : tokens) {
			if (s.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (s.equals("-")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a - b);
			} else if (s.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (s.equals("/")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a / b);
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String[] arr = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(evalRPN(arr));
	}
}
