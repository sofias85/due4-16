//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int[] generateRandomArray(int size, int min, int max) {
        int[] randomNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            int randomNum = min + (int)(Math.random() * ((max - min) + 1));
            randomNumbers[i] = randomNum;
        }
        return randomNumbers;
    }




    public static int binarySearch(int[] sortedArray, int valueToFind) {
        int low = 0;
        int high = sortedArray.length - 1;




        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = sortedArray[mid];




            if (midVal < valueToFind) {
                low = mid + 1;
            } else if (midVal > valueToFind) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;




            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);




            merge(array, left, middle, right);
        }
    }




    private static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, middle + 1, R, 0, n2);
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }


        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }




    public static void main(String[] args){
        int size = 10;
        int max = 100;
        int min = 1;
        int[] randomNumbers = generateRandomArray(size, min, max);
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }
        mergeSort(randomNumbers,1,100);
        binarySearch(randomNumbers, 3);
    }
}

