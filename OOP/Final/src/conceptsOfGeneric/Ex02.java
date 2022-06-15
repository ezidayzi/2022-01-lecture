package conceptsOfGeneric;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {
    public <E> void m0(List<E> L, E e) {
        L.add(e);
    }
    public <E> void m1(List<? extends E> L, E e){
//        L.add(e); // 컴파일 에러
    }
    public <E> void m2(List<? super E> L, E e) {
        L.add(e);
    }
    public void m3(List L, Object e) {
        L.add(e);
    }

    public <E> void m4(List<E> L, E e) {}
    public <E> void m5(List<? extends E> L, E e) {}
    public <E> void m6(List<? super E> L, E e) {}
    public void m7(List L, Object e) {}


    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Hello");
        list.add(1);
        String s = (String) list.get(0); // 강제형변환 안해주면 컴파일 에러남

        List<String> list2 = new ArrayList<String>(); //String 외의 다른 파일 들어오면 컴파일 에러
        list = list2;
        list2.add("hello");
//        list2.add(1); // 컴파일 에러
        String s2 = list2.get(0); // cast 필요 없음

        Ex02 ex = new Ex02();
//        ex.m4(new ArrayList<String>(), new Object());
//        ex.m5(new ArrayList<String>(), new Object());
//        ex.m6(new ArrayList<String>(), new Object());
        ex.m7(new ArrayList<String>(), new Object());
    }
}
