package algorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args){
        int searchEl = 10;
        int[] input = {2,0,3,4,7,4,-1,10};
        Arrays.sort(input);

        long start = System.currentTimeMillis();
        int result = new BinarySearchSolution().optimalBinarySearch(input,searchEl);
        System.out.println("Searching "+searchEl+" in "+ Arrays.toString(input)+" : "+result);
        long end = System.currentTimeMillis();
        System.out.println("Program execution time : "+ (end-start)+"ms");

        start = System.currentTimeMillis();
        result = new BinarySearchSolution().binarySearch(input,searchEl);
        System.out.println("Searching "+searchEl+" in "+ Arrays.toString(input)+" : "+result);
        end = System.currentTimeMillis();
        System.out.print("Program execution time : "+ (end-start)+"ms");

    }
}
class BinarySearchSolution{
    public int binarySearch(int[] input, int el){
        int l=0,h=input.length-1;
        while(l<=h){
            int currentIndex = l+(h-l)/2;
            int currentEl = input[currentIndex];
            if(currentEl == el){
               return currentIndex;
            }else if(el < currentEl){
                h=currentIndex-1;
            }else{
                l=currentIndex+1;
            }
        }

        return -1;
    }
    public int optimalBinarySearch(int[] input, int el){
        int l=0,h=input.length-1;
        while(l<=h){
            int index = l + (h-1)/2;
            int currVal = input[index];
            if(currVal<el){
                l=index+1;
            }else if(currVal>el){
                h=index-1;
            }else {
                return index;
            }
        }
        return -1;
    }
}
