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
public class TestHibernateVariousConcepts15_TwoSession {
	static Session s1;
	static Session s2;
	public static void main(String[] args) throws InterruptedException {
		
		/**
		 * 不同线程的getCurrentSession
		 * 	会打印false
		 */
		
		final SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//开启两个线程
		Thread t1 = new Thread(){
			public void run(){
				 s1 = sf.getCurrentSession();
			}
		};
		t1.start();
		
		Thread t2 = new Thread(){
			public void run(){
				 s2 = sf.getCurrentSession();
			}
		};
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(s1 == s2);//false
		
	}
}	
