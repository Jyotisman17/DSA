package PEP.Basics;

import java.util.Random;

public class generateRandomNumber {
    public static void main(String[] args) {

        // by using Random class
        Random random = new Random();
        int num = random.nextInt();
        System.out.println(num);

        // by using Math.random method
        System.out.println(Math.random());

        // by using Apache commons-lang API
        //http://commons.apache.org/
        //String rand_int = RandomStringUtils.randomNumeric(10);
        //It will create a 10 digits random number


    }
}
