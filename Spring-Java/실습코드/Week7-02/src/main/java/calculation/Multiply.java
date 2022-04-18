package calculation;

public class Multiply {
    Value a, b;

    public void setA(Value a) {
        this.a = a;
    }

    public void setB(Value b) {
        this.b = b;
    }

    public double multiply() {
        return  a.value*b.value;
    }
}
