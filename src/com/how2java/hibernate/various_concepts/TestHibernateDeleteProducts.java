package com.how2java.hibernate.various_concepts;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Delete;

import com.how2java.pojo.Product;

/**
 * ͨ��ģ����ѯ���ҳ����ݿ����������ְ��� iphone,��ɾ����
 * @author Administrator
 *
 */
public class TestHibernateDeleteProducts {
	public static void main(String[] args) {
		//���÷���ɾ������iphone������
		getIdByNamesContains_iphone();
	}
	
	/**
	 * ģ����ѯ��product_��name�ֶΰ��� iphone ֵ ��id
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
