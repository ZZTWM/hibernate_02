package com.how2java.hibernate.various_concepts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
/**
 * 二级缓存
 * 	Hibernate的一级缓存是在Session上，二级缓存是在SessionFactory上
 * @author Administrator
 *
 */
public class TestHibernateVariousConcepts09_Second_Cache {
	public static void main(String[] args) {
		/**
		 * 	使用不同的session,都去获取id=1的category,只会访问一次数据库。
		 * 	因为第二次获取虽然没有从第二个session中拿到缓存，但是从sessionfactory中拿到了Category缓存对象
		 */
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//第一个Session
		Session s1 = sf.openSession();
		s1.beginTransaction();
		
        Category c1 = (Category) s1.get(Category.class, 1);
        System.out.println("log1");
        Category c2 = (Category) s1.get(Category.class, 1);
		System.out.println("log2");
		
		s1.getTransaction().commit();
		s1.close();
		
		//第二个Session
		Session s2 = sf.openSession();
		s2.beginTransaction();
		Category c3 = (Category) s2.get(Category.class, 1);
		System.out.println("log3");
		
		s2.getTransaction().commit();
		s2.close();
		
		sf.close();
	}
}	
