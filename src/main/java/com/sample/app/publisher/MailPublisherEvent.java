/**
 * 
 */
package com.sample.app.publisher;

import com.sample.app.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MailPublisherEvent {

	private final User userAccount;
	
}