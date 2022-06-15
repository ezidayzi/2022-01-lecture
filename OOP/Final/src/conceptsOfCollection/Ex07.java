package conceptsOfCollection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex07 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"Apple", null, "Orange", "Mango", null, "Strawberry"});
        // list: null가능, 중복가능, 순서 존재
        // asList: 추가 삭제 불가

        for(String str: list)
            System.out.print(str+"\t");
        System.out.println();

        Set<String> set = new HashSet<>(list); // 집합객체 -> 순서가 보장되지 않음
        set.add("Strawberry");
        set.add(null);

        for (String str: set)
            System.out.print(str+"\t");

    }
}
/*
Apple	null	Orange	Mango	null	Strawberry
null	Apple	Strawberry	Mango	Orange
 */