package ro.mirodone;

import java.util.function.Consumer;

public class TestClass {

    public static void main(String[] args) {



        Consumer<String> c1 = s -> System.out.println(s.toUpperCase());
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("consumer");


    }
}
