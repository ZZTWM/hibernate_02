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
public class TestHibernateVariousConcepts13_Two_Session {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s1 = sf.openSession();
		Session s2 = sf.openSession();
		/**
		 * OpenSessionÿ�ζ���õ�һ���µ�Session����
		 * ����System.out.println(s1==s2);
		 * ���ӡfalse
		 */
		System.out.println(s1==s2);//false
		
		s1.close();
		s2.close();
		sf.close();
		
	}
}	
