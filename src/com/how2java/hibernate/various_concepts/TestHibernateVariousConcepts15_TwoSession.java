package com.how2java.hibernate.various_concepts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * ����Session��ʽ��
 * Hibernate�����ַ�ʽ���session,�ֱ��ǣ� 
 * 	openSession��getCurrentSession 
 * 	���ǵ��������� 
 * 	1. ��ȡ���Ƿ���ͬһ��session���� 
 * 		openSessionÿ�ζ���õ�һ���µ�Session���� 
 * 		getCurrentSession��ͬһ���߳��У�ÿ�ζ��ǻ�ȡ��ͬ��Session���󣬵����ڲ�ͬ���߳��л�ȡ���ǲ�ͬ��Session���� 
 * 	2. �����ύ�ı�Ҫ�� 
 * 		openSessionֻ�������ӣ�ɾ�����޸ĵ�ʱ����Ҫ���񣬲�ѯʱ����Ҫ�� 
 * 		getCurrentSession�����в�����������������н��У������ύ�����session���Զ��رգ����ܹ��ٽ��йر� 
 *
 */
public class TestHibernateVariousConcepts15_TwoSession {
	static Session s1;
	static Session s2;
	public static void main(String[] args) throws InterruptedException {
		
		/**
		 * ��ͬ�̵߳�getCurrentSession
		 * 	���ӡfalse
		 */
		
		final SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//���������߳�
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
