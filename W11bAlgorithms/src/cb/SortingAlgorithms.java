package cb;

public class SortingAlgorithms {
	 
    public SortingAlgorithms() {}
    
    static void bubbleSort(int[] array) {
        
        int l=array.length;
        int temp=0;
        
        for(int i=0;i<l;i++) {
            for(int j=1;j<(l-i);j++) {
                if(array[j-1]>array[j]) {
                    temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }
    }
    
    
    public static void selectionSort (int numbers[]) {
    	int i, j;
    	int min, temp;
    	
    	for (i = 0; i < numbers.length; i++) {
    		min = i;
    		for (j = i + 1; j < numbers.length; j++) {
    			if (numbers[j] < numbers[min])
    				min = j;
    		}
    		temp = numbers[i];
    		numbers[i] = numbers[min];
    		numbers[min] = temp;
    	}
    }
    
    public static void insertionSort(char[] data) {
		int n = data.length;
		for (int k = 1; k < n; k++) {					// begin with second character
			char cur = data[k];							// time to insert cur = data[k]
			int j = k;									// find correct index j for cur
			while (j > 0 && data[j - 1] > cur) {		// thus, data[j-1] must go after cur
				data[j] = data[j - 1];					// slide data[j-1] rightward
				j--;									// and consider previous j for cur
			}
			data[j] = cur;								// this is the proper place for cur
		}
	}
    
    
    public static void mergeSort (int numbers[], int temp[], int left, int right) {
    	int i, j, k;
    	if (left == right)
    		return;
    	int mid = (left + right) / 2;
    	mergeSort(numbers, temp, left, mid);
    	mergeSort(numbers, temp, mid + 1, right);
    	
    	for (i = left; i <= right; i++)
    		temp[i] = numbers[i];
    	
    	for (i = left, j = mid + 1, k = left; i <= mid && j <= right && k <= right; k++) {
    		if (temp[i] < temp[j]) {
    			numbers[k] = temp[i];
    			i++;
    		} else {
    			numbers[k] = temp[j];
    			j++;
    		}
    	}
    	
    	while (i <= mid) {
    		numbers[k] = temp[i];
    		i++;
    		k++;
    	}
    	
    	while (j <= right) {
    		numbers[k] = temp[j];
    		j++;
    		k++;
    	}
    }
    
    public static void main(String[] args) {
 
        int[] Array =new int[100000];
        for(int i=0;i<100000;i++) {
            Array[i]=(int)(Math.random() * 300000);
            //System.out.println(Array[i]);
        }
        
        
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
 
        bubbleSort(Array);
        selectionSort(Array);
        mergeSort(Array);
        
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println(timeTaken);
        
        /*for(int k=0;k<Array.length;k++) {
            
            System.out.print(Array[k]+",");
        }*/
 
    }
}