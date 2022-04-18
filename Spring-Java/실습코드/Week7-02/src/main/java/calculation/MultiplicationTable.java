package calculation;

public class MultiplicationTable {
    int value;

    public void setValue(int value) {
        this.value = value;
    }

    public String makeTable(){
        String table = "=================\n"+value+ " 단 시작 !\n";

        for (int a = 2; a<10; a++) {
            table += a + "x" + value + "=" + a*value + " \n ";
        }
        return table;
    }
}
