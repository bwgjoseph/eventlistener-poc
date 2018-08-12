/**
 * 
 */
package com.sample.app.publishercommonevent;

import com.sample.app.User;

public class MailPublisherCommonEvent extends BaseEvent {

	public MailPublisherCommonEvent(User userAccount) {
		super(userAccount);
	}

}