package conceptsOfCollection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Orange");
        list.add("Mango");

        for (int num = 0; num < list.size(); num++) {
            System.out.println(list.get(num));
        }

        for (String str: list) {
            System.out.println(str);
        }

        // 위에꺼 컴파일 되면 아래와 같은 모양으로 나타남
        for (Iterator<String> i = list.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }
    }
}
