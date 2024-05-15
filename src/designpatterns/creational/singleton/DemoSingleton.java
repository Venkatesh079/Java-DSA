package designpatterns.creational.singleton;

public class DemoSingleton {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("Foo") ;
        Singleton newSingleton = Singleton.getInstance("Bar") ;
        System.out.println(singleton.value);
        System.out.println(newSingleton.value);
    }
}
