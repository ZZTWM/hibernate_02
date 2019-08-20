package com.how2java.hibernate.various_concepts;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * 建立数据库连接时比较消耗时间的，所以通常都会采用数据库连接池的技术来建立多条数据库连接，并且在将来持续使用，从而节约掉建立数据库连接的时间 
 * 	hibernate本身是提供了数据库连接池的，但是hibernate官网也不推荐使用他自带的数据库连接池。 
 * 	一般都会使用第三方的数据库连接池 
 * 	C3P0是免费的第三方的数据库连接池，并且有不错的表现 
 * 	右边可以下载c3p0的jar包 
 * 	注：当运行次数不大的时候，从运行效果上来看，是看不出区别的。 只有在高并发量的情况下，才会体会出来。
 * 	本知识主要是提供这个相关配置办法，以供以后有需要的时候，查询与修改方便。 
 * 	
 */
public class TestHibernateVariousConcepts22_c3p0_ConnectionPool {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s1 = sf.openSession();
		s1.beginTransaction();
		
		Query q = s1.createQuery("from Product");
		List<Product> products = q.list();
		for (Product product : products) {
			System.out.println(product);
		}
		
		s1.getTransaction().commit();
		s1.close();
		sf.close();
	}
}	
