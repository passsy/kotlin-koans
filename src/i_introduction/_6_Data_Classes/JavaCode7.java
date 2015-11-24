package i_introduction._6_Data_Classes;

import util.JavaCode;

public class JavaCode7 extends JavaCode {

    public static class Person {

        private final int age;

        private final String name;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}
