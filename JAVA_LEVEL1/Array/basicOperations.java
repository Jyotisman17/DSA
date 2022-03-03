package PEP.JAVA_LEVEL1.Array;

public class basicOperations {
    public static void reversefully(int[] arr){
        int i=0;
        int j=arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public static void reverse(int[] arr,int i,int j){
        while(i<j){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }

    public static void rotate(int[] arr,int rotateBy){
        rotateBy=rotateBy%arr.length;
        if(rotateBy<0)rotateBy+=arr.length;
        reverse(arr,0,arr.length-rotateBy-1);
        reverse(arr,arr.length-rotateBy,arr.length-1);
        reversefully(arr);
    }

    public static int[] inverse(int[] arr) {
        int[] inv = new int[arr.length];
        for(int i=0;i< arr.length;i++){
            int v=arr[i];
            inv[v]=i;
        }
        return inv;
    }

    public static void display(int[] arr){
        for(int i:arr) System.out.println(i);
    }

    public static void printAllSubarray(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // 1 2 3 4 5
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++)
                    System.out.print(arr[k] + " ");
                System.out.println();
            }
        }
    }

    public static void printAllSubset(int[] arr){
        int limit = (int)Math.pow(2,arr.length);
        String set = "";
        for(int i1=0;i1<limit;i1++){
            int i=i1;
            //convert i to binary and use 0 and 1 whether to print the element or not
            set="";
            for(int j=arr.length-1;j>=0;j--){ // here in this loop we will convert to binary
                int r=i%2;
                i/=2;
                if(r==0){
                    set="-\t"+set;
                }
                else{
                    set=arr[j]+"\t"+set;
                }
            }
            System.out.println(set);
        }
    }

    public static int binarySearch(int[] arr,int k){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid = start+end/2;
            if(arr[mid]==k){
                return mid;
            }else if(arr[mid]>k){
                end=mid-1;
            }else if(arr[mid]<k){
                start=mid+1;
            }
        }
        return -1;
    }
    public static void ceilFloor(int[] arr,int k){
         int lo = 0;
         int ceil=0;
         int floor = 0;
         int hi = arr.length-1;
        while (lo <=hi) {
            int mid = lo+(hi-lo)/2;
            if(k<arr[mid]){
                ceil=arr[mid];
                hi=mid-1;
            }
            else if (k>arr[mid]){
                floor=arr[mid];
                lo = mid+1;
            }
            else{
                ceil=arr[mid];
                floor=arr[mid];
                break;
            }
        }
        System.out.println("Ceil = "+ceil+" Floor is = "+floor);
    }

    public static void firstLastIndex(int[] arr,int data){
        int lo= 0;
        int hi=arr.length-1;
        int firstIndex = -1;
        while (lo <= hi) {
            int mid=lo+(hi-lo)/2;
            if(data>arr[mid]){
                lo=mid+1;
            }else if(data<arr[mid]){
                hi=mid-1;
            }else{
                firstIndex=mid;
                hi=mid-1;
            }
        }
        System.out.println("First Index : "+firstIndex);
        lo= 0;
        hi=arr.length-1;
        int lastindex = -1;
        while (lo <= hi) {
            int mid=lo+(hi-lo)/2;
            if(data>arr[mid]){
                lo=mid+1;
            }else if(data<arr[mid]){
                hi=mid-1;
            }else{
                lastindex=mid;
                lo=mid+1;
            }
        }
        System.out.println("Last Index : "+lastindex);

    }



    public static void main(String[] args) {
//        int[] arr = {1,2,3};
//        printAllSubset(arr);
//        printAllSubarray(arr);

//        reverse(arr);


        int[] arr = {10,10,10,20,20,20,20,20,30,30};
        firstLastIndex(arr,20);

//        ceilFloor(arr,100);


//        int result = binarySearch(arr,8);
//        if(result==-1){
//            System.out.println("Element is not found");
//        }else{
//            System.out.println("Element is found at index : "+result);
//        }
//        rotate(arr,-2);
//        for(int i:arr) System.out.print(i+" ");

//        int[] arr={1,2,3,4,0}; // in place of arr[0] it is 1 , so put at arr[1]=0
//        int[] ans = inverse(arr);
//        display(ans);
    }
}
