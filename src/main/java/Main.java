public class Main {

    public static void main(String[] args) {

        var adultChecker = new AdultChecker();

        System.out.print("Powinno być: Adult");
        System.out.println();

        System.out.print("       Jest: ");
        System.out.println(adultChecker.check(18));
    }
}
