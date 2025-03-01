package org.example.annotations.predefined.repetation;

public class Main {
    public static void main(String[] args) {
        Eagle eagle = new Eagle();
        Category[] annotations = eagle.getClass().getAnnotationsByType(Category.class);
        for (Category annotation:annotations)
            System.out.println(annotation.name());
    }
}
