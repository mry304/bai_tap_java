package chuong1;

import java.util.Scanner;

public class baiNam {
    public static  int fib(long n){
        if(n == 1 || n == 1) return 1;
        long fib1 = 0, fib2 = 1, fib;
        for(int i = 2; i <= 92; ++i){
            fib = fib1 + fib2;
            if(fib == n) return 1;
            fib1 = fib2;
            fib2 = fib;
        }
        return  0;
    }
  public static void main(String[] args) {
      int rs = fib(21);
      if(rs == 1) System.out.println("true");
      else System.out.println("false");
  }
}