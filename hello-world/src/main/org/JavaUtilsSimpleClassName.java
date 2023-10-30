package org;

public class JavaUtilsSimpleClassName {

    public static void main(String[] args) {
        System.out.println(getSimpleName(JavaUtilsSimpleClassName.class));
    }

    private static String getSimpleName(Class<?> clazz) {
        return clazz.getSimpleName();
    }


}
