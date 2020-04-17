package org.wang.bootdemo.mapDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		Map<String, Integer > result = new HashMap<>(1000);
		for (int i = 0; i < 1000; i++) {
			result.put(String.valueOf(i), (int) (Math.random() * 100) + i);
		}
		StringBuilder sb = new StringBuilder();
		long startTime =System.currentTimeMillis();
		Set<Map.Entry<String, Integer>> entrySet = result.entrySet();
		for (Map.Entry<String, Integer> entry : entrySet) {
			sb.append(entry.getKey()).append(",").append(entry.getValue()).append("|");
		}
		long endTime =System.currentTimeMillis();
		System.out.println(sb.toString());
		System.out.println("entry耗时：" + (endTime - startTime));

		sb.delete(0, sb.length());
		long keySetStartTime  = System.currentTimeMillis();
		Set<String> keySet = result.keySet();
		for (String keyStr : keySet) {
			sb.append(keyStr).append(",").append(result.get(keyStr)).append("|");
		}
		long keySetEndTime  = System.currentTimeMillis();
		System.out.println(sb.toString());
		System.out.println("keySet耗时：" + (keySetEndTime - startTime));

	}
}
