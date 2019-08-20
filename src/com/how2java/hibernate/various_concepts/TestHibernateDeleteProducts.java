package com.how2java.hibernate.various_concepts;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Delete;

import com.how2java.pojo.Product;

/**
 * 通过模糊查询查找出数据库中所有名字包含 iphone,并删除掉
 * @author Administrator
 *
 */
public class TestHibernateDeleteProducts {
	public static void main(String[] args) {
		//调用方法删除包含iphone的数据
		getIdByNamesContains_iphone();
	}
	
	/**
	 * 模糊查询出product_表name字段包含 iphone 值 的id
	 * @return
	 */
	public static void getIdByNamesContains_iphone(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		String name = "iphone";
		Query q = s.createQuery("from Product p where p.name like ?");
		q.setString(0, "%"+name+"%");
		List<Product> ps = q.list();
		for (Product product : ps) {
			s.delete(product);
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
	
}
