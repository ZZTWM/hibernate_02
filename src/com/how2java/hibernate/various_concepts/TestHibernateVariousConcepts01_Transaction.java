package com.how2java.hibernate.various_concepts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * 事务：
 * 	Hibernate的任何对数据有改动的操作，都应该被放在事务里面 
 * 	在事务中的多个操作行为，要么都成功，要么都失败
 * @author Administrator
 *
 */
public class TestHibernateVariousConcepts01_Transaction {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Product p1 = (Product) s.get(Product.class, 1);
		s.delete(p1);
		
		Product p2 = (Product) s.get(Product.class, 2);
		p2.setName("长度超过30的字符串作为产品");
		s.update(p2);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
}	
