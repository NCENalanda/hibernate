package com.nt.dao;

import java.util.List;

import com.nt.domain.BankAccount;

public interface BankAccountDAO {
	public List<BankAccount> getAccountHoldersByBalanceRange(float startRange,float endRange);

}
