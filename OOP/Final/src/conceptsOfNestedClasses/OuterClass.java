package conceptsOfNestedClasses;

public class OuterClass {
    static  int staticField;
    int instanceField;

    static void staticMethod() {

    }

    void instanceMethod() {

    }

    class InnerClass {
        int instanceField;
        void instanceMethod() {}
        void method() {
            OuterClass.staticField = 1;
            instanceField = 0;
            OuterClass.this.instanceField = 0;
            OuterClass.staticMethod();
            instanceMethod();
            OuterClass.this.instanceMethod();
        }
    }

    static class StaticNestedClass {
        static int staticField;
        int instanceField;

        static void staticMethod() {

        }
        void instanceMethod() {

        }
        void method() {
            staticField = 1;
            OuterClass.staticField = 1;
            staticMethod();
            instanceMethod();
        }
    }
}
