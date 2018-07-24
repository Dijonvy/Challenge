public char[] replaceSpaces(char[] currentCharacters,int realSize) {
    for (int tracker = realSize - 1, pivot = currentCharacters.length - 1; tracker > -1; tracker--, pivot--) {
        if (currentCharacters[tracker] != 32) {
            currentCharacters[pivot] = currentCharacters[tracker];
        } else {
            currentCharacters[pivot] = '2';
            currentCharacters[pivot-1] = '3';
            currentCharacters[pivot-2] = '&';
            pivot -= 2;
        }
    }

    return currentCharacters;
}