package kunal;

import java.util.Scanner;

public class Sum {

    static void sum() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int no1 = in.nextInt();
        System.out.print("Enter the second number: ");
        int no2 = in.nextInt();

        int Sum = no1 + no2 ;
        System.out.println("The sum is: " + Sum);

    }
    public static void main(String[] args) {
        sum();
    }
}

