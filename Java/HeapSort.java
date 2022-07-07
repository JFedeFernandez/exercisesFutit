public class HeapSort {

    public void sort(int arr[])
    {
        int n = arr.length;
  
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heap(arr, n, i);
  
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
  
            // call max heap on the reduced heap
            heap(arr, i, 0);
        }
    }
  
    // To heap a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heap(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // son left = 2*i + 1
        int r = 2 * i + 2; // son right = 2*i + 2
  
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
  
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
  
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
  
            // Recursively heap the affected sub-tree
            heap(arr, n, largest);
        }
    }
  
    /* Method that shows the elements of the array */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /*Method that accommodates negative numbers to the left
    also counts the occurrences of zeros*/
    public int right(int arr[]){
        int i = 0;
        int j = 0;
        int swap;
        int cant = 0;

        while(arr[j] <= 0){
            j++;
        }

        while(arr[i] != 0){
            i++;
        }
        while(i < j-1 && i < arr.length-1 && j < arr.length){
            swap = arr[i];
            arr[i] = arr[j];
            arr[j] = swap;
            i++;
            j++;
        }

        for(int k = 0; k < arr.length; k++){
            if(arr[k] == 0){
                cant = cant+1;
            }
        }

        return cant;

    }

    // Test code
    public static void main(String args[])
    {
        int arr[] = { 1, 11, 6, 0, 0, 0 ,0, 0,-1,0,-5};
        int n = arr.length;
  
        HeapSort ob = new HeapSort();
        ob.sort(arr);
        int cant = ob.right(arr);
        System.out.println("Sorted array is");
        printArray(arr);
        System.out.println("The number of zeros is");
        System.out.println(cant);
    }

    /*La complejidad de este algoritmo es n*log n 
    ya que el heap es n*log y el metodo right es n*/
}