import Base.BasePizza;
import Base.Margherita;
import Decorator.ExtraCheese;
import Decorator.Mushroom;

public class Main {
    public static void main(String[] args) {

        System.out.println("Order Margherita + Mushroom +ExtraCheese");
        BasePizza pizza = new ExtraCheese(new Mushroom(new Margherita()));
        System.out.println("Cost:  " + pizza.cost());
    }
}