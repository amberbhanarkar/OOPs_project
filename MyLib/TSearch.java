package MyLib;
public class TSearch {
    int search(int[] array, int l, int r, int x) {
        if (r >= l) {
            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;
            if (array[mid1] == x)
                return mid1;
            if (array[mid2] == x)
                return mid2;
            if (x < array[mid1])
                return search(array, l, mid1 - 1, x);
            else if (x > array[mid2])
                return search(array, mid2 + 1, r, x);
            else
                return search(array, mid1 + 1, mid2 - 1, x);
        }
        return -1;
    }
}
