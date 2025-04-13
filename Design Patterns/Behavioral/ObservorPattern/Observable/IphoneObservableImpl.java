package LowLevelDesign.DesignPatterns.ObservorPattern.Observable;

import LowLevelDesign.DesignPatterns.ObservorPattern.Observor.NotificationAlertObservor;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable{

    public List<NotificationAlertObservor> observorList = new ArrayList<>();
    public int stockCount = 0;
    @Override
    public void add(NotificationAlertObservor observor) {
        observorList.add(observor);
    }

    @Override
    public void remove(NotificationAlertObservor observor) {
        observorList.remove(observor);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObservor observor: observorList){
            observor.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if(stockCount==0){
            notifySubscribers();
        }
        stockCount = stockCount+newStockAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
