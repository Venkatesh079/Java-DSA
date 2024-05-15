package designpatterns.creational.singleton;

public class DemoSingletonMultiThread {

    public static void main(String[] args) {
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

//    static class ThreadFoo implements Runnable {
//        public void run()
//        {
//            Singleton singleton = Singleton.getInstance("Foo");
//            System.out.println(singleton.value);
//        }
//    }
//
//    static class ThreadBar implements Runnable {
//        public void run()
//        {
//            Singleton singleton = Singleton.getInstance("Bar");
//            System.out.println(singleton.value);
//        }
//    }
    static class ThreadFoo implements Runnable {
        @Override
        public void run()
        {
            DemoSingletonThreadSafe demoSingletonThreadSafe = DemoSingletonThreadSafe.getInstance("Foo");
            System.out.println(demoSingletonThreadSafe.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run()
        {
            DemoSingletonThreadSafe demoSingletonThreadSafe = DemoSingletonThreadSafe.getInstance("Bar");
            System.out.println(demoSingletonThreadSafe.value);
        }
    }
}
