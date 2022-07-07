public class Main {

    public static void main(String[] args) {

        var adder = new Adder();

        System.out.print("Powinno być: ");
        System.out.println("(5, 10)");

        System.out.print("       Jest: ");
        System.out.println(adder.add(new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2, 1}));
    }
}
