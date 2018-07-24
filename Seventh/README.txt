We will use the "Stack" structure to do the verification on the Singly Linked List backwards always comparing the references of both last Nodes on the top of the Stack and remove it from each Stack related to Linked List until one (or both) Stack get empty.
It takes the size of the Linked Lists to create the Stacks (lets call as "n" for first Linked List and "m" for second Linked List). It takes Max(n,m).
With the Stacks ready, we start to iterate on both in parallel until we get the intersection Node or any Stack gets empty. It takes Max(n,m).
Taking the considerations listed previously, the code should have complexity of "Max(n,m) + Max(n,m)". 

The complexity of this method is O(Max(n,m)).