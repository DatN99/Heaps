# Heaps

src/com/company/Heap.java contains a class that implements a max heap and heapsort

Searching for the next available spot is O(1) since the next available spot is stored as int size
Searching for a specific value is O(N) time since all values are iterated over to find the right one

Insertion takes O(1) time as the value is inserted automatically at the end of the list
Up_heapify takes O(log N) time as average/worst-case as it is common for the newly inserted value to have to
traverse through all nodes until the root is reached. In other words, it can also be said that the time complexity is
O(H) where H is the height, but it can also be written as O(log N) where N is the number of nodes
 
For example, is the heap is 1 node, the height is 0. For up_heapify, the time complexity would be O(H) = O(0) = O(log 1).
If the heap has 8 nodes, the height is 3. For up_heapify, the time complexity would be O(H) = O(3) = O(log 8).
 
Deletion takes O(1) time as the value is deleted and replaced with no iteration required and is therefore independent of N
Down_heapify takes O(log N) time as the average/worst-case as it is somewhat common for the replacement node to have to traverse
down the list until the tree follows the heap properties. The time complexity of deletion is more dependent on the
height of the node that was deleted. It can be also described similarly to up_heapify's time complexity


Heapsort takes O(nlogn) time. In other words, it's O(h) = O(nlogn).
For example, for a heap with 8 elements, there will be 3 levels. O(h) = O(3) = O(log8) = 3
For each level, down_heapify is called which takes O(nlogn) time.
In addition, an element swap happens between the first and current last element which takes O(n) time.
Putting it all together, heapsort takes O(nlogn) average/worst case scenario

operations:

insert -> insert a new value onto the heap

up_heapify -> called to correct heap 

print -> prints heap

delete -> deletes value in the heap

findIndex -> returns index of value specified

down_heapify -> called to correct heap

heapsort -> returns a sorted array sorted with heapsort
