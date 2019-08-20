package com.how2java.hibernate.various_concepts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * 两种Session方式：
 * Hibernate有两种方式获得session,分别是： 
 * 	openSession和getCurrentSession 
 * 	他们的区别在于 
 * 	1. 获取的是否是同一个session对象 
 * 		openSession每次都会得到一个新的Session对象 
 * 		getCurrentSession在同一个线程中，每次都是获取相同的Session对象，但是在不同的线程中获取的是不同的Session对象 
 * 	2. 事务提交的必要性 
 * 		openSession只有在增加，删除，修改的时候需要事务，查询时不需要的 
 * 		getCurrentSession是所有操作都必须放在事务中进行，并且提交事务后，session就自动关闭，不能够再进行关闭 
 *
 */
public class TestHibernateVariousConcepts14_Two_Session {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s1 = sf.getCurrentSession();
		Session s2 = sf.getCurrentSession();
		/**
		 * 如果是同一个线程(本例是在主线程里)，每次获取的都是相同的Session
		 * 所以这里打印true
		 */
		System.out.println(s1==s2);//true
		
		s1.close();
		/**
		 * 这里注释掉一个，不然会报错：Session was already closed
		 * 	因为使用的是getCurrentSession()来获取Session，当事务结束的时候，不管是提交还是回滚事务，
		 * 	hibernate会自动关闭Session的，所以不需要手动关闭
		 */
		//s2.close();
		sf.close();
		
	}
}	
