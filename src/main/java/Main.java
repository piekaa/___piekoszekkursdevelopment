public class Main {

    public static void main(String[] args) {
        var counter = new Counter();

        System.out.print("Powinno być: ");
        System.out.println("1 2 3 4 5");

        System.out.print("       Jest: ");
        System.out.println(counter.count(5));
    }
}
