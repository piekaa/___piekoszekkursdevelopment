class Letters {

    String capitalize(String word) {
        var firstLetter = word.charAt(0);
        var firstLetterUpperCase = Character.toUpperCase(firstLetter);
        return firstLetterUpperCase + word.substring(1);
    }
}
