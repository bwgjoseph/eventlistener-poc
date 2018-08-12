/**
 * 
 */
package com.sample.app.publishercommonevent;

import com.sample.app.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseEvent {

	private final User userAccount;
	
}