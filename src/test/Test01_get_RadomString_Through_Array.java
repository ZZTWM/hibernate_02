package test;

import java.util.Random;

/**
 * ������δ�һ���ַ������������ȡֵ
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
