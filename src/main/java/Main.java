import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GuesserGame guesserGame = new GuesserGame(new RandomNumberGenerator(), 100);
        GuessResponse response;
        do {
            response = guesserGame.guess(scanner.nextInt());
            System.out.println(response.text);
        } while (response != GuessResponse.CORRECT);
    }
}
