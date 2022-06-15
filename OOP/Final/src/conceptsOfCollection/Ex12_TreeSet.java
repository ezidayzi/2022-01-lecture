package conceptsOfCollection;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Ex12_TreeSet {
    public static void main(String[] args) {
        /*
        부모 인터페이스: set
        특징-hashcode, equals 이미 오버라이딩 되어있음
         */
        TreeSet<Integer> nums = new TreeSet<Integer>();
        nums.add(8);
        nums.add(17);
        nums.add(6);
        nums.add(15);
        nums.add(4);
        // 알아서 정렬해줌

        for (int num: nums)
            System.out.print(num + "\t");
        System.out.println();

        Iterator<Integer> iter = nums.descendingIterator(); // 내림차순 형태 원본은 그대로인데 순회만 내림차순
        while (iter.hasNext())
            System.out.print(iter.next()+"\t");
        System.out.println();

        NavigableSet<Integer> rangeSubset = nums.subSet(5, true, 15, true);
        for(int num : rangeSubset) System.out.print(num + "\t");
        System.out.println();

        // 포인터만 뒤집엇 보여줌, 실제 객체는 건드리지 않음
        // descSet에서 삭제시 실제 객체 요소도 삭제됨
        NavigableSet<Integer> descSet = nums.descendingSet();
        for(int num: descSet) System.out.print(num+"\t");
        System.out.println();

        NavigableSet<Integer> ascSet = descSet.descendingSet();
        for(int num: ascSet) System.out.print(num+"\t");
        System.out.println();

        System.out.println("lowest: " + nums.first()); // 가장 작은 첫 번째 요소 반환
        System.out.println("highest: " + nums.last()); // 가장 큰 요소 반환
        System.out.println("greatest in < param: " + nums.lower(20));
        System.out.println("least in > param: " + nums.higher(20));
        System.out.println("greatest in <= param: " + nums.floor(20));
        System.out.println("least in >= param: " + nums.ceiling(20));
        System.out.println("retrieve & remove the lowest: " + nums.pollFirst()); // 첫번째 요소 삭제
        System.out.println("retrieve & remove the highest: " + nums.pollLast()); // 맨마지막 요소 삭제

        for (int num: nums)
            System.out.print(num + "\t");
    }
}
/*
4	6	8	15	17
17	15	8	6	4
6	8	15
17	15	8	6	4
4	6	8	15	17
lowest: 4
highest: 17
greatest in < param: 17
least in > param: null
greatest in <= param: 17
least in >= param: null
retrieve & remove the lowest: 4
retrieve & remove the highest: 17
6	8	15
 */
