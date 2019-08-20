package test;

/**
 * 生成随机数测试
 * @author Administrator
 *
 */
public class Test03_get_RandomNumber {
	public static void main(String[] args) {
		int randomNumber = (int) (Math.random()*7000 + 1);
		System.out.println(randomNumber);
	}
}
