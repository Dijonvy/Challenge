To remove the duplicate messages, we will verify which email was already sent and then remove the duplicates during the iteration on the Linked List.
To guarantee we have already passed to a email on thread, we use the "Set" structure. Since the "Set" stores the same value only once, we can search it on the "Set" to confirm if the data is already present on Thread an remove the duplicate. It takes the size of the Linked List to be iterated (lets call it "n") and log(n) to check if it is present on "Set".
Taking the considerations listed previously, the code should have complexity of "n * log(n)".

The complexity of this method is O(n*log(n)).