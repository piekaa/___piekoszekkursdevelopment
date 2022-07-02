public class Main {

    public static void main(String[] args) {
        var greeter = new Greeter();

        System.out.print("Powinno być: ");
        System.out.println("Good morning!");

        System.out.print("       Jest: ");
        System.out.println(greeter.greet());
    }
}
