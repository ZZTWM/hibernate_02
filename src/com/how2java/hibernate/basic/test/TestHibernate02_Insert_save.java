package com.how2java.hibernate.basic.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

/**
 * save()
 * 向category_表插入一条数据
 * @author Administrator
 *
 */
public class TestHibernate02_Insert_save {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = new Category();
		c.setName("分类1");
		s.save(c);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
