package nurullahdur.com.OOPExerciseHambugerExample;

public class Main {
    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Basic","Sausage",3.56,"White");
        double price = hamburger.itemizeHamburger();

        hamburger.addHamburgerAddition1("Tomato",2.3);
        hamburger.addHamburgerAddition2("Salad",1.2);

        System.out.println("Total Hamburger Price is " + hamburger.itemizeHamburger());

        HealthyBurger healthyBurger = new HealthyBurger("Bacon",3.4);

        healthyBurger.addHealthAddition1("Egg",2.1);
        healthyBurger.itemizeHamburger();
        System.out.println("Healthy Burger total price is : "+ healthyBurger.itemizeHamburger());
    }
}
