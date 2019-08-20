package com.how2java.hibernate.various_concepts;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Category;

/**
 * 一级缓存
 * 	hibernate默认是开启一级缓存的，一级缓存存放在session上
 * @author Administrator
 *
 */
public class TestHibernateVariousConcepts08_First_Cache {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		System.out.println("log1");
		Category c1 = (Category) s.get(Category.class, 1);
		System.out.println("log2");
		Category c2 = (Category) s.get(Category.class, 1);
		System.out.println("log3");
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}	
