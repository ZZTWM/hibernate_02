package com.how2java.hibernate.various_concepts;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;
/**
 * 级联:
 * 	保存-更新：
 * 	save-update级联：
 * 	Category.hbm.xml设置：
 * 	<set name="products" cascade="save-update" lazy="false">
 *
 */
public class TestHibernateVariousConcepts07_Cascade {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = (Category) s.get(Category.class, 5);
		System.out.println(c.getName());
		
		/**
		 * 如果这里在不配置级联： cascade="save-update"就会报错，因为：
		 * 	new了Product新对象，在未保存之前又将它存进了一个新new的对象【Category】，也即不是持久态。
		 */
		
        Product p1 = new Product();
        p1.setName("魅族4s");
        Product p2 = new Product();
        p2.setName("魅族5s");
        Product p3 = new Product();
        p3.setName("魅族6s");
        
        c.getProducts().add(p1);
        c.getProducts().add(p2);
        c.getProducts().add(p3);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
}	
