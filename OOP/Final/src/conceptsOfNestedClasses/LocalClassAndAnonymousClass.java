package conceptsOfNestedClasses;

public class LocalClassAndAnonymousClass {
    void method() {
        class LocalClass {
            int nonStaticField;
            LocalClass() {}
            void nonStaticMethod() {}

            static int staticField;
            static void staticMethod() {}
        }

    }

    public static void main(String[] args) {
        LocalClassAndAnonymousClass c = new LocalClassAndAnonymousClass();
        c.method();
    }
}
