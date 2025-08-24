package com.jabaddon.java.learning.reflection;

import com.jabaddon.java.learning.reflection.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class App {

    public static void main(String[] args) {
        String packageName = "com.jabaddon.java.learning.reflection.example";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        List<Class<?>> classes = new ArrayList<>();
        try {
            Enumeration<URL> resources = classLoader.getResources(path);
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                System.out.println(resource);
                System.out.println(resource.getProtocol());
                String filePath = resource.getFile();
                List<Class<?>> directoryClasses = getClassesInDirectory(packageName, filePath);
                classes.addAll(directoryClasses);
            }
//            Class<?>[] classes = classLoader.loadClass(packageName) getDeclaredClasses();
//            for (Class<?> cls : classes) {
//                Annotation annotation = cls.getAnnotation(RestController.class);
//                if (annotation != null) {
//                    System.out.println("Found @RestController: " + cls.getName());
//                }
//                Field[] fields = cls.getDeclaredFields();
//                for (Field field : fields) {
//                    annotation = field.getAnnotation(RestController.class);
//                    if (annotation != null) {
//                        System.out.println("Found @RestController: " + cls.getName() + "." + field.getName());
//                    }
//                }
//                Method[] methods = cls.getDeclaredMethods();
//                for (Method method : methods) {
//                    annotation = method.getAnnotation(RestController.class);
//                    if (annotation != null) {
//                        System.out.println("Found @RestController: " + cls.getName() + "." + method.getName());
//                    }
//                }
//            }
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            throw new RuntimeException(e);
        }

        for (Class<?> aClass : classes) {
            Annotation annotation = aClass.getAnnotation(RestController.class);
            if (annotation != null) {
                System.out.println("Found @RestController: " + aClass.getName());
            }
        }
    }

    public static List<Class<?>> getClassesInDirectory(String packageName, String directoryPath) {
        List<Class<?>> classes = new ArrayList<>();
        try {
            var directory = new File(directoryPath);
            if (!directory.exists()) {
                return classes;
            }
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursively search subdirectories
                    String subPackageName = packageName + "." + file.getName();
                    String subDirectoryPath = file.getAbsolutePath();
                    List<Class<?>> subDirectoryClasses = getClassesInDirectory(subPackageName, subDirectoryPath);
                    classes.addAll(subDirectoryClasses);
                } else if (file.getName().endsWith(".class")) {
                    // Add class to list if it is a concrete class (not abstract or interface)
                    String className = packageName + "." + file.getName().replace(".class", "");
                    Class<?> clazz = Class.forName(className);
                    if (!clazz.isInterface() && !Modifier.isAbstract(clazz.getModifiers())) {
                        classes.add(clazz);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

}