We should check if the sum of typos is higher than 1 for this case. Based on the rules described on question, the verification is separeted in 2 main parts: Verify if the size difference of the 2 words is higher than 1 and check how much typos it has of refactor/insert/remove.
The first part only need to get the absolute difference value between the 2 provided words. It takes only a constant value (lets call it "a").
The second part need to iterate on the 2 Strings in parallel to compare their chars and identify the amount of typos that they have. since it should iterate on both at the same time and we adjust the tracker/pivot size in case one word is bigger than the other, the complexity of this loop is Max(n,m), where "n" is the size of the first word and "m" is the size of the second word.
Taking the considerations listed previously, the code should have complexity of "a + Max(n,m)". 

Since "a" constant, the complexity of this method is O(Max(n,m)).