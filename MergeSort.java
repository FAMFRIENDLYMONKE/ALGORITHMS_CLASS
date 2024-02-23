import java.util.*;

class MergeSort{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Random r = new Random();
        for(int i = 0; i<n; i++){
            arr[i] = r.nextInt(32766);
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

        mergesort(arr, 0, arr.length-1);

        long stop = System.nanoTime();
        return stop-start;
    }

    public static void mergesort(int[] arr, int p, int r){
        if (p<r){
            int q = (p+r)/2;
            mergesort(arr, p, q);
            mergesort(arr, q+1, r);
            merge(arr, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r){  
        int n1 = q-p+1;
        int n2 = r-q;
        int[] a1 = new int[n1+1];
        int[] a2 = new int[n2+1];
        for(int i = 0; i < n1; i++){
            a1[i] = A[p + i];
        }
        for(int j = 0; j < n2; j++){
            a2[j] = A[q + j + 1];
        }
        a1[n1] = 32767;
        a2[n2] = 32767;
        System.out.println();
        for(int j = 0; j < n1; j++)     System.out.print(a1[j]+" ");
        System.out.println();
        for(int j = 0; j < n2; j++)     System.out.print(a2[j]+" ");
        int i = 0;
        int j =0;
        for(int k = p; k < r; k++){
            if(a1[i] <= a2[j]){
                A[k] = a1[i];
                i++;
            }else{
                A[k] = a2[j];
                j++;
            }
        }
    }
}