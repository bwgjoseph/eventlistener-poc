/**
 * 
 */
package com.sample.app.publishercommonevent;

import org.springframework.context.ApplicationEventPublisher;
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
public class AccountPublisherCommonEventListener {
	
	private final AccountRepository accountRepository;
	private final ApplicationEventPublisher eventPublisher;
	
	/**
	 * After much investigation, the issue lies in the parameter
	 * If it is set to BaseEvent object, then the loop issue will occur
	 * but if it is set to the actual event such as AccountPublisherCommonEvent then 
	 * everything will be fine
	 * 
	 * An alternative solution is to set the classes to listen to in @TransactionalEventListener then one can set the BaseEvent as the parameter
	 * 
	 * Try remove ({AccountPublisherCommonEvent.class}) in @TransactionalEventListener and the loop issue will occur
	 * @param accountEvent
	 */
//	@TransactionalEventListener // Use this and the loop issue will occur
	@TransactionalEventListener({AccountPublisherCommonEvent.class}) // Use this and the loop issue will not occur
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void onAccountPublisherCommonEvent(BaseEvent accountEvent) {
		
		User userAccount = accountEvent.getUserAccount();
		userAccount.setUserFirstName("common");
		
		this.accountRepository.save(userAccount);
		
		this.eventPublisher.publishEvent(new MailPublisherCommonEvent(userAccount));
	}
	
}