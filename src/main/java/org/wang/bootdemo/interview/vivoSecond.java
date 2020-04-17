package org.wang.bootdemo.interview;

public class vivoSecond {

	public int solution (int n) {
		int sum = 0;
		int result = 0;
		int i = 1;
		for (; sum < n; i ++) {
			sum += i;
			result += i * i;
		}
		result -= (sum - n) * i;

		return result;
	}

	public static void main(String[] args) {
		vivoSecond vs = new vivoSecond();
		System.out.println(vs.solution(10));
	}
}
