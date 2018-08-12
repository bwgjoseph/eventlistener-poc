/**
 * 
 */
package com.sample.app.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import com.sample.app.AccountRepository;
import com.sample.app.User;
import com.sample.app.publisher.AccountPublisherEvent;
import com.sample.app.publisher.MailPublisherEvent;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Component
@AllArgsConstructor
public class AccountPublisherEventListener {
	
	private final AccountRepository accountRepository;
	private final ApplicationEventPublisher eventPublisher;
	
	@TransactionalEventListener
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void onAccountPublisherEvent(AccountPublisherEvent accountEvent) {
		
		User userAccount = accountEvent.getUserAccount();
		userAccount.setUserFirstName("publisher");
		
		this.accountRepository.save(userAccount);
		
		this.eventPublisher.publishEvent(new MailPublisherEvent(userAccount));
	}
	
}