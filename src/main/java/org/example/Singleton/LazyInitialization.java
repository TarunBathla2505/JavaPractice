package org.example.Singleton;


//this is example of lazy initialization as in normal we already have object in this we create object only when needed

//Issue with this:  not good for multi threaded systems as its not thread safe
public class LazyInitialization {

    private static LazyInitialization instance;

    private LazyInitialization(){

    }

    public static LazyInitialization getInstance(){
        if(instance == null){
            instance = new LazyInitialization();
        }
        return instance;
    }
}
