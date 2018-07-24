We should iterate the array in parallel updating the end part with the characters of the text based on the "true" size provided. 
When a space is present on support array, we update 3 values in a row and update the "pivot" with the correct value since it will write 3 instead of 1 char.
Since the loop will iterate exactly the "true" size of the array, it has complexity "n".

The complexity of this method is O(n).