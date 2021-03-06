/**
 * 
 */
package com.sample.app.publishercommonevent;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Joseph
 * @since 1.0.0
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountPublisherCommonRegistrationForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userEmail;
	
	private String userName;
	
	private String userFirstName;
	
	private String userLastName;
	
}