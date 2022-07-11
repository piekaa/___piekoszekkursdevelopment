import java.util.Random;

class RandomNumberGenerator {

    private Random random = new Random();

    public int randomInt() {
        return random.nextInt();
    }
}
