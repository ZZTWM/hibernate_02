package com.how2java.hibernate.various_concepts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * 两种获取方式：
 * 通过id获取Product对象有两种方式，分别是get和load 
 * 他们的区别分别在于: 
 * 	1. 延迟加载 
 * 	2. 对于id不存在的时候的处理
 * @author Administrator
 *
 */
public class TestHibernateVariousConcepts12_Two_get_load {
	public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        
        /**
         * 对于id不存在的处理：
         * 都通过id=500去获取对象:
         * 	1. get方式会返回null 
         * 	2. load方式会抛出异常
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
