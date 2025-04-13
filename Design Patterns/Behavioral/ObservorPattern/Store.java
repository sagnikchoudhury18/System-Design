package LowLevelDesign.DesignPatterns.ObservorPattern;

import LowLevelDesign.DesignPatterns.ObservorPattern.Observable.IphoneObservableImpl;
import LowLevelDesign.DesignPatterns.ObservorPattern.Observable.StockObservable;
import LowLevelDesign.DesignPatterns.ObservorPattern.Observor.EmailAlertObservorImpl;
import LowLevelDesign.DesignPatterns.ObservorPattern.Observor.MobileAlertObservorImpl;
import LowLevelDesign.DesignPatterns.ObservorPattern.Observor.NotificationAlertObservor;

public class Store {

    public static void main(String args[]){

        StockObservable iphoneStockOvservable = new IphoneObservableImpl();

        NotificationAlertObservor observor1 = new EmailAlertObservorImpl("xyz@gmail.com", iphoneStockOvservable);
        NotificationAlertObservor observor2 = new EmailAlertObservorImpl("pqr@gmail.com", iphoneStockOvservable);
        NotificationAlertObservor observor3 = new MobileAlertObservorImpl("abc@gmail.com", iphoneStockOvservable);

        iphoneStockOvservable.add(observor1);
        iphoneStockOvservable.add(observor2);
        iphoneStockOvservable.add(observor3);

        iphoneStockOvservable.setStockCount(10);

    }
}
