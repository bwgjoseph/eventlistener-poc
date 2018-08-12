# eventlistener-poc

A poc application to illustrate issue pertaining to Spring `@EventListener`.

Build the application: **mvn spring-boot:run**
Access the application: **http://localhost:8080**

There will be 3 form to submit. Only `Form #3` is of concern as it shows exactly the issue when using `BaseEvent` as input parameter when listening to event.

# 1. Spring publish event by return type [Triggers AutoReturn Event]

## 1.1 without using (fallbackExecution = true)
- AccountService publish AccountAutoReturnEvent
- AccountAutoReturnEventListener has received the event update the object to Repository
- MailAutoReturnEventListener was setup without using (fallbackExecution = true)
- However, either event wasn't publish, or MailAutoReturnEventListener does not receive any event

## 1.2 using (fallbackExecution = true)
- AccountService publish AccountAutoReturnEvent
- AccountAutoReturnEventListener has received the event update the object to Repository
- MailAutoReturnEventListener was setup using (fallbackExecution = true)
- MailAutoReturnEventListener received the event and process succesfully

# 2. Manual publish event using ApplicationEventPublisher [Triggers Publisher Event]

## 2.1 with or without using (fallbackExecution = true)
- AccountService publish AccountPublisherEvent
- AccountPublisherEventListener has received the event update the object to Repository
- MailPublisherEventListener was setup with or without using (fallbackExecution = true)
- MailPublisherEventListener received the event and process succesfully

# 3. Manual publish event using ApplicationEventPublisher [Triggers Publisher Common Event]

## 3.1 using BaseEvent as parameter
- AccountService publish AccountPublisherCommonEvent
- AccountPublisherCommonEventListener has received the event with parameter as BaseEvent then update the object to Repository
- MailPublisherCommonEventListener was setup with or without using (fallbackExecution = true)
- MailPublisherCommonEventListener received the event and process succesfully

## 3.2 using BaseEvent as parameter and defining in @TransactionalEventListener
- AccountService publish AccountPublisherCommonEvent
- AccountPublisherCommonEventListener has received the event with parameter as BaseEvent 
- Defines @TransactionalEventListener({AccountPublisherCommonEvent.class}) 
- then update the object to Repository
- MailPublisherCommonEventListener was setup with or without using (fallbackExecution = true)
- MailPublisherCommonEventListener received the event and process succesfully

