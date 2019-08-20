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
public class TestHibernateVariousConcepts14_Two_Session {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s1 = sf.getCurrentSession();
		Session s2 = sf.getCurrentSession();
		/**
		 * �����ͬһ���߳�(�����������߳���)��ÿ�λ�ȡ�Ķ�����ͬ��Session
		 * ���������ӡtrue
		 */
		System.out.println(s1==s2);//true
		
		s1.close();
		/**
		 * ����ע�͵�һ������Ȼ�ᱨ��Session was already closed
		 * 	��Ϊʹ�õ���getCurrentSession()����ȡSession�������������ʱ�򣬲������ύ���ǻع�����
		 * 	hibernate���Զ��ر�Session�ģ����Բ���Ҫ�ֶ��ر�
		 */
		//s2.close();
		sf.close();
		
	}
}	
