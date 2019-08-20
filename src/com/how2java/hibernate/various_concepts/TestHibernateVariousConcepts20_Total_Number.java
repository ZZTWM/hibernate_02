package com.how2java.hibernate.various_concepts;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * 返回满足条件的总数
 * 	
 */
public class TestHibernateVariousConcepts20_Total_Number {
	public static void main(String[] args) {
		/**
		 * 首先还是准备一个有统计函数的语句
		 * 	select count(*) from ....
		 * 	根据这条SQL语句创建一个Query对象，调用Query对象的uniqueResult()方法，返回一个long型的数据，即查询总数。
		 */
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		String name = "iphone";
		
		Query q = s.createQuery("select count(*) from Product p where p.name like ?");
		q.setString(0, "%"+name+"%");
		
		long total = (Long)q.uniqueResult();
		System.out.println("总数是：" + total);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
}	
