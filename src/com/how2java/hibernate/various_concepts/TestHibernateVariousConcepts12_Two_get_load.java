package com.how2java.hibernate.various_concepts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * ���ֻ�ȡ��ʽ��
 * ͨ��id��ȡProduct���������ַ�ʽ���ֱ���get��load 
 * ���ǵ�����ֱ�����: 
 * 	1. �ӳټ��� 
 * 	2. ����id�����ڵ�ʱ��Ĵ���
 * @author Administrator
 *
 */
public class TestHibernateVariousConcepts12_Two_get_load {
	public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        
        /**
         * ����id�����ڵĴ���
         * ��ͨ��id=500ȥ��ȡ����:
         * 	1. get��ʽ�᷵��null 
         * 	2. load��ʽ���׳��쳣
         */
        Session s = sf.openSession();
        s.beginTransaction();
        System.out.println("log1");
        Product p = (Product)s.get(Product.class, 5);
        System.out.println("log2");
        Product p2 = (Product)s.load(Product.class, 5);
        System.out.println("log3");
         
        Product p3 = (Product)s.get(Product.class, 500);
        System.out.println("p3="+p3);
         
        Product p4 = (Product)s.load(Product.class, 500);
        System.out.println("p3="+p4);
         
        s.getTransaction().commit();
        s.close();
        sf.close();		
	}
}	
