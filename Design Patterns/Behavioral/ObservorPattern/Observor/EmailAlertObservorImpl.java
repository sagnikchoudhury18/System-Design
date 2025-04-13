package LowLevelDesign.DesignPatterns.ObservorPattern.Observor;

import LowLevelDesign.DesignPatterns.ObservorPattern.Observable.StockObservable;


public class EmailAlertObservorImpl implements NotificationAlertObservor{

    String emailId;
    StockObservable observable;

    public EmailAlertObservorImpl(String emailId, StockObservable observable){
        this.emailId = emailId;
        this.observable = observable;
    }

    public void update(){
            sendEmail(emailId, "Product in stock hurry up");
    }

    public void sendEmail(String emailId, String msg){
        System.out.println("mail sent to:" + emailId);
    }
}
