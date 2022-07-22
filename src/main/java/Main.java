public class Main {

    public static void main(String[] args) {

        System.out.println("Powinno być: ");
        System.out.println("aaa\naaa");

        System.out.println("Jest: ");
        System.out.println(new TextDrawer().drawRectangle(3, 2, 'a'));
    }
}
