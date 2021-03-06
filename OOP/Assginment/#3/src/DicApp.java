import java.util.Scanner;

class Dictionary {
    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] eng = {"love", "baby", "money", "future", "hope"};

    public static String kor2Eng(String word) {
        for (int i = 0; i<kor.length; i++) {
            if (word.equals(kor[i])) {
                return eng[i];
            }
        }
        return null;
    }
}

public class DicApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("한글 단어 검색 프로그램입니다.");

        while (true) {
            System.out.print("한글 단어?");
            String search = scanner.next();

            if (search.equals("그만"))
                break;

            try {
                String result = Dictionary.kor2Eng(search);
                if (result == null)
                    throw new RuntimeException(search + "은/는 저의 사전에 없습니다.");

                System.out.println(search+"은/는 "+result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}