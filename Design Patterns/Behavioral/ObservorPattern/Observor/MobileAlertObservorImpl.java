package LowLevelDesign.DesignPatterns.ObservorPattern.Observor;

import LowLevelDesign.DesignPatterns.ObservorPattern.Observable.StockObservable;

public class MobileAlertObservorImpl implements NotificationAlertObservor{

    String username;
    StockObservable observable;

    public MobileAlertObservorImpl(String username, StockObservable observable) {
        this.username = username;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(username, "product in stock hurry up");
    }

    private void sendMsgOnMobile(String username, String msg){
        System.out.println("msg sent to: "+ username);
    }
}
