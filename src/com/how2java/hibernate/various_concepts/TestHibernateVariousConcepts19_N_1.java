package com.how2java.hibernate.various_concepts;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 *Hibernate�л�����ƣ�����ͨ����id��Ϊkey��product���󱣴��ڻ����� 
 *	ͬʱhibernateҲ�ṩQuery�Ĳ�ѯ��ʽ���������ݿ�����100����¼��������30����¼�ڻ����У�
 *		����ʹ��Query��list�������ͻ����е�100�����ݶ������ݿ��в�ѯ����������30�������еļ�¼ 
 *	N+1��ʲô��˼�أ�����ִ��һ��sql��䣬ȥ��ѯ��100����¼�����ǣ�ֻ������100����¼��ID 
 *		Ȼ���ٸ���id,���н�һ����ѯ��
 *	���id�ڻ����У��ʹӻ����л�ȡproduct�����ˣ������ٴ����ݿ��л�ȡ
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
		 * Hibernateʹ��Iteratorʵ��N 1:
		 * 	����ͨ��Query��iterator����������������Product��id�����
		 * 	Ȼ����ͨ��it.next()��ѯÿһ������
		 * 	�����������ڻ����У���ֱ�Ӵӻ�����ȡ��
		 * 	����ʹ����ݿ��л�ȡ
		 * 	N+1�е�1������ָֻ����id��SQL��䣬Nָ��������ڻ������Ҳ�����Ӧ�����ݣ��͵����ݿ���ȥ��
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
