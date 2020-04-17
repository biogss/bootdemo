package org.wang.bootdemo.interview;

public class vivoFirstImprove {

	public int solution(int n) throws IllegalAccessException{
		int result = 0;
		int iterator = 1;
		if (n <= 0) {
			throw  new IllegalAccessException("需要输入正整数");
		}else if (n < 10) {
			return  10 + n;
		}else {
			for (int i = 9; i > 1; i-- ) {
				while (n % i == 0) {
					result += i * iterator;
					iterator *= 10;
					n /= i;
				}
			}
			if (n > 1) {
				return  -1;
			}else {
				return result;
			}
		}
	}

	public static void main(String[] args) {
		vivoFirstImprove vfi = new vivoFirstImprove();
		try {
			System.out.println(vfi.solution(42));
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
