/**
 * 
 */
package com.sample.app.publisher;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Component
@AllArgsConstructor
public class MailPublisherEventListener {
	
	@Async
	@TransactionalEventListener(fallbackExecution = true)
	public void onMailPublisherEvent(MailPublisherEvent mailEvent) {
 		
		log.info("Sending publisher email ...");
	}
}