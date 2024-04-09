// APPROACH-1

public class Ques1 {

    /**
     * Approach:
     * This method uses a two-step process to find the index of the first occurrence of -1 in the array:
     * 1. Exponential Search: It starts with a step size of 1 and doubles the step size iteratively
     * until it finds a value of -1 or goes beyond the bounds of the array. Once -1 is found or the
     * bounds are exceeded, it narrows down the search space using binary search between the last known
     * non -1 index and the upper bound where -1 was found. If we get an IndexOutOfBoundsException, it 
     * means we've gone too far and we need to reduce the step size by half and we decrease the index by
     * this step size.
     * 
     * 2. Binary Search: After finding the upper bound where -1 is located, it performs a binary search
     * between the last known non -1 index and the upper bound to find the exact index of the first
     * occurrence of -1.
     *
     * @param arr The array of integers where the index of -1 is to be found.
     * @return The index of the first occurrence of -1.
     */

        public static int findIndexOfMinusOne(int[] arr) {
            int step = 1;
            int index = 0;
    
            while (true) {
                try {
                    if (arr[index] == -1) {
                        break;
                    }
                    index += step;
                    step *= 2; 
                } catch (IndexOutOfBoundsException e) {
                    step /= 2;
                    index -= step;
                }
            }
    
            int left = index / 2;
            int right = index;
            while (left <= right) {
                int mid = (left + right) / 2;
                try {
                    if (arr[mid] == -1 && (mid == 0 || arr[mid - 1] != -1)) {
                        return mid;
                    } else if (arr[mid] != -1) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } catch (IndexOutOfBoundsException e) {
                    right = mid - 1;
                }
            }
    
            return -1;
        }
    
        public static void main(String[] args) {
            // For array having -1 with a 
            int[] largeArray = new int[1007];
            System.arraycopy(new int[]{3, 4, 1, 2, 7, 8, 20, 33}, 0, largeArray, 0, 8);
            for (int i = 8; i < 1007; i++) {
                largeArray[i] = -1;
            }
            System.out.println("The index of the first occurrence of -1 is: " + findIndexOfMinusOne(largeArray));
    
            // For an array starting with -1
            int[] arrayAllMinusOne = new int[1000];
            for (int i = 0; i < 1000; i++) {
                arrayAllMinusOne[i] = -1;
            }
            System.out.println("The index of the first occurrence of -1 is: " + findIndexOfMinusOne(arrayAllMinusOne));
            
            // For an array starting with -1 at first index
            int[] arrayMinusOneAtFirstIndex = new int[1000];
            for (int i = 0; i < 1000; i++) {
                arrayMinusOneAtFirstIndex[i] = -1;
            }
            arrayMinusOneAtFirstIndex[0] = 321;
            System.out.println("The index of the first occurrence of -1 is: " + findIndexOfMinusOne(arrayMinusOneAtFirstIndex));
        }
}


// APPROACH-2


public class Ques1 {
    
    /**
     * Approach:
     * This method iterates through the array linearly until it finds the first occurrence of -1.
     *
     * @param arr The array of integers where the index of -1 is to be found.
     * @return The index of the first occurrence of -1.
     */

    public static int findIndexOfMinusOne(int[] arr) {
        int index = 0;
        while (true) {
            if (arr[index] == -1) {
                return index;
            }
            else index++;
        }
    }
    
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 1, 2, 7, 8, 20, 33, -1, -1, -1, -1};
        System.out.println("The index of the first occurrence of -1 is: " + findIndexOfMinusOne(array));

        int[] arrayAllMinusOne = new int[]{-1, -1, -1, -1};
        System.out.println("The index of the first occurrence of -1 is: " + findIndexOfMinusOne(arrayAllMinusOne));
    }
}