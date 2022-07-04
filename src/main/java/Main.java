public class Main {

    public static void main(String[] args) {

        System.out.print("Powinno być: ");
        System.out.println(true);

        System.out.print("       Jest: ");
        System.out.println(new Mathematician().isEquationCorrect("1+2=3"));
    }
}
