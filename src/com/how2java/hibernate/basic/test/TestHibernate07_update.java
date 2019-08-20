package com.how2java.hibernate.basic.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * 修改：修改一个对象的属性，并更新到数据库中
 * 	根据id获取该对象
 * 	修改该对象的属性
 * 	通过Session的update方法把变化更新到数据库中
 * @author Administrator
 *
 */
public class TestHibernate07_update {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Product p = (Product)s.get(Product.class, 6);
		System.out.println("id=6的产品名称是：" + p.getName());
		
		p.setName("iphone-modified");
		s.update(p);
		
		System.out.println("修改后id=6的产品名称是：" + p.getName());
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
