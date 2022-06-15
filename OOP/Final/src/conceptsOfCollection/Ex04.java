package conceptsOfCollection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Ex04 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Orange", "Mango","Strawberry");
        /*
        list.add("Pear");
        list.remove("Orange");
        런타임 에러
        Arrays.asList로 만든 리스트는 고정사이즈이다.
        내부적으로 String[4]와 같음
         */
        print(list.toArray(new String[0]));
        // list 를 array로 바꾸는 메소드
        var list2 = list.toArray(new String[0]);
        // String[] 타입임을 주의하자

        list = new ArrayList<>(list);

        ListIterator<String> litr = list.listIterator();

        //forward
        /*
        정방향 순회는 중간에 요소가 추가도어도 litr에 반영되지 않는다.
         */
        while (litr.hasNext()) {
            String str = litr.next();
            System.out.print(str+"\t");

            if(str.equals("Orange"))
                litr.add("After_Orange");
        }
        System.out.println();

        //backwards
        while (litr.hasPrevious()) {
            String str = litr.previous();
            System.out.print(str+"\t");

            if(str.equals("Mango"))
                litr.add("Before_Mango");
        }
        System.out.println();

        for(String str: list)
            System.out.print(str+"\t");
        System.out.println();

    }

    private static void print(String... vargs) {
        for (int i = 0; i < vargs.length; i++)
            System.out.println(vargs[i]);
    }
}
/*
Apple	Orange	Mango	Strawberry
Strawberry	Mango	Before_Mango	After_Orange	Orange	Apple
Apple	Orange	After_Orange	Before_Mango	Mango	Strawberry
 */
