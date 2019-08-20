package com.how2java.hibernate.various_concepts;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

/**
 * 这个是一个往product_表增加数据并且有分类字段的值
 * 	增加苹果手机的类型，并且有分类：2代表苹果手机
 * @author Administrator
 *
 */
public class TestHibernateAddProducts {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Set<Product> products = new HashSet<>();
		for (int i = 0; i < 100; i++) {
			Product p = new Product();
			
			p.setName("iphone" + getRandomName());
			p.setPrice(getRandomPrice());
			
			products.add(p);
			s.save(p);
		}
		
		Category c2 = (Category) s.get(Category.class, 2);
		c2.setProducts(products);
		s.save(c2);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}	
	
	/**
	 * 生成iphone的后缀名
	 * @return
	 */
	public static String getRandomName(){
		String[] randomNames = new String[]{"X","XR","SE","XSMAX","6","7","8"};
		String nameSuffix = randomNames[new Random().nextInt(randomNames.length)];
		
		return nameSuffix;
	}
	
	/**
	 * 根据数组内容，自动生成随机值
	 * @return
	 */
	public static int getRandomPrice(){
		int[] randomNumbers = new int[]{3999,4999,5999,6999,7999,8999,9999};
		int randomPrice = randomNumbers[new Random().nextInt(randomNumbers.length)];
		return randomPrice;
	}
}
