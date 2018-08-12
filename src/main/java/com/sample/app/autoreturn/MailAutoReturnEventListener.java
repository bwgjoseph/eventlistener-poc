/**
 * 
 */
package com.sample.app.autoreturn;

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
public class MailAutoReturnEventListener {
	
	@Async
	@TransactionalEventListener(fallbackExecution = true)
	public void onMailAutoReturnEvent(MailAutoReturnEvent mailEvent) {
 		
		log.info("Sending auto email ...");
	}
	
}