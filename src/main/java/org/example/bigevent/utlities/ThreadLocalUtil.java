package org.example.bigevent.utlities;

public class ThreadLocalUtil {

    private static ThreadLocal THREAD_Local = new ThreadLocal();
    public static <T> T get() {
       return (T) THREAD_Local.get();
    }
    public static void set(Object o) {
        THREAD_Local.set(o);
    }
    public static void remove() {
        THREAD_Local.remove();
    }
}
