/**
 * 
 */
package com.sample.app.publishercommonevent;

import com.sample.app.User;

public class AccountPublisherCommonEvent extends BaseEvent {

	public AccountPublisherCommonEvent(User userAccount) {
		super(userAccount);
	}

}