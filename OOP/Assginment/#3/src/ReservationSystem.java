import java.util.Scanner;

class Seat {
    private int grade;
    private int number;
    private String name;

    private String getEmptySeat() {
        return "---";
    }

    public Seat(int grade, int number, String name) {
        this.setGrade(grade);
        this.setNumber(number);
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            this.name = getEmptySeat();
        }
    }
}

class Concert {
    private String[] gradeInfo = {"S", "A", "B"};
    private Seat[][] seats;

    Concert() {
        this.seats = new Seat[3][10];
        for (int grade  = 0; grade<seats.length; grade++) {
            for (int seatNumber = 0; seatNumber<seats[grade].length; seatNumber++) {
                seats[grade][seatNumber] = new Seat(grade, seatNumber, null);
            }
        }
    }

    private void setBookerInfo(int grade, int seatNumber, String name) {
        Seat seat = seats[grade][seatNumber];
        seat.setGrade(grade);
        seat.setNumber(seatNumber);
        seat.setName(name);
    }

    private String getBookerInfo(int grade, int seatNumber) {
        return getSeat(grade, seatNumber).getName();
    }

    private Seat getSeat(int grade, int number) {
        return seats[grade][number];
    }

    public void printAllSeatsInfo() {
        for (int i = 0; i < seats.length; i++) {
            printSeatsInfoInGrade(i);
        }
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }

    public void printSeatsInfoInGrade(int grade) {
        System.out.print(gradeInfo[grade]+">> ");
        for (Seat seat: seats[grade]) {
            System.out.print(seat.getName()+" ");
        }
        System.out.println();
    }

    public void book(int grade, int seatNumber, String name) {
        setBookerInfo(grade, seatNumber, name);
    }

    public void cancel(int grade, String name) {
        boolean isValid = false;
        for (int seatNumber = 0; seatNumber < seats[grade].length; seatNumber++) {
            if (name.equals(getBookerInfo(grade, seatNumber))) {
                setBookerInfo(grade, seatNumber, null);
                isValid = true;
            }
        }

        if (!isValid) {
            throw new RuntimeException("없는 이름입니다.");
        }
    }
}

public class ReservationSystem {
    static Scanner scanner = new Scanner(System.in);
    private static void printCommandMessage() {
        System.out.print("예약: 1, 조회: 2, 취소: 3, 끝내기: 4>>");
    }

    private static int getGrade() {
        System.out.print("좌석구분 S(1), A(2), B(3)>>");
        return scanner.nextInt()-1;
    }

    private static int getSeatNumber() {
        System.out.print("번호>>");
        return  scanner.nextInt()-1;
    }

    private static String getName() {
        System.out.print("이름>>");
        return scanner.next();
    }

    public static void main(String[] args) {

        System.out.println("명품콘서트 홀 예약 시스템입니다.");
        Concert concert = new Concert();

        while (true) {
            printCommandMessage();
            int num = scanner.nextInt();
            try {

                if (num == 1) {
                    int grade = getGrade();
                    concert.printSeatsInfoInGrade(grade);

                    String name = getName();
                    int seatNumber = getSeatNumber();

                    concert.book(grade, seatNumber, name);
                }
                else if (num == 2) {
                    concert.printAllSeatsInfo();
                }

                else if (num == 3) {
                    int grade = getGrade();
                    concert.printSeatsInfoInGrade(grade);

                    String name = getName();

                    concert.cancel(grade, name);
                } else if (num == 4) {
                    break;
                }
                else {
                    throw new RuntimeException("1~4 번으로 입력해주세요.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("해당 번호가 존재하지 않아 ");
                if(num == 1) {
                    System.out.println("예약할 수 없습니다.");
                } else if(num == 2) {
                    System.out.println("조회할 수 없습니다.");
                } else if (num == 3) {
                    System.out.println("취소할 수 없습니다.");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}

