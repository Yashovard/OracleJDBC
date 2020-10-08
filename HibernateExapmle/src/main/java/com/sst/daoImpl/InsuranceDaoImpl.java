package com.sst.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sst.dao.InsuranceDao;
import com.sst.model.Insurance;

public class InsuranceDaoImpl implements InsuranceDao {

	// *************************************FetchData*****************************************************//
	public List<Insurance> InsuranceList() {
		Configuration configuration = new Configuration();
		configuration.configure("Hibernate.cfg.xml");
		List<Insurance> InsuranceList = new ArrayList<Insurance>();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		InsuranceList = session.createQuery("from Insurance").list();
		System.out.println(InsuranceList);
		session.close();
		return InsuranceList;
	}

	// ****************************FetchByID**********************************************//
	public Insurance getInsuranceById(int id) {
		Configuration configuration = new Configuration();
		configuration.configure("Hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Insurance insurance = new Insurance();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Insurance WHERE id =:id");
		query.setParameter("id", id);
		insurance = (Insurance) query.uniqueResult();
		session.close();
		return insurance;
	}

	// ****************************************Save***************************************************************///
	public void insertInsurance(Insurance insurance) {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("Hibernate.cfg.xml");
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			insurance.setId(101);
			insurance.setInsuranceName("Car Insurance");
			insurance.setInvestedAmount(5000);
			Date date = new Date();
			insurance.setInvestedDate(date);
			session.save(insurance);
			transaction.commit();
			session.close();
			System.out.println("Data is Inserted...........");

		} catch (Exception exception) {
			System.out.println(exception.getMessage());

		}
	}

	// *********************************************Delete***********************************************************************//
	public boolean RemoveInsurance(int id) {
		Configuration configuration = new Configuration();
		configuration.configure("Hibernate.cfg.xml");
		Insurance insurance = new Insurance();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the id you want to delete");
		id = scanner.nextInt();
		Query query = session.createQuery("Delete from Insurance where" + "id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		session.close();
		System.out.println("Data deleted...");
		return true;
	}

	// ****************************************************Update********************************************************************//
	public int updateInsurance(Insurance insurance) {
		// TODO Auto-generated method stub
		return 0;
	}

	// ********************************Maximum*******************************************//
	public void maxInsurance() {

	}

	public void minInsurance() {
		// TODO Auto-generated method stub

	}

}
