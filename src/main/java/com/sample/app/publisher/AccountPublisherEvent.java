/**
 * 
 */
package com.sample.app.publisher;

import com.sample.app.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountPublisherEvent {

	private final User userAccount;

}