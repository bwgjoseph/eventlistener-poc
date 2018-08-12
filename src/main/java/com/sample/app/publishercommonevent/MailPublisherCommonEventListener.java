/**
 * 
 */
package com.sample.app.publishercommonevent;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Component
@AllArgsConstructor
public class MailPublisherCommonEventListener {
	
	/**
	 * It does not matter whether fallbackExecution is set or not because
	 * it is within a transaction boundary since I had
	 * @Transactional(propagation = Propagation.REQUIRES_NEW)
	 * in AccountPublisherCommonEventListener.onAccountPublisherCommonEvent
	 * 
	 * In this case, I suppose I should not be setting fallbackExecution because it should
	 * listen to the previous transaction
	 * @param mailEvent
	 */
	@Async
	@TransactionalEventListener
//	@TransactionalEventListener(fallbackExecution = true)
	public void onMailPublisherCommonEvent(MailPublisherCommonEvent mailEvent) {
 		
		log.info("Sending common email ...");
	}
}