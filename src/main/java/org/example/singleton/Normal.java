package org.example.singleton;


// Eager Initialization
// already initialized object present even if not used
public class Normal {
    private static final Normal instance = new Normal();

    private Normal(){

    }

    public static Normal getInstance(){
        return instance;
    }
}
