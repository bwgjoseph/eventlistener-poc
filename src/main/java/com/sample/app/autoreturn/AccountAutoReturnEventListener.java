/**
 * 
 */
package com.sample.app.autoreturn;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import com.sample.app.AccountRepository;
import com.sample.app.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Component
@AllArgsConstructor
public class AccountAutoReturnEventListener {
	
	private final AccountRepository accountRepository;
	
	@TransactionalEventListener
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public MailAutoReturnEvent onAccountAutoReturnEvent(AccountAutoReturnEvent accountEvent) {
		
		User userAccount = accountEvent.getUserAccount();
		userAccount.setUserFirstName("auto");
		
		this.accountRepository.save(userAccount);
		
		return new MailAutoReturnEvent(userAccount);
	}
	
}