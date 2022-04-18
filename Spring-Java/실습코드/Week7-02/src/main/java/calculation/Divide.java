package calculation;

public class Divide {
    Value a, b;

    public void setA(Value a) {
        this.a = a;
    }

    public void setB(Value b) {
        this.b = b;
    }

    public double divide() {
        return  a.value/b.value;
    }
}
