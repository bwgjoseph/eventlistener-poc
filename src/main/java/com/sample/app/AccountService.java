package com.sample.app;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.app.autoreturn.AccountAutoReturnEvent;
import com.sample.app.autoreturn.AccountAutoReturnRegistrationForm;
import com.sample.app.publisher.AccountPublisherEvent;
import com.sample.app.publisher.AccountPublisherRegistrationForm;
import com.sample.app.publishercommonevent.AccountPublisherCommonEvent;
import com.sample.app.publishercommonevent.AccountPublisherCommonRegistrationForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepository accountRepository;
	private final ApplicationEventPublisher eventPublisher;
	
	@Transactional
	public void createUserAccount(AccountAutoReturnRegistrationForm registrationForm) {
		
		User user = User.builder()
					.userEmail(registrationForm.getUserEmail())
					.userName(registrationForm.getUserName())
					.userFirstName(registrationForm.getUserFirstName())
					.userLastName(registrationForm.getUserLastName())
					.build();
		
		this.accountRepository.save(user);
		this.eventPublisher.publishEvent(new AccountAutoReturnEvent(user));
	}
	
	@Transactional
	public void createUserAccountPublisher(AccountPublisherRegistrationForm registrationForm) {
		
		User user = User.builder()
					.userEmail(registrationForm.getUserEmail())
					.userName(registrationForm.getUserName())
					.userFirstName(registrationForm.getUserFirstName())
					.userLastName(registrationForm.getUserLastName())
					.build();
		
		this.accountRepository.save(user);
		this.eventPublisher.publishEvent(new AccountPublisherEvent(user));
	}
	
	@Transactional
	public void createUserAccountPublisherCommon(AccountPublisherCommonRegistrationForm registrationForm) {
		
		User user = User.builder()
					.userEmail(registrationForm.getUserEmail())
					.userName(registrationForm.getUserName())
					.userFirstName(registrationForm.getUserFirstName())
					.userLastName(registrationForm.getUserLastName())
					.build();
		
		this.accountRepository.save(user);
		this.eventPublisher.publishEvent(new AccountPublisherCommonEvent(user));
	}
	
}
