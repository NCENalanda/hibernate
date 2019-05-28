package com.nt.dao;

import java.util.List;

import com.nt.domain.ChequePayment;
import com.nt.domain.Payment;

public interface PaymentDAO {
	public void  saveData()throws Exception;
	public List<Payment> loadDataUsingPayment();
	public List<ChequePayment> loadDataUsingChequePayment();

}
