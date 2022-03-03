package PEP.Basics;

import java.util.Arrays;
import java.util.Collections;

public class inbuiltSortArr {
    public static void main(String[] args) {
        int []arr={43,45,2,3,62,123,61,1,12,53};
        System.out.println("Before Sort : "+ Arrays.toString(arr));
        //using inbuilt parallel sort method
//      Arrays.parallelSort(arr);

        //using Arrays.sort
        Arrays.sort(arr);
        System.out.println("After Sort : "+ Arrays.toString(arr));

        //Sorting in Descending order


        Integer []a={234,62,243,13,52,25};
        System.out.println("Before Sort : "+ Arrays.toString(a));
        //Arrays.sort(a,Collections.reverseOrder());
        Arrays.parallelSort(a,Collections.reverseOrder());
        System.out.println("After Sort : "+ Arrays.toString(a));


    }
}
