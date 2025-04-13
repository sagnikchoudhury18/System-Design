package LowLevelDesign.DesignPatterns.ObservorPattern.Observable;

import LowLevelDesign.DesignPatterns.ObservorPattern.Observor.NotificationAlertObservor;

public interface StockObservable {

    public void add(NotificationAlertObservor observor);

    public void remove(NotificationAlertObservor observor);

    public void notifySubscribers();

    public void setStockCount(int newStockAdded);

    public int getStockCount();
}
