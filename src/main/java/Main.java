public class Main {

    public static void main(String[] args) {

        var writer = createWriter();

        System.out.print("Powinno być: ");
        System.out.println("NajlepszyKurs");

        System.out.print("       Jest: ");
        System.out.println(writer.connectAndCapitalizeWords("najlepszy", "kurs"));
    }

    private static Writer createWriter() {
        return new Writer(new Letters());
    }
}
