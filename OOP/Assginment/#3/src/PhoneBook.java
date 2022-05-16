import java.util.Scanner;

class Phone {
    private String name;
    private String tel;

    public Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }
}

public class PhoneBook {
    private Phone[] phones;
    private int num;

    private void setPhones(Phone[] phones) {
        this.phones = phones;
    }

    public void setNum(int num) {
        this.num = num;
        this.setPhones(new Phone[num]);
    }

    public int getNum() {
        return num;
    }

    public void addPhone(int index, Phone phone) {
        this.phones[index] = phone;
    }

    public Phone isValidSearch(String name) {
        for (Phone p: phones) {
            if (name.equals(p.getName())) {
                return p;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PhoneBook phoneBook = new PhoneBook();

        System.out.print("인원수 >> ");
        phoneBook.setNum(scanner.nextInt());

        for(int i=0; i<phoneBook.getNum(); i++){
            System.out.print("이름과 전화번호(이름과 번호는 빈 칸 없이 입력)>>");
            String name = scanner.next();
            String tel = scanner.next();
            phoneBook.addPhone(i, new Phone(name, tel));
        }

        System.out.println("저장되었습니다...");
        
        while (true) {
            System.out.print("검색할 이름>>");
            String search = scanner.next();

            if (search.equals("그만"))
                break;

            try {
                Phone p = phoneBook.isValidSearch(search);
                System.out.println(p.getName()+"의 번호는 "+ p.getTel()+ " 입니다.");
            } catch (NullPointerException e) {
                System.out.println(search+"가 없습니다.");
            }
        }

        scanner.close();
    }
}
