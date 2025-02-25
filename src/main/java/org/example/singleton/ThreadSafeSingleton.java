package org.example.singleton;

// good example for lazyinitialization using double checked locking and synchronized keyword
// still a little slow as synchronization happens with locking and unlocking
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){}

    public static ThreadSafeSingleton getInstance(){
        if(instance == null){
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
