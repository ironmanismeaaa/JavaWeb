package vmall.service;

import java.util.Random;

public class VCodeUtill {
	/*
	 * 生成n位随机验证码，包括数字和大小写字�?
	 * @param 验证码长�?
	 * @return n位验证码
	 */
	public static String verifyCode(int n) {
		StringBuilder strB = new StringBuilder();
		Random rand = new Random();
		for(int i = 0; i < n; i++) {
			int r1 = rand.nextInt(3);
			int r2 = 0;
			switch (r1) {  // r2为ascii码�??
			case 0: // 数字
				r2 = rand.nextInt(10) + 48;  // 数字�?48-57的随机数
				break;
			case 1:
				r2 = rand.nextInt(26) + 65;  // 大写字母 
				break;
			case 2:
				r2 = rand.nextInt(26) + 97;  // 小写字母 
				break;
			default:
				break;
			}
			strB.append((char)r2);
		}
		return strB.toString();
	}
}
