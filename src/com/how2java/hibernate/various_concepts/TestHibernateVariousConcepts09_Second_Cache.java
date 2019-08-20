package com.how2java.hibernate.various_concepts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
/**
 * ��������
 * 	Hibernate��һ����������Session�ϣ�������������SessionFactory��
 * @author Administrator
 *
 */
public class TestHibernateVariousConcepts09_Second_Cache {
	public static void main(String[] args) {
		/**
		 * 	ʹ�ò�ͬ��session,��ȥ��ȡid=1��category,ֻ�����һ�����ݿ⡣
		 * 	��Ϊ�ڶ��λ�ȡ��Ȼû�дӵڶ���session���õ����棬���Ǵ�sessionfactory���õ���Category�������
		 */
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//��һ��Session
		Session s1 = sf.openSession();
		s1.beginTransaction();
		
        Category c1 = (Category) s1.get(Category.class, 1);
        System.out.println("log1");
        Category c2 = (Category) s1.get(Category.class, 1);
		System.out.println("log2");
		
		s1.getTransaction().commit();
		s1.close();
		
		//�ڶ���Session
		Session s2 = sf.openSession();
		s2.beginTransaction();
		Category c3 = (Category) s2.get(Category.class, 1);
		System.out.println("log3");
		
		s2.getTransaction().commit();
		s2.close();
		
		sf.close();
	}
}	
