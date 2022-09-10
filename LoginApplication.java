import java.util.Scanner;

public class LoginApplication {

    private static User[] accountArray = new User[10];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("1. 회원가입 2. 로그인 3. 사용자조회 4. 탈퇴 5. 종료");
            System.out.print("선택: ");

            int selectNo = scanner.nextInt();

            if (selectNo == 1) {
                createAccount();
            } else if (selectNo == 2) {
                doLogin();
            } else if (selectNo == 3) {
                accountList();
            } else if (selectNo == 4) {
                withdraw();
            } else if (selectNo == 5) {
                run = false;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
    private static void createAccount() {    //1번 회원가입
        System.out.println("회원가입 하세요");
        System.out.print("id: ");
        String id = scanner.next();
        System.out.print("password: ");
        String password = scanner.next();
        System.out.print("nickname: ");
        String nickname = scanner.next();

        if (accountCheck(id)) {
            System.out.println("회원가입이 안됩니다.");
            return;
        }

        User newUser = new User(id, password, nickname);
        for (int i = 0; i < accountArray.length; i++) {
            if (accountArray[i] == null) {
                accountArray[i] = newUser;
                System.out.println("회원가입이 완료되었습니다.");
                System.out.println("   ");
                return;
            }
        }
    }
    private static boolean accountCheck(String id) {
        for (User value : accountArray) {
            if (value != null && value.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private static void accountList() {     //3번 사용자 조회
        System.out.println("사용자 조회");
        for (User login_box : accountArray) {
            if (login_box != null) {
                System.out.println("nickname:" + login_box.getNickname());
            }
        }
    }
    private static void doLogin() {    //2번 로그인하기
        System.out.println("로그인 하세요");
        System.out.print("id:");
        String id = scanner.next();
        System.out.print("password:");
        String password = scanner.next();

        User login_box = findLogin(id, password);
        if(login_box==null){
            System.out.println("로그인 아이디와 패스워드가 일치하지 않습니다.");
            return;
        }
        login_box.setid(login_box.getId());
        login_box.setPassword(login_box.getPassword());
        login_box.setNickname(login_box.getNickname());

        System.out.println("로그인이 되었습니다.");
        System.out.println("id :" + login_box.getId());
        System.out.println("nickname :" + login_box.getNickname());
    }
    private static void withdraw(){   //회원탈퇴
        System.out.println("회원탈퇴창 입니다.");
        System.out.print("id:");
        String id = scanner.next();
        System.out.print("password:");
        String password = scanner.next();

        User login_box = findLogin(id, password);

        if(login_box == null){
            System.out.println("회원탈퇴를 할 수 없습니다.");
            return;
        }else {
            for(int i=0; i<10; i++){
                if((id).equals(accountArray[i].getId())&&(password).equals(accountArray[i].getPassword())){
                    accountArray[i]=new User();
                    accountArray[i]=null;
                    accountArray[i]=accountArray[i+1];
                    accountArray[i+1]=null;
                    break;

                }
            }
            System.out.println("회원탈퇴 되었습니다.");

        }
    }
    private static User findLogin(String id, String password){
        User login_box = null;
        for (int i=0; i< accountArray.length; i++){
            if(accountArray[i]!=null){
                String idBox = accountArray[i].getId();
                String passwordBox = accountArray[i].getPassword();

                if(idBox.equals(id)&&passwordBox.equals(password)){
                    login_box = accountArray[i];
                    break;
                }
            }
        }
        return login_box;
    }

}