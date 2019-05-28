package com.nt.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.CardPayment;
import com.nt.domain.ChequePayment;
import com.nt.domain.Payment;
import com.nt.utility.HibernateUtil;

public class PaymentDAOImpl implements PaymentDAO {
	private static final String HQL_GET_DETAILS_USING_PAYMENT = "from Payment";
	private static final String HQL_GET_DETAILS_USING_CHEQUEPAYMENT = "from ChequePayment";

	@Override
	public void saveData() throws Exception {
		Session ses = null;
		boolean flag = false;
		Transaction tx = null;
		ChequePayment chPayment = null;
		CardPayment cardPayment = null;

		// get Session
		ses = HibernateUtil.getSession();
		try {
			// Begin Transaction
			tx = ses.beginTransaction();
			// prepare objects
			chPayment = new ChequePayment();
			chPayment.setAmount(9000);
			chPayment.setTxDate(new Date());
			chPayment.setChequeType("Acc Payee");
			chPayment.setChequeNumber(12344555);

			cardPayment = new CardPayment();
			cardPayment.setTxDate(new Date());
			cardPayment.setAmount(90000);
			cardPayment.setCardType("DEBIT");
			cardPayment.setCardNumber(99999999);
			cardPayment.setPaymentGateway("VISA");
			// save objs
			ses.save(chPayment);
			ses.save(cardPayment);
			flag = true;

		} catch (HibernateException he) {
			flag = false;
			throw he;
		} catch (Exception e) {
			flag = false;
			throw e;
		} finally {
			if (flag == true) {
				tx.commit();
			} else {
				tx.rollback();
			}

			HibernateUtil.closeSession(ses);
		} // finally
	}// method

	@Override
	public List<Payment> loadDataUsingPayment() {
		Session ses = null;
		Query query = null;
		List<Payment> list = null;
		// Get Session
		ses = HibernateUtil.getSession();
		try {
			// create Query object
			query = ses.createQuery(HQL_GET_DETAILS_USING_PAYMENT);
			// execute Query
			list = query.list();
		} catch (HibernateException he) {
			throw he;
		} catch (Exception e) {
			throw e;
		} finally {
			HibernateUtil.closeSession(ses);
		}
		return list;
	}// method

	@Override
	public List<ChequePayment> loadDataUsingChequePayment() {
		Session ses = null;
		Query query = null;
		List<ChequePayment> list = null;
		// Get Session
		ses = HibernateUtil.getSession();
		try {
			// create Query object
			query = ses.createQuery(HQL_GET_DETAILS_USING_CHEQUEPAYMENT);
			// execute Query
			list = query.list();
		} catch (HibernateException he) {
			throw he;
		} catch (Exception e) {
			throw e;
		} finally {
			HibernateUtil.closeSession(ses);
		}
		return list;
	}//method

}// class
