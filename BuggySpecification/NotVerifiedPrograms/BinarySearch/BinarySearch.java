public class BinarySearch {
    //@ requires \forall int j; 0 <= j && j < arr.length; \forall int i; 0 <= i && i < j ;arr[i] <= arr[j];
    //@ ensures \result == -1 <==> (\forall int i; 0 <= i && i < arr.length; arr[i] != key) || arr.length == 0;
    //@ ensures 0 <= \result && \result < arr.length ==> arr[\result] == key;
    public static int Binary(int[] array, int key) {
            int low = 0;
            int high = array.length;
            int mid =  high / 2;
            //@ maintaining 0 <= low && low <= high  && high <= arr.length && mid == low + (high - low) / 2;
            //@ maintaining (\forall int i; 0 <= i && i < low; arr[i] < key);
            //@ maintaining (\forall int i; high <= i && i < arr.length; key < arr[i]);
            //@ decreases high - low;
            while (low < high && array[mid] != key) {
                if (array[mid] < key) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
                mid = low + (high - low) / 2;
            }
            if (low >= high) {
                return -1;
            }
            return mid;
        }
}