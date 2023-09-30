import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Create an array of random integers
        int[] unsorted = createArray(1000);
        
        int[] unsorted2 = unsorted;
        int[] unsorted3 = unsorted;
        for(int i=0; i<unsorted.length; i++)
        {
        	unsorted2[i] = unsorted[i];
        	unsorted3[i] = unsorted[i];
        }
        

        // Sort the array using bubble sort
        bubbleSort(unsorted);

        // Sort the array using selection sort
        selectionSort(unsorted2);
        
        insertionSort(unsorted3);
    }

    //fills an array with provided length with int
    public static int[] createArray(int length) {
        // Generate random integers
        Random value = new Random();

        // Create an array of specified length
        int[] array = new int[length];

        // Fill the array with random integers
        for (int i = 0; i < length - 1; i++) {
            array[i] = value.nextInt();
        }

        return array;
    }
    //performs bubble sort on array
    //does not return sorted array
    public static void bubbleSort(int[] array) {
    	long start = System.nanoTime();
    	int temp = 0;

        // Outer loop for # passes
        for (int i = 0; i < array.length - 1; i++) {
            // Inner loop for comparisons
            for (int j = 0; j < array.length - 1 - i; j++) {
                // Compare adjacent elements and swap if necessary
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println(" a random array size of " + array.length + " took Bubble Sort " + timeElapsed + " ns to complete.");
    }
    //performs selection sort on array
    //does not return sorted array
    public static void selectionSort(int[] array) {
    	long start = System.nanoTime();
        int lowestValueIndex = 0;
        int temp = 0;

        // Outer loop for # passes
        for (int i = 0; i < array.length - 1; i++) {
            lowestValueIndex = i;

            // Inner loop to find the minimum element
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[lowestValueIndex]) {
                    lowestValueIndex = j;
                }
            }

            // Swap the minimum element with the current element
            temp = array[i];
            array[i] = array[lowestValueIndex];
            array[lowestValueIndex] = temp;
        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println(" a random array size of " + array.length + " took Selection Sort " + timeElapsed + " ns to complete.");
        
    }
    public static void insertionSort(int[] array)
    {
    	long start = System.nanoTime();
    	//how many times to run
    	for(int i = 1; i<array.length; i++)
    	{
    		int j=i;
    		//performs swaps until value no longer smaller
    		while(array[j] < array[j-1] && j>0)
    		{
    			int temp = array[j];
    			array[j] = array[j-1];
    			array[j-1] = temp;
    			j--;
    		}
      	}
    	long finish = System.nanoTime();
        long timeElapsed = finish - start;
    	System.out.println(" a random array size of " + array.length + " took Insertion Sort " + timeElapsed + " ns to complete.");
    }
}