/*A Binary Heap is a complete Binary Tree which is used to store data efficiently 
to get the max or min element based on its structure.

A complete binary tree is a binary tree in which all the levels are completely filled 
except possibly the lowest one, which is filled from the left.

A full binary tree is a binary tree with either zero or two child nodes for each node. 

A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, 
the key at the root must be minimum among all keys present in Binary Heap. 
The same property must be recursively true for all nodes in Binary Tree. 
Max Binary Heap is similar to MinHeap. */

public class MinHeap {

	public MinHeap(int lenght) {
		heap = new int [lenght];
		size=0;
	}
	private int [] heap;
	private int size;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] input = {80, 50, 55, 76, 22, 90, 3}; 
		MinHeap h = new  MinHeap(input.length);

		for (int i : input) {
			h.insert(i);
		}

		for (int i : h.heap) {
			System.out.print(i+" ");
		}
		System.out.println("");
		for (int i = 0; i < h.heap.length; i++) {
			System.out.print(h.remove()+" ");
		}

	}

	/**
	 * Return the left node 
	 * @param position
	 * @return
	 */
	private int left(int position) {
		return position*2 +1;
	}

	/**
	 * Return the right node
	 * @param position
	 * @return
	 */
	private int right(int position) {
		return position*2 +2;
	}

	/**
	 * return the parent 
	 * @param position
	 * @return
	 */
	private int parent(int position) {
		return position/2;
	}

	/**
	 * leaf element check
	 * @param position
	 * @return
	 */
	private boolean isLeaf(int position) {
		if(position >= (size / 2) && position <= size)
			return true;
		return false;
	}

	/**
	 * Insert a element in heap.
	 * @param i
	 */
	private  void insert(int i) {
		if(size == 0) {
			heap[0] = i;
			size++;
			return;
		}

		heap[size] = i;	
		int current = size;
		while(heap[current]<heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		size++;
	}
	/**
	 * Remove element from min heap. remove the 0th position and replace it with last element .
	 * @return
	 */
	private int remove() {
		int val = heap[0];
		heap[0]=heap[--size];
		heapify(0);
		return val;
	}
	private void swap(int i, int j) 
	{ 
		int tmp; 
		tmp = heap[i]; 
		heap[i] = heap[j]; 
		heap[j] = tmp; 
	} 

	private void heapify(int position) {
		if(isLeaf(position)){
			return;
		}

		if(heap[position]>heap[left(position)]) {
			swap(position,left(position));
			heapify(left(position));
		}

		if(heap[position]>heap[right(position)]) {
			swap(position,right(position));
			heapify(right(position));
		}
	}

}