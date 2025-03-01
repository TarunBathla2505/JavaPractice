package org.example.annotations.javacode.javacode;

public class Mobile {

    @Deprecated
    public void dummyMethod(){
        //something
    }

    @Deprecated
    public void dummyMethod2(){
        //something
    }

    @Override
    public String toString() {
        return "this is Mobile Object";
    }

    @SafeVarargs
    public final void variableArgument(String... args){
        // something
        for (String i: args){
            System.out.println(i);
        }
    }
}
