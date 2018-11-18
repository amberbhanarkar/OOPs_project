package MyLib;
public class BinaryHeap {
    int[] harr;
    int capacity;
    int heap_size;

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return (2 * i + 1);
    }

    public int right(int i) {
        return (2 * i + 2);
    }

    public int getMin() {
        return harr[0];
    }

    public BinaryHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }

    public void insert(int v) {
        if (heap_size == capacity) {
            System.out.println("Overflow: Could not insert Key");
            return;
        }
        heap_size++;
        int i = heap_size - 1;
        harr[i] = v;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            harr[parent(i)] = swap(harr[i], harr[i] = harr[parent(i)]);
            i = parent(i);
        }
    }

    public void decreaseKey(int i, int new_val) {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            harr[parent(i)] = swap(harr[i], harr[i] = harr[parent(i)]);
            i = parent(i);
        }
    }

    public int extractMin() {
        if (heap_size <= 0)
            return Integer.MAX_VALUE;
        if (heap_size == 1) {
            heap_size--;
            return harr[0];
        }
        int root = harr[0];
        harr[0] = harr[heap_size - 1];
        heap_size--;
        MinHeapify(0);

        return root;
    }

    public void delete(int k) {
        decreaseKey(k, Integer.MIN_VALUE);
        extractMin();
    }

    public void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i])
            smallest = l;
        if (r < heap_size && harr[r] < harr[smallest])
            smallest = r;
        if (smallest != i) {
            harr[smallest] = swap(harr[i], harr[i] = harr[smallest]);
            MinHeapify(smallest);
        }
    }

    public int swap(int x, int y) {
        return x;
    }
}
