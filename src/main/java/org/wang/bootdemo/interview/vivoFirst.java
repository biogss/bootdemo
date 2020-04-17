package org.wang.bootdemo.interview;

public class vivoFirst {

	public int solution (int n) throws IllegalAccessException{
		int singleFlag = 10;
		int result = 0;
		int iterator = 1;
		boolean flag = true;
		if (n <= 0) {
			throw new IllegalAccessException("请输入正整数");
		}else if (n < singleFlag) {
			return n;
		}else {
			do {
				flag = true;
				for (int i = 9; i > 1; i--) {
					if (n % i == 0) {
						flag = false;
						result += i * iterator;
						iterator = iterator * 10;
						n = n / i;
						if (n < 10) {
							result += n * iterator;
						}
						break;
					}
				}
				if (flag) {
					n = result = -1;
				}
			}while (n > 10);
		}
		if (result == 0) {
			result = -1;
		}
		return result;
	}

	public static void main(String[] args) {

		try {
			vivoFirst vf = new vivoFirst();
			System.out.println(vf.solution((5 * 6 * 7 * 9 * 9 * 2 * 3)));
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}
}
