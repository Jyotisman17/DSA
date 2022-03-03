package PEP.JAVA_LEVEL1.Two_D_Arrays;

public class exitPoint {
    public static void main(String[] args) {
        int[][] arr = Multiplication.construct2DMatrix();
        int dir = 0;  // 0 : east , 1 : south , 2:wese , 3:north
        int i=0;
        int j=0;
        while(true){
            dir=(dir+arr[i][j])%4;
            if(dir==0){
                j++;
            } else if (dir == 1) {
                i++;
            } else if (dir == 2) {
                j--;
            }else if(dir == 3){
                i--;
            }

            if (i < 0) {
                i++;
                break;
            } else if (j < 0) {
                j++;
                break;
            } else if (i==arr.length) {
                i--;
                break;
            } else if(j==arr[0].length){
                j--;
                break;
            }

        }
        System.out.println(i);
        System.out.println(j);
    }
}
