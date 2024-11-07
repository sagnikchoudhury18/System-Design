package AbstractFactory;

public class AbstractFactoryProducer {

    public  AbstractFactory getFactoryInstance(String value){
        if(value.equals("Economic")){
            return new EconomicCarFactory();
        }
        if(value.equals("Luxury")){
            return new LuxuryCarFactory();
        }
        return null;

    }
}
