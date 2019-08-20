package com.how2java.hibernate.various_concepts;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 *Hibernate有缓存机制，可以通过用id作为key把product对象保存在缓存中 
 *	同时hibernate也提供Query的查询方式。假设数据库中有100条记录，其中有30条记录在缓存中，
 *		但是使用Query的list方法，就会所有的100条数据都从数据库中查询，而无视这30条缓存中的记录 
 *	N+1是什么意思呢，首先执行一条sql语句，去查询这100条记录，但是，只返回这100条记录的ID 
 *		然后再根据id,进行进一步查询。
 *	如果id在缓存中，就从缓存中获取product对象了，否则再从数据库中获取
 */
public class TestHibernateVariousConcepts19_N_1 {
	public static void main(String[] args) throws InterruptedException {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		String name = "iphone";
		Query q = s.createQuery("from Product p where p.name like ?");
		q.setString(0, "%"+name+"%");
		
		/**
		 * Hibernate使用Iterator实现N 1:
		 * 	首先通过Query的iterator把所有满足条件的Product的id查出来
		 * 	然后再通过it.next()查询每一个对象
		 * 	如果这个对象在缓存中，就直接从缓存中取了
		 * 	否则就从数据库中获取
		 * 	N+1中的1，就是指只返回id的SQL语句，N指的是如果在缓存中找不到对应的数据，就到数据库中去查
		 */
		Iterator<Product> it = q.iterate();
		while(it.hasNext()){
			Product p = it.next();
			System.out.println(p.getName());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}	
