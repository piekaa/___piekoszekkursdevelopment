public class Main {

    public static void main(String[] args) {

        System.out.print("Powinno być: ");
        System.out.println("14.0");

        System.out.print("       Jest: ");
        System.out.println(new Mathematician().specialEquation(2, 5, 3, 1.5f));
    }
}