abstract class PairMap {
    protected String[] keyArray;
    protected String[] valueArray;
    abstract String get(String key);
    abstract void put(String key, String value);
    abstract String delete(String key);
    abstract int length();
}

class Dictionary extends PairMap {
    private int length;

    @Override
    String get(String key) {
        for(int i = 0; i < keyArray.length; i++) {
            if (key.equals(keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    void put(String key, String value) {
        for (String k : keyArray) {
            if (key.equals(k)) {
                return; // 중복된 것이 있으면 추가하지 않고 함수 종료
            }
        }
        keyArray[length] = key;
        valueArray[length] = value;
        length++;
    }

    @Override
    String delete(String key) {
        int deletedIndex = -1;
        String value = null;

        for(int i=0; i<length; i++) {
            if(key.equals(keyArray[i])) {
                value = valueArray[i];
                deletedIndex = i;
                break;
            }
        }
        if (deletedIndex != -1) {
            for (int i = deletedIndex + 1; i < length; i++) {
                valueArray[i - 1] = valueArray[i];
                keyArray[i-1] = keyArray[i];
            }
            valueArray[length-1] = null;
            keyArray[length-1] = null;
            length--;
        }

        return value;
    }

    @Override
    int length() {
        return this.length;
    }

    Dictionary(int length) {
        this.keyArray = new String[length];
        this.valueArray = new String[length];
        this.length = 0;
    }

}

public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이썬");
        dic.put("이재문", "C++");
//        System.out.println(dic.length()); // 2 출력
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        dic.delete("황기태");
//        System.out.println(dic.length()); // 1 출력

        System.out.println("황기태의 값은 " + dic.get("황기태"));

        /*
        존재하지 않는 key로 요소를 삭제하는 경우
        출력 결과: null
         */
//        var d = dic.delete("황기태");
//        System.out.println(d);
    }
}