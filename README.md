# ReturnKthToLast
Exercise related with Linked Lists.

## Exercise Challenge
Implement an algorithm to find the to last element of a singly linked list.
Note that we have defined K such that passing in K = 1 would return the last element, K = 2 would return to the second to last element, and so on.

### Solution 1: Iteratively
Basically I have 2 pointers (fast and slow). Fast first goes to the Kth element (creating a distance between fast and slow of k elements). 
Then both of them move at the same pace until fast reaches the end of the linked list. Since fast and slow were separated by K elements, when fast reaches the and, slow is in the kth element to the end, so we return slow. 
This takes O(N) time and O(1) space.

### Solution 2: Recursively
In this solution I implemented the following: first of all, I create a wrapper class for the index since in Java we can't pass arguments as a reference to a primitive type. 
Then I implement the recursion functions. First I do de "base" function in where I declare the index and then I call the recursive function with the head node, k and idx. 
In the recursion function, the condition to stop is when we reach the end (head == null). Then, I declare a node and assign it to the call of the same function passing head.next (in this way we go to the end of the list). 
Once we've reached the end, we hit the stop condition and begin to return values. In the return process, every time we increment by one idx, so we can count how many node backwards we are. 
The first return we do is a null node, so we are going to be returning null nodes until idx == k (which means we already returned null nodes until reaching the node we want to return, the kth to the end). 
When idx == k, we return the head of its "iteration", and since in any other iteration we won't have idx == k, we are going to be returning the node we actually want until we finish. 
This algorithm takes O(N) time and space due to the recursion calls.