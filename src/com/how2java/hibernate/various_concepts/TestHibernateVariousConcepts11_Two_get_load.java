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
public class TestHibernateVariousConcepts11_Two_get_load {
	public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        
        /**
         * 延迟加载：
         * 	load方式是延迟加载，只有属性被访问的时候才会调用sql语句
         * 	get方式是非延迟加载，无论后面的代码是否会访问到属性，马上执行sql语句
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
