enum GuessResponse {

    TOO_HIGH ("too high"),
    TOO_LOW ("too low"),
    CORRECT("correct");

    public final String text;

    GuessResponse(String text) {
        this.text = text;
    }
}
