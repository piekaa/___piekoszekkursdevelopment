public class Main {

    public static void main(String[] args) {

        System.out.println("Powinno wyrzucić wyjątek");
        new StringConverter().toPascalCase("dej mnie  nogie");
        System.out.print("A nie wyrzuca");
    }
}
