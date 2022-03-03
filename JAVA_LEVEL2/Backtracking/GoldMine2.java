package PEP.JAVA_LEVEL2.Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class GoldMine2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        getMaxGold(arr);
        System.out.println(max);
    }
    static int max = 0;
    public static void getMaxGold(int[][] arr){
        boolean[][] visited = new boolean[arr.length][arr[0].length]; // visited array
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(!visited[i][j] && arr[i][j]!=0){
                    ArrayList<Integer> bag = new ArrayList<>();
                    travelAndCollect(arr,i,j,visited,bag);

                    int sum = 0;
                    for(int val:bag)sum+=val;
                    if(sum>max)max=sum;
                }
            }
        }

    }

    public static void travelAndCollect(int[][] arr,int i,int j,boolean[][] visited,ArrayList<Integer> bag){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j] == 0 || visited[i][j]){
            return;
        }
        bag.add(arr[i][j]);
        visited[i][j]=true;
        travelAndCollect(arr,i,j-1,visited,bag); // west
        travelAndCollect(arr,i,j+1,visited,bag); // east
        travelAndCollect(arr,i+1,j,visited,bag); // south
        travelAndCollect(arr,i-1,j,visited,bag); // North

    }
}
