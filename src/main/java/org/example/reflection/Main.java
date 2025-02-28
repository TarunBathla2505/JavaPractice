package org.example.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Class eagleClass = Eagle.class;

        System.out.println(eagleClass.getName());
        System.out.println(Modifier.toString(eagleClass.getModifiers()));


        //gives all the fields of class including public protected and private ones
        System.out.println(Arrays.toString(eagleClass.getDeclaredFields()));
        System.out.println("_____________________________________");

        //return all the public methods of class
        Method[] methods = eagleClass.getMethods();
        for(Method method: methods){
            System.out.println(method.getName());
        }
        System.out.println("_____________________________________");


        //return all public private all the methods of this class
        Method[] declaredMethods = eagleClass.getDeclaredMethods();
        for(Method method: declaredMethods){
            System.out.println(method.getName());
        }
        System.out.println("_____________________________________");

//        we cannot call private methods outside the class but by using reflection we can do it
//        Eagle eagle = new Eagle();
//        eagle.privateMethod();
        Object o = eagleClass.newInstance();
        Method privateMethod = eagleClass.getMethod("publicMethod", int.class, int.class, String.class);
        privateMethod.invoke(o,1,2,"tarun");

//        we can invoke like this too
        for(Method method: declaredMethods){
            if(method.getName() == "privateMethod" && method.getParameterCount()==3){
                method.setAccessible(true);
                method.invoke(o,1,2,"tarun");
            }
        }



        System.out.println("_____________________________________");
//        accessing the fields
        Eagle obj = new Eagle();
        Field breed = eagleClass.getField("breed");
        breed.set(obj,"bird");
        System.out.println(obj.breed);
//        for private fields
        Field canSwim = eagleClass.getDeclaredField("canSwim");
        canSwim.setAccessible(true);
        canSwim.set(obj,true);
        System.out.println(obj.getCanSwim());


        System.out.println("_____________________________________");
//        reflection breaking singleton
        Class<EagleSingleton> eagleSingletonClass = EagleSingleton.class;

        Constructor[] declaredConstructors = eagleSingletonClass.getDeclaredConstructors();
        EagleSingleton eagleSingleton;

        for(Constructor constructor:declaredConstructors){
            constructor.setAccessible(true);
            eagleSingleton = (EagleSingleton)constructor.newInstance();
            eagleSingleton.fly();
        }



    }
}
