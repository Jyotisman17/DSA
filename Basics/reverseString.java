package PEP.Basics;

public class reverseString {
    public static void main(String[] args) {

        String string = "ABCD";
        //using +(concatenation operator)

//        String revString = "";
//        int len=string.length()-1;
//        while(len>=0){
//            revString+=string.charAt(len--);
//        }

        //using character array

//        char ch[] = string.toCharArray();
//        int len = ch.length-1;
//        while(len>=0) System.out.print(ch[len--]);

        //using direct charAt funciton

//        int len = string.length()-1;
//        while (len>=0){
//            System.out.print(string.charAt(len--));
//        }

        //using StringBuffer class

        StringBuffer sb = new StringBuffer(string);
        System.out.println(sb.reverse());



    }
}
