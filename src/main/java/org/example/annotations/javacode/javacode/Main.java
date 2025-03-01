package org.example.annotations.javacode.javacode;

import org.example.annotations.predefined.ChildClass;
import org.example.annotations.predefined.MyOwnAnnotation;
import org.example.annotations.predefined.TestClass;

public class Main {

//    we have oracle docs for each warning to supress the warning
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) {
        Mobile mobile = new Mobile();

        mobile.dummyMethod();
        mobile.toString();

        mobile.variableArgument("Tarun","Bathla");


        System.out.println("testing my own annotation while run time");
        // if over annotation i missed giving retention then i will get null in below line
        System.out.println(new TestClass().getClass().getAnnotation(MyOwnAnnotation.class));


        System.out.println("testing @inherited annotaion");
        System.out.println(new ChildClass().getClass().getAnnotation(MyOwnAnnotation.class));

    }

}
