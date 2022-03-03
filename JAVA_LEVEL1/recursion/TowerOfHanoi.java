package PEP.JAVA_LEVEL1.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        printTowerOfHanoi(3,'A','B','C');
    }
    public static void printTowerOfHanoi(int n,char a,char b,char c){
        if(n==0)return;
        printTowerOfHanoi(n-1,a,c,b);
        System.out.println(n+"["+a+"->"+b+"]");
        printTowerOfHanoi(n-1,c,b,a);
    }
}
