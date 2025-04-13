import Base.BasePizza;
import Base.Margherita;
import Decorator.ExtraCheese;
import Decorator.Mushroom;

public class Main {
    public static void main(String[] args) {

        System.out.println("Order Margherita + Mushroom +ExtraCheese");
        //BasePizza pizza = new ExtraCheese(new Mushroom(new Margherita()));
        BasePizza myPizza = new Margherita();
        myPizza = new Mushroom(myPizza);
        myPizza = new ExtraCheese(myPizza);

        System.out.println("Cost:  " + myPizza.cost());

        /*
        Each decorator calls the cost() of the object it wraps, adds its own value, and passes the result upward.
        It’s like recursive delegation:
         */
    }
}