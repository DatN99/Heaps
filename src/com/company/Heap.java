package com.company;

/**
 * This class implements a max heap.
 *
 * Searching for the next available spot is O(1) since the next available spot is stored as int size
 * Searching for a specific value is O(N) time since all values are iterated over to find the right one
 *
 * Insertion takes O(1) time as the value is inserted automatically at the end of the list
 * Up_heapify takes O(log N) time as average/worst-case as it is common for the newly inserted value to have to
 * traverse through all nodes until the root is reached. In other words, it can also be said that the time complexity is
 * O(H) where H is the height, but it can also be written as O(log N) where N is the number of nodes
 *
 * For example, is the heap is 1 node, the height is 0. For up_heapify, the time complexity would be O(H) = O(0) = O(log 1).
 * If the heap has 8 nodes, the height is 3. For up_heapify, the time complexity would be O(H) = O(3) = O(log 8).
 *
 * Deletion takes O(1) time as the value is deleted and replaced with no iteration required and is therefore independent of N
 * Down_heapify takes O(log N) time as the average/worst-case as it is somewhat common for the replacement node to have to traverse
 * down the list until the tree follows the heap properties. The time complexity of deletion is more dependent on the
 * height of the node that was deleted. It can be also described similarly to up_heapify's time complexity
 */

public class Heap {

    private int[] array = new int[30];
    private static int size = 0;

    public void insert(int val){
        array[size] = val;
        up_heapify(size);
        size++;

    }

    private void up_heapify(int index){
        int parent_index = (index-1)/2;

        if (index == 0 || array[parent_index] > array[index]){
            return;
        }

        else {
            swap(parent_index, index);
            up_heapify(parent_index);
        }

    }

    private void swap(int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }



    public void print(){
        String string = "";

        for (int i = 0; i < size; i ++){
            string += array[i] + ", ";
        }

        System.out.println(string);
    }

    public void delete(int val){
        int index = findIndex(val);

        if (index == -1){
            return;
        }

        else {
            swap(index, size-1);
            array[size-1] = 0;
            down_heapify(index);
        }
    }

    private int findIndex(int val){
        for (int i = 0; i < size; i++){
            if (array[i] == val){
                return i;
            }
        }
        return -1;

    }

    private void down_heapify(int index){
        int left_child = (2*index) +1;
        int right_child = (2*index) +2;

        if (left_child > size-1 && right_child > size-1){
            return;
        }

        else if (right_child > size-1){
            if (array[left_child] > array[index]){
                swap(index, left_child);
            }
        }

        else if (array[index] < array[left_child] || array[index] < array[right_child]){
            int curr_largest = -1;

            if (array[left_child] > array[right_child]){
                curr_largest = left_child;
            }

            else if (array[right_child] > array[left_child]){
                curr_largest = right_child;
            }

            swap(index, curr_largest);
            down_heapify(curr_largest);
        }

    }
}
