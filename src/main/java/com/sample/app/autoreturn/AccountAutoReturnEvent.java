/**
 * 
 */
package com.sample.app.autoreturn;

import com.sample.app.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountAutoReturnEvent {

	private final User userAccount;

}