import java.lang.*;

public boolean isZeroOrOneTypoAway(String firstWord, String secondWord) {
    int firstWordSize = firstWord.length();
    int secondWordSize = secondWord.length();
    int difference = Math.abs(firstWordSize - secondWordSize);
    if(difference > 1) {
	return false;
	}
    int typosCounter = 0;
    for(int tracker=0,pivot=0; tracker<firstWordSize && pivot<secondWordSize; tracker++,pivot++) {
        if (firstWord.charAt(tracker) != secondWord.charAt(pivot)) {
            typosCounter++;
            if (typosCounter > 1) return false;
            if ((firstWordSize > secondWordSize) && (firstWord.charAt(tracker+1) == secondWord.charAt(pivot))) pivot--;
            else if ((firstWordSize < secondWordSize) && (firstWord.charAt(tracker) == secondWord.charAt(pivot+1))) tracker--;
        }
    }

    if(difference == 1 && firstWord.charAt(firstWordSize-1) != secondWord.charAt(secondWordSize-1)) {
        typosCounter++;
        if(typosCounter > 1) return false;
    }

    return true;
}