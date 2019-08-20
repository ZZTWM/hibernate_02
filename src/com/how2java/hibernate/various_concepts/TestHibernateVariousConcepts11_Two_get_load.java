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
public class TestHibernateVariousConcepts11_Two_get_load {
	public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        
        /**
         * �ӳټ��أ�
         * 	load��ʽ���ӳټ��أ�ֻ�����Ա����ʵ�ʱ��Ż����sql���
         * 	get��ʽ�Ƿ��ӳټ��أ����ۺ���Ĵ����Ƿ����ʵ����ԣ�����ִ��sql���
         */
        Session s = sf.openSession();
        s.beginTransaction();
        System.out.println("log1");
        Product p = (Product) s.get(Product.class, 1);
        System.out.println(p.getName());
        System.out.println("log2");
        Product p2 = (Product) s.load(Product.class, 2);
        System.out.println("log3");
        System.out.println(p2.getName());
        System.out.println("log4");
         
        s.getTransaction().commit();
        s.close();
        sf.close();
	}
}	
