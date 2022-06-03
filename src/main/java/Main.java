public class Main {

    public static void main(String[] args) {
        Greeter greeter = new Greeter();

        System.out.println("Powinno być");
        System.out.println("Good morning, Janusz");
        System.out.println("Jest");
        System.out.println(greeter.greet("Janusz"));
    }
}
