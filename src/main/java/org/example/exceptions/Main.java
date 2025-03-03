package org.example.exceptions;

//These are run time exception
public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        obj.method1();
    }
    private void method1(){
//        index out of bound exception
        int[] arr= new int[4];
        arr[4]=5;
        method2();
    }
    private void method2(){
//        class cast exception
        Object val = 0;
        System.out.println((String) val);
        method3();
    }
    private void method3(){
//        arithmetic exception
        int b = 5/0;
        method4();
    }

    private void method4() {
//        null pointer exception
        String str = null;
        str.charAt(4);
        method5();
    }
    private void method5() {
//        illegal argument exception
        int val = Integer.parseInt("abc");
    }


}
