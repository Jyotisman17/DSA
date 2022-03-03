package PEP.Basics;

public class maxMinElementInArray {
    public static void main(String[] args) {
        int[] arr ={3,54,32,7,234,123,65,342};
        int max=arr[0],min=arr[0];
        for(int values:arr){
            if(values>max)max=values;
            if(values<min)min=values;
        }
        System.out.println("Maximum value in this array is "+max);
        System.out.println("Minimum value in this array is "+min);

    }
}
