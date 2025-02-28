package org.example.reflection;

public class Eagle {

    public String breed;
    private boolean canSwim;


    public boolean getCanSwim(){
        return this.canSwim;
    }

    public void fly(){
        System.out.println("fly");
    }

    public void eat(){
        System.out.println("eat");
    }

    private void privateMethod(){
        System.out.println("this is private");
    }

    private void privateMethod(int a, int b, String c){
        System.out.println("this is private");
    }

    public void publicMethod(int a,int b,String c){
        System.out.println("this is public");
    }
}
