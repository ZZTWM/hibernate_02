package test;

import java.util.Random;

/**
 * 测试如何从一个字符串数组里随机取值
 * @author Administrator
 *
 */
public class Test01_get_RadomString_Through_Array {
	public static void main(String[] args) {
		String[] randomNames = new String[]{"X","XR","SE","XSMAX","6","7","8"};
		String nameSuffix = randomNames[new Random().nextInt(randomNames.length)];
		
		System.out.println(nameSuffix);
		
		System.out.println((int)Math.random()*7000);
	}
}
