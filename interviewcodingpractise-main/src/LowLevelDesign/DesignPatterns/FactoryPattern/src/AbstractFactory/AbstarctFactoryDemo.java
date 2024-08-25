package AbstractFactory;

public class AbstarctFactoryDemo {

    public static void main (String args[]){

        AbstractFactoryProducer abstractFactoryProducer = new AbstractFactoryProducer();
        AbstractFactory abstractFactory = abstractFactoryProducer.getFactoryInstance("Economic");
        Car obj = abstractFactory.getInstance(500000);
        System.out.println(obj.getTopSpeed());
    }
}
