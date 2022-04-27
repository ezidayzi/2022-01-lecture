package main;

import config.AppContext;

import dto.ModifyRequest;
import dto.RegisterRequest;
import entity.User;
import exception.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import printer.UserInfoPrinter;
import printer.UserListPrinter;
import service.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static AnnotationConfigApplicationContext ctx = null;
    private static final Scanner scan = new Scanner(System.in);

    // 로그인된 User 를 저장
    private static User loggedInUser = null;

    public static void main(String[] args) {
        ctx = new AnnotationConfigApplicationContext(AppContext.class);

        System.out.println("어떤 서비스를 원하세요?");
        menu();

        int input;

        while (true) {
            System.out.print("메뉴를 입력하세요. (0~8) >> ");

            try {
                input = scan.nextInt();
                if (!(input >= 0 && input <= 8)) {
                    System.out.println("0~8 사이 숫자만 입력해주세요.");
                }

                scan.nextLine();
                printLine();

                if (input == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    printLine();
                    break;
                }

                // 1) 회원가입
                if (input == 1) {
                    System.out.println("회원가입");
                    printLine();
                    requestRegisterUser();
                }

                // 2) 로그인
                if (input == 2) {
                    System.out.println("로그인");
                    printLine();
                    requestLogin();
                }

                // 3) 암호 재설정
                if (input == 3) {
                    System.out.println("암호 재설정");
                    printLine();
                    requestResetPassword();
                }

                // 4) 암호 변경
                if (input == 4) {
                    System.out.println("암호 변경");
                    printLine();
                    requestChangePassword();
                }

                // 5) 회원 정보 조회
                if (input == 5) {
                    System.out.println("회원 정보 조회");
                    printLine();
                    requestUserInfo();
                }

                // 6) 회원 정보 수정
                if (input == 6) {
                    System.out.println("회원 정보 수정");
                    printLine();
                    requestModifyUserInfo();
                }

                // 7) 회원 탈퇴
                if (input == 7) {
                    System.out.println("회원 탈퇴");
                    printLine();
                    requestWithdrawal();
                }

                // 8) 메뉴 출력
                if (input == 8) {
                    menu();
                    printLine();
                }

            }
            catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("0~8 사이 숫자만 입력해주세요.");
                try {
                    exitService("프로그램");
                } catch (ExitServiceException err) {
                    System.out.println(err.getMessage());
                    return;
                }
           }
        }
    }

    // 구분선 출력 함수
    private static void printLine() {
        System.out.println("==============================================================");
    }

    // 현재 로그인된 User 의 정보를 프린트하는 함수
    private static void printLoggedInUserInfo() {
        if (loggedInUser == null) {
            System.out.println("로그인 상태가 아닙니다.");
            return;
        }
        System.out.println("로그인된 계정 : " + loggedInUser.getId());
    }

    // 메뉴 목록 출력 함수
    private static void menu() {
        System.out.println("0: 프로그램 종료");
        System.out.println("1: 회원가입");
        System.out.println("2: 로그인");
        System.out.println("3: 암호 재설정");
        System.out.println("4: 암호 변경");
        System.out.println("5: 회원 정보 조회");
        System.out.println("6: 회원 정보 수정");
        System.out.println("7: 회원 탈퇴");
        System.out.println("8: 서비스 메뉴 다시 보기");
    }

    // 서비스 종료 처리 함수
    private static void exitService(String name) {
        System.out.print(">>>> 계속하려면 \"0\"을 입력하세요.\n>>>> 서비스 종료를 원하시면 \"0\" 이외의 키를 입력해주세요.\n>>>> ");
        try {
            String input = scan.nextLine();
            printLine();
            if (!input.equals("0")) {
                throw new ExitServiceException(name);
            }
        } catch (InputMismatchException ignored) {
            throw new ExitServiceException(name);
        }
    }

    // 회원가입 처리 함수
    private static void requestRegisterUser() {
        RegisterUserService service = ctx.getBean(RegisterUserService.class);

        // 등록 요청 객체 생성
        RegisterRequest req = new RegisterRequest();

        /*
        아이디 입력
         */
        while (true) {
            System.out.print("아이디 >> ");
            String id = scan.nextLine();

            try {
                //  아이디가 유효한 경우에만 req 객체에 저장
                service.isValidId(id);
                req.setId(id);
                break;
            }catch (DuplicateUserException | InvalidIdException e) {
                System.out.println(e.getMessage());
                try {
                    exitService("회원 가입");
                } catch (ExitServiceException err) {
                    System.out.println(err.getMessage());
                    return;
                }
            }
        }

        /*
        암호 입력
         */
        while (true) {
            System.out.print("암호 입력 >> ");
            String password = scan.nextLine();

            try {
                // 유효한 비밀번호인 경우에만 통과
                service.isValidPassword(password);
            } catch (InvalidPasswordException e) {
                System.out.println(e.getMessage());
                try {
                    exitService("회원 가입");
                    continue;
                } catch (ExitServiceException err) {
                    System.out.println(err.getMessage());
                    return;
                }
            }

            System.out.print("암호 확인 >> ");
            String confirmPassword = scan.nextLine();

            try {
                // 같은 비밀번호 인 경우에만 통과
                service.isPasswordEqualToConfirmPassword(password, confirmPassword);
            } catch (WrongPasswordException e) {
                System.out.println(e.getMessage());
                try {
                    exitService("회원 가입");
                    continue;
                } catch (ExitServiceException err) {
                    System.out.println(err.getMessage());
                    return;
                }
            }

            // 에러에 걸리지 않은 경우 req 에 암호 저장
            req.setPassword(password);
            break;
        }

        /*
        이메일 입력
         */
        while (true) {
            System.out.print("이메일 입력 >> ");
            String email = scan.nextLine();
            try {
                // 유효한 이메일인 경우에만 통과
                service.isValidEmail(email);
                req.setEmail(email);
                break;
            } catch (InvalidEmailException e) {
                System.out.println(e.getMessage());
                try {
                    exitService("회원 가입");
                } catch (ExitServiceException err) {
                    System.out.println(err.getMessage());
                    return;
                }
            }
        }

        /*
        전화번호 입력
         */
        while (true) {
            System.out.print("전화번호 입력 (\"-\" 을 포함하여 입력) >> ");
            String phone = scan.nextLine();
            try {
                // 유효한 전화번호인 경우에만 통과
                service.isValidPhoneNumber(phone);
                req.setPhone(phone);
                break;
            } catch (InvalidPhoneNumberException e) {
                System.out.println(e.getMessage());
                try {
                    exitService("회원 가입");
                } catch (ExitServiceException err) {
                    System.out.println(err.getMessage());
                    return;
                }
            }
        }

        /*
        이름 입력
         */
        while (true) {
            System.out.print("이름 입력 >> ");
            String name = scan.nextLine();

            // 빈칸이 입력되지 않은 경우에만
            if (!name.isEmpty()) {
                req.setName(name);
                break;
            }
        }

        // 정상적으로 회원가입시 가입된 유저의 아이디 출력
        System.out.println(service.register(req)+"님 회원가입되셨습니다.");
        printLine();
    }

    // 로그인 처리 함수
    private static void requestLogin() {
        // 로그인 된 유저 초기화
        loggedInUser = null;

        UserLoginService svc = ctx.getBean(UserLoginService.class);
        String id, password;

        while (true) {
            // 아이디 입력
            System.out.print("아이디 입력 >> ");
            id = scan.nextLine();

            // 비밀번호 입력
            System.out.print("비밀번호 입력 >> ");
            password = scan.nextLine();

            try {
                // 유효한 로그인일 경우에만 통과
                loggedInUser = svc.login(id, password);
                System.out.println(id+"님 반갑습니다. 로그인되었습니다.");
                printLine();
                break;
            } catch (NoUserException | WrongPasswordException e) {
                System.out.println(e.getMessage());
                try {
                    exitService("로그인");
                } catch (ExitServiceException err) {
                    System.out.println(err.getMessage());
                    return;
                }
            }
        }
    }

    // 비밀번호 초기화 처리 함수
    private static void requestResetPassword() {
        ResetPasswordService repository = ctx.getBean(ResetPasswordService.class);

        String id;

        while (true) {
            System.out.print("가입된 아이디 입력 >> ");
            id = scan.nextLine();

            System.out.print("가입된 이메일 입력 >> ");
            String email = scan.nextLine();

            System.out.print("가입된 전화번호 입력 >>");
            String phone = scan.nextLine();

            try {
                // 유효한 정보일 경우에만 통과
                repository.resetPassword(id, email, phone);
                System.out.println("초기화되었습니다.");
                printLine();
                break;
            } catch (NoUserException | WrongInfoException e) {
                System.out.println(e.getMessage());
                try {
                    exitService("비밀번호 재설정");
                } catch (ExitServiceException err) {
                    System.out.println(err.getMessage());
                    return;
                }
            }
        }

        while (true) {
            System.out.print("새로운 비밀 번호 입력 >> ");
            String newPassword = scan.nextLine();

            System.out.print("새로운 비밀 번호 확인 >> ");
            String confirmPassword = scan.nextLine();

            try {
                // 유효한 암호인 경우에만 통과
                repository.registerNewPassword(id, newPassword, confirmPassword);
                System.out.println("암호가 변경되었습니다.");
                printLine();
                break;
            } catch (InvalidPasswordException | WrongPasswordException e) {
                System.out.println(e.getMessage());
                try {
                    exitService("비밀번호 재설정");
                } catch (ExitServiceException err) {
                    System.out.println(err.getMessage());
                    return;
                }
            }
        }
    }

    // 비밀번호 변경 함수
    private static void requestChangePassword() {
        ChangePasswordService repository = ctx.getBean(ChangePasswordService.class);

        while (true) {
            System.out.print("아이디 입력 >> ");
            String id = scan.nextLine();

            System.out.print("기존 비밀번호 입력 >> ");
            String oldPassword = scan.nextLine();

            System.out.print("새로운 비밀번호 입력 >> ");
            String newPassword = scan.nextLine();

            try {
                // 올바른 정보인 경우에만 통과
                repository.changePassword(id, oldPassword, newPassword);
                System.out.println("비밀번호가 변경되었습니다.");
                printLine();
                break;
            } catch (NoUserException | WrongPasswordException e) {
                System.out.println(e.getMessage());
                try {
                    exitService("비밀번호 변경");
                } catch (ExitServiceException err) {
                    System.out.println(err.getMessage());
                    return;
                }
            }
        }
    }

    // 회원 정보 조회 함수
    private static void requestUserInfo() {
        UserInfoPrinter infoPrinter = ctx.getBean(UserInfoPrinter.class);
        UserListPrinter userListPrinter = ctx.getBean(UserListPrinter.class);

        int input;
        while (true) {
            try {
                System.out.print("회원 리스트 조회 : 0, 특정 회원 조회 : 1, 서비스 종료 : 2 >> ");
                input = scan.nextInt();
                scan.nextLine();
                printLine();

                switch (input) {
                    case 0:
                        // 회원 리스트 조회
                        userListPrinter.print();
                        break;
                    case 1:
                        // 특정 회원 조회
                        System.out.print("회원 아이디 입력 >> ");
                        String id = scan.nextLine();
                        infoPrinter.print(id);
                        break;
                    case 2:
                        try {
                            exitService("회원 정보 조회");
                        } catch (ExitServiceException err) {
                            System.out.println(err.getMessage());
                            return;
                        }
                    default:
                        System.out.println("0, 1, 2 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("0, 1, 2 을 입력해주세요.");
            }
            catch (NoUserInfoException e) {
                System.out.println(e.getMessage());
                try {
                    exitService("회원 정보 조회");
                } catch (ExitServiceException err) {
                    System.out.println(err.getMessage());
                    return;
                }
            }
        }
    }

    // 회원 정보 수정 함수
    private static void requestModifyUserInfo() {
        ModifyUserInfoService service = ctx.getBean(ModifyUserInfoService.class);

        ModifyRequest req = new ModifyRequest();

        String id;

        while (true) {
            System.out.print("가입된 아이디 입력 >> ");
            id = scan.nextLine();

            System.out.print("가입된 이메일 입력 >> ");
            String email = scan.nextLine();

            System.out.print("가입된 전화번호 입력 >> ");
            String phone = scan.nextLine();

            try {
                // 유효한 User 인 경우에만 통과
                service.isValidUser(id, email, phone);
                System.out.println("인증되었습니다.");
                printLine();
                break;
            } catch (WrongInfoException e) {
                System.out.println(e.getMessage());
                try {
                    exitService("회원 정보 변경");
                } catch (ExitServiceException err) {
                    System.out.println(err.getMessage());
                    return;
                }
            }
        }

        // 회원 인증된 상태여야만 가입정보 변경 가능

        System.out.println("가입 정보를 변경합니다. 변경할 사항이 없으면 엔터키를 입력하세요.");

        while (true) {
            System.out.print("새로운 이메일 입력 >> ");
            String email = scan.nextLine();

            if (email.isEmpty()) {
                System.out.println("이메일 정보를 변경하지 않습니다.");
                req.setEmail(null);
                break;
            } else {
                try {
                    // 유효한 이메일인 경우에만 통과
                    service.isValidEmail(email);
                    req.setEmail(email);
                    break;
                } catch (InvalidEmailException e) {
                    System.out.println(e.getMessage());
                    try {
                        exitService("회원 정보 변경");
                    } catch (ExitServiceException err) {
                        System.out.println(err.getMessage());
                        return;
                    }
                }
            }
        }

        while (true) {
            System.out.print("새로운 전화번호 입력 (\"-\" 을 포함하여 입력) >>");
            String phone = scan.nextLine();
            if (phone.isEmpty()) {
                System.out.println("핸드폰 번호 정보를 변경하지 않습니다.");
                req.setPhone(null);
                break;
            } else {
                try {
                    // 유효한 전화번호인 경우에만 통과
                    service.isValidPhoneNumber(phone);
                    req.setPhone(phone);
                    break;
                } catch (InvalidPhoneNumberException e) {
                    System.out.println(e.getMessage());
                    try {
                        exitService("회원 정보 변경");
                    } catch (ExitServiceException err) {
                        System.out.println(err.getMessage());
                        return;
                    }
                }
            }

        }

        System.out.print("새로운 이름 입력 >>");
        String name = scan.nextLine();
        if (name.isEmpty()){
            System.out.println("이름 정보를 변경하지 않습니다.");
            name = null;
        }
        req.setName(name);

        service.modifyInfo(id, req);
        System.out.println("회원 정보 변경을 완료했습니다.");

    }

    // 회원 탈퇴 함수
    private static void requestWithdrawal() {
        DeleteUserService repository = ctx.getBean(DeleteUserService.class);

        // 현재 로그인 상태 정보 출력
        printLoggedInUserInfo();

        if (loggedInUser == null) {
            System.out.println("로그인을 먼저 해주세요.");
            return;
        }

        // 0을 입력한 경우에만 탈퇴 처리
        System.out.print("탈퇴하시겠습니까? (YES:0  NO:1) >> ");

        try {
            int input = scan.nextInt();
            scan.nextLine();

            if (input == 0) {
                // 존재하는 User 만 탈퇴 가능
                repository.deleteUser(loggedInUser);
                loggedInUser = null;
                System.out.println("탈퇴되었습니다.");
            }
            else {
                System.out.println("회원 정보 변경 서비스를 종료합니다.");
            }
        } catch (InputMismatchException ignored) {
            System.out.println("회원 탈퇴 서비스를 종료합니다.");
        }
    }
}
