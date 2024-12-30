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

//    height of tree is log2(n) --> n = 2^0 + 2^1 + 2^2 + ... + 2^h
//    n = 2^(h+1) - 1
//    h = log2(n+1) - 1
//    for each level, we have to do n operations
//    So, time complexity is O(nlogn)
//    Space complexity is O(n)

    public void mergeSort(List<T> arr, int low, int high){
        if(low >= high){
            return;
        }
        int mid = low + (high - low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);

//        Now merge

        List<T> tempArr = new ArrayList<>();
        int i = low, j = mid + 1;

        while(i<=mid && j<=high){
            if(arr.get(i).compareTo(arr.get(j)) < 0){
                tempArr.add(arr.get(i));
                i+=1;
            }
            else{
                tempArr.add(arr.get(j));
                j+=1;
            }
        }

        while(i<=mid){
            tempArr.add(arr.get(i));
            i+=1;
        }

        while(j<=high){
            tempArr.add(arr.get(j));
            j+=1;
        }

        for(int k=low;k<=high;k++){
            arr.set(k, tempArr.get(k-low));
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
//        sort.insertionSort(arrList);
//        sort.mergeSort(arrList, 0, arrList.size()-1);
        sort.printList(arrList);
    }
}