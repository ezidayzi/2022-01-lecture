package Exam_etc;

public class StringReverse {
    public static void main(String a[]){
        String s="hello world";
        StringBuilder tmp= new StringBuilder();
        for(int i=0;i<s.length();++i) {
           tmp.append(s.charAt(s.length() - i - 1));
        }
        System.out.println(tmp);
    }
}
