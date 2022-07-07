public class Main {

    public static void main(String[] args) {

        var adder = new Adder();

        System.out.print("Powinno być: ");
        System.out.println(45);

        System.out.print("       Jest: ");
        System.out.println(adder.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
