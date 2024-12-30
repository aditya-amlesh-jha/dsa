/**
 * Implementation of Bubble Sort
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 * Idea: bubble out the max element to the end of the array
 */

import java.util.*;

public class SortingAlgorithm<T extends Comparable<T>> {

    public void bubbleSort(List<T> arr){
        int n = arr.size();
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                if(arr.get(j).compareTo(arr.get(j+1)) > 0){
                    T temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }
            }
        }
    }

    public void selectionSort(List<T> arr){
        int n = arr.size();
        for(int i=0;i<n;i++){
            int minElement = i;
            for(int j=i;j<n;j++){
                if(arr.get(j).compareTo(arr.get(minElement)) < 0){
                    minElement = j;
                }
            }

            T temp = arr.get(i);
            arr.set(i, arr.get(minElement));
            arr.set(minElement, temp);
        }
    }

    public void insertionSort(List<T> arr){
        int n = arr.size();

        for(int i=1;i<n;i++){
            T key = arr.get(i);
            int j = i-1;
            while(j>=0 && arr.get(j).compareTo(key) > 0){
                arr.set(j+1, arr.get(j));
                j -= 1;
            }
            arr.set(j+1, key);
        }
    }

    public void printList(List<T> arr){
        System.out.println(arr);
    }

    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>(Arrays.asList(64, 34, 25, 12, 22, 11, 90));
        SortingAlgorithm<Integer> sort = new SortingAlgorithm<>();
//        sort.bubbleSort(arrList);
//        sort.selectionSort(arrList);
        sort.insertionSort(arrList);
        sort.printList(arrList);
    }
}