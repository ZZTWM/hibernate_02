package com.how2java.hibernate.basic.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * 获取：通过id获取一个对象：
 * 	调用Session的get方法，根据id获取对象
 * @author Administrator
 *
 */
public class TestHibernate06_get_by_id {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Product p = (Product)s.get(Product.class, 6);
		System.out.println("id=6的产品名称是：" + p.getName());
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
