package org.example.annotations.usedefined;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Repeatable(Categories.class)  // provide container to store multiple entries
@Retention(RetentionPolicy.RUNTIME)
public @interface Category {

    String name();
}
