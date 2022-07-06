public class Main {

    public static void main(String[] args) {

        System.out.print("Powinno być: ");
        System.out.println("PiekoszkaKursJestNajlepszy");

        System.out.print("       Jest: ");
        System.out.println(new StringConverter().toPascalCase("piekoszka kurs jest najlepszy"));
    }
}
