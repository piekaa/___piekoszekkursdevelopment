class StringConverter {

    String toPascalCase(String text) {
        validate(text);

        var nextUpper = true;
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (character != ' ') {
                if (nextUpper) {
                    result.append(Character.toUpperCase(character));
                } else {
                    result.append(character);
                }
                nextUpper = false;
            } else {
                nextUpper = true;
            }
        }
        return result.toString();
    }

    private void validate(String text) {

    }

}
