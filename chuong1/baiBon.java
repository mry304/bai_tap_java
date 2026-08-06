package chuong1;

import java.util.Scanner;

public class baiBon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a + b <= c || a + c <= b || c + b <= a)
            System.out.print("k phai tam giac");
        else if(a == b && b == c)
                System.out.print("tam giac deu");
        else if(a == b || a == c || b ==c )
            System.out.print("la tam giac can");
        else
            System.out.println("laf tam giac thuong");
    }
}