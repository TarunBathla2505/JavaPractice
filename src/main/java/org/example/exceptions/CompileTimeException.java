package org.example.exceptions;

public class CompileTimeException {

    // handling exception using try catch block
    public static void main(String[] args) {
        try {
            method1();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        method2();
    }

    private static void method1() throws ClassNotFoundException {
        // here arithmetic exception doesn't give compile time error but ClassNotFound is giving bcoz of which we have to use throws in method
        throw new ClassNotFoundException();
    }

//    we can write it like this too and handle the exception in the function itself
    private static void method2() {
        // here arithmetic exception doesn't give compile time error but ClassNotFound is giving bcoz of which we have to use throws in method
        try{
            throw new ClassNotFoundException();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
