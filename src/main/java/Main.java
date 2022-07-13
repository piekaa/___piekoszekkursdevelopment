public class Main {

    public static void main(String[] args) {

        System.out.print("Powinno być: ");
        System.out.println(11);

        System.out.print("       Jest: ");
        System.out.println(new FileSpaceCounter().countSpaces("sample.txt"));
    }
}
