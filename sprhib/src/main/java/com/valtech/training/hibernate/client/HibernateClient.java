package com.valtech.training.hibernate.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.hibernate.BankAccount;
import com.valtech.training.hibernate.BankAccountId;
import com.valtech.traning.hibernate.Account;
import com.valtech.traning.hibernate.Address;
import com.valtech.traning.hibernate.ChequeTx;
import com.valtech.traning.hibernate.Customer;
import com.valtech.traning.hibernate.Registration;
import com.valtech.traning.hibernate.TellerTx;

public class HibernateClient {
	public static void main(String[] args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		AnnotationConfiguration cfg = new AnnotationConfiguration();

		cfg.addAnnotatedClass(com.valtech.traning.hibernate.Employee.class);

		cfg.addAnnotatedClass(com.valtech.traning.hibernate.Tx.class).addAnnotatedClass(ChequeTx.class)
				.addAnnotatedClass(TellerTx.class).addAnnotatedClass(com.valtech.traning.hibernate.AtmTx.class);

		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class);
		cfg.addAnnotatedClass(Account.class);

		cfg.addAnnotatedClass(Registration.class).addAnnotatedClass(BankAccount.class);
		
		

		SessionFactory sesFac = cfg.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tx = ses.beginTransaction();

		ses.persist(new BankAccount(new BankAccountId("SB",1),3000));
		
		BankAccountId id = new BankAccountId("SB",1);
		BankAccount ba = (BankAccount) ses.load(BankAccount.class,id);
//		Customer cus = new Customer("Abc",23);
//		ses.save(cus);
//		Address add = new Address("JP Nagar","Banglore",560078);
//		add.setCustomer(cus);
//		ses.save(add);
//
//		Account acc = new Account(10000,"SB");
//		Tx tx1 = new Tx(1000);
//		Tx tx2 = new ChequeTx(2000,123123,34535);
//		Tx tx3= new TellerTx(3000,123,345);
//		Tx tx4 = new AtmTx(5000,7869);
//		
//		
//		Account acc1 = new Account(2000,"CA");
//		Tx tx5 = new ChequeTx(2000,456233,341341);
//		
//
//		Customer cus1 = new Customer("Def",25);
//		Customer cus2 = new Customer("Pqr",27);
//		Address  add1 = new Address("Jayanagr","Banglore",560070);
//		Address add2 = new Address("Gandinagar","hyd",560055);
//		
//    	ses.persist(acc);
//		ses.persist(tx1);
//		ses.persist(tx2);
//		ses.persist(tx3);
//		ses.persist(tx4);
//		
//		
//		ses.persist(acc1);
//		ses.persist(tx5);
//		ses.persist(cus1);
//		ses.persist(cus2);
//		ses.persist(add1);
//		ses.persist(add2);
//		
//		acc.addTx(tx1);
//		acc.addTx(tx2);
//		acc.addTx(tx3);
//		acc.addTx(tx4);
//
//		acc1.addTx(tx5);
//		acc1.addCustomer(cus2);
//		acc1.addCustomer(cus);
//		acc.addCustomer(cus1);
//		acc.addCustomer(cus2);
//		acc.addCustomer(cus);
//		
//		
//		cus1.setAddress(add1);
//		add1.setCustomer(cus1);
//		cus2.setAddress(add2);
//		add2.setCustomer(cus2);
//	
//
//		ses.save(new Tx(1000));//1 insertion
//		ses.save(new ChequeTx(2000,123123,34435));//2 insertion
//		ses.save(new TellerTx(3000,123,345));//2 insertion
//		ses.save(new AtmTx(5000,789));  // 2 insertion (7 queries will be executed one on each table along with transaction table)

		// ses.createQuery("SELECT tx from Tx tx").list().forEach(t ->
		// System.out.println(t));
		// ses.createQuery("SELECT DISTINCT tx.account FROM Tx tx").list().forEach(t ->
		// System.out.println(t));
		// ses.createQuery("from Tx tx").list().forEach(t -> System.out.println(t));//
		// it calls tostring method

//		org.hibernate.Query query = ses.createQuery("SELECT DISTINCT  c FROM Customer c join c.accounts a join a.txs t where t.amount > ? ");
//		query.setFloat(0, 3000);
//		query.list().forEach(t -> System.out.println(t));	

//	Query query=ses.getNamedQuery("Tx.findAllByCityAndAmountGreaterThan");
//////			("Select t from Tx t join t.account.customers c where c.address.city= ? and t.amount > ?");
//	query.setString(0, "Banglore");
//	query.setFloat(1, 3000);
//	query.list().forEach(t -> System.out.println(t));

//		ses.persist(new Employee(1, "ABC", df.parse("15-08-1947"), 20000, 'M', false));
//		ses.persist(new Employee("ABC", df.parse("15-08-1947"), 20000, 'M', false)); //for identity

//		int id = (Integer) ses.save(new Employee("ABC", df.parse("15-08-1947"), 20000, 'M', false));
//		System.out.println(id);
////		
//		Employee e = (Employee) ses.get(Employee.class, 1);
//		System.out.println(e.getClass().getName());
//		e.setName("Abc1");
//	    ses.merge(e);
		System.out.println("Loding....");

		tx.commit();
		ses.close();
		sesFac.close();
	}
}
