package com.how2java.hibernate.various_concepts;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.how2java.pojo.Product;

/**
 * 
 * 分页：
 * 	使用Criteria进行分页查询 
 * 	无论你使用的是Oracle,Mysql,NoSQL还是DB2，分页查询的代码写法都是一样的
 * 
 *
 */
public class TestHibernateVariousConcepts10_Paging {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		String name = "iphone";
		Criteria c = s.createCriteria(Product.class);
		c.add(Restrictions.like("name", "%"+name+"%"));
		c.setFirstResult(2);//从第3条数据开始
		c.setMaxResults(5);//表示一共查询5条数据
		
		List<Product> ps = c.list();
		for (Product product : ps) {
			System.out.println(product.getName());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}	
