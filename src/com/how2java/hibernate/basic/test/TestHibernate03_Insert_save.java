package com.how2java.hibernate.basic.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * save()
 * 向product_表插入10条数据
 * @author Administrator
 *
 */
public class TestHibernate03_Insert_save {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		for (int i = 0; i < 10; i++) {
			Product p = new Product();
			p.setName("iphone7");
			p.setPrice(i + 7000);
			s.save(p);
		}
		System.out.println("数据插入成功！");
		s.getTransaction().commit();
		s.close();
		sf.close();
		System.out.println("成功关闭连接");
	}
}
