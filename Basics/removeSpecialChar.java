package PEP.Basics;

public class removeSpecialChar {
    public static void main(String[] args) {
        String str = "@#@!#$%^&%#$$#@  Jyotisman Behera ";
//        str=str.replace("man","");
//        str=str.replaceAll("[^a-zA-Z0-9 @]","");
        str=str.replaceAll("\\s",""); // to remove all the white space

        System.out.println(str);
    }
}
