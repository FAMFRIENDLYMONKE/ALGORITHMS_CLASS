import java.util.*;
class QuickSort{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Random r = new Random();
        for(int i = 0; i<n; i++){
            arr[i] = r.nextInt(32767);
        }
        long time = analyze(arr);
        sc.close();
        System.out.println(time);
        for(int i =0; i<n; i++){
            System.out.print(arr[i]+" ");
        }

    }
    public static long analyze(int[] arr){
        long start = System.nanoTime();
        quicksort(arr, 0, arr.length-1);
        long stop = System.nanoTime();
        return stop-start;
    }

    public static void quicksort(int[] A, int p, int r){
        if(p<r){
            int q = partition(A, p, r);
            quicksort(A, p, q-1);
            quicksort(A, q+1, r);
        }
    }

    public static int partition(int[] A, int p, int r){
        int x = A[r];
        int i = p-1;
        for(int j = p; j < r; j++){
            if(A[j] <= x){
                i = i+1;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        int tmp = A[i+1];
        A[i+1] = A[r];
        A[r] = tmp;
        return i+1;
    }
    
}
