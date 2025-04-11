import java.util.List;
import java.util.Scanner;

public class KioskService {
    // 다른 클래스에서 접근 하지 못하도록 캡슐화 진행
    private final Scanner scanner;
    private final Kiosk kiosk;
    private final CartService cartService;
    private Cart cart;

    // 외부로 부터받은 값을 내부로 저장시킨다.
    public KioskService(Scanner scanner, Kiosk kiosk, CartService cartService) {
        this.scanner = scanner;
        this.kiosk = kiosk;
        this.cartService = cartService;
    }

    //
    public static void start() {
        while (true) {
            // 1) 메인 메뉴 출력
            List<Menu> menus = mainMenu();

            // 2) 사용자 입력
            int menuSelect = scanner.nextInt();

            // 3) 선택지별 처리
            switch (menuSelect) {
                case 0:
                    // 메뉴 종료
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                case 4:
                    // 메뉴 주문하기
                    order();
                    break;
                case 5:
                    // 메뉴 취소하기
                    cancel();
                    break;
                default: // 메뉴선택이 0보다 작거나 menus값안의 리스트보다 크기가 크면 "잘못된 입력입니다"를 출력
                    if (menuSelect < 0 || menuSelect > menus.size()) {
                        throw new IllegalArgumentException("잘못된 입력입니다.");
                    }
                    // 메뉴를 주문하게되면 메뉴선택과 메뉴를 보여주게됨, break문을 통해 switch문 탈출
                    selectedMenu(menuSelect, menus);
                    break;
            }
        }
    }


// 리스트로부터 메뉴화면과 메뉴리스트를 가져오게되고, 선택된 메뉴를 메뉴로부터 가져와 선택된 메뉴의 이름을 나타나게 된다.
private List<Menu> mainMenu() {
    System.out.println("[ MAIN MENU ]");
    List<Menu> menus = kiosk.getMenus();
    for (int i = 0; i < menus.size(); i++) {
        System.out.println((i + 1) + ". " + menus.get(i).getName());
    }
    System.out.println("0. 종료   | 종료");

    return menus;
}


private void order() {

    // 만약 장바구니안에 상품이 들어있다면, 주문화면에 상품을 보여주고 전체 금액을 보여준다.
    System.out.println("아래와 같이 주문 하시겠습니까?\n");
    System.out.println("[ Orders ]");
    cartService.displayCartItems();
    System.out.println("\n[ Total ]");
    cartService.checkout();

    System.out.println("1. 주문        2. 메뉴판");
    int choice = scanner.nextInt(); // 1이나 2번을 선택하여 다음 화면으로 넘어간다.
    switch (choice) {
        case 1: // 주문 완료시 금액을 cartService로부터 전체 금액을 가져오게된다.
            System.out.println("\n[ Total ]");
            cartService.checkout();
            break;
        case 2:
            // 메뉴판으로 돌아간다.
            break;
        default: // 그 이외의 번호를 선택하게되면 아래와 같은 문구가 나온다.
            throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}
    // 만약 장바구니가 비어있다면 아래문구를 보여준다.
private void cancel() {
    if (cart.clear()) {
        System.out.println("장바구니에 담긴 메뉴가 없습니다.");
        return;
    }

}
// 메뉴선택에서 사용자가 선택한 메뉴는 1번부터 시작되며, 메뉴가 선택되었을 경우에 메뉴아이템을 보여주게 된다.
private void selectedMenu(int choice, List<Menu> menus) {
    Menu selectedMenu = menus.get(choice - 1);
    List<MenuItem> menuItems = selectedMenu.getMenuItem();
//선택된 메뉴는 수량과 메뉴의 이름과 금액 그리고 메뉴의 상세설명이 나타나게 된다.
    System.out.println("[ " + selectedMenu.getName() + " MENU ]");
    for (int i = 0; i < menuItems.size(); i++) {
        MenuItem menuItem = menuItems.get(i);
        System.out.println((i + 1) + ". "
                + menuItem.getName() + "   | W " + menuItem.getPrice()
                + " | " + menuItem.getDescription());
    }

    // 0번을 부르면 뒤로가기가 되고, 0과 같거나 작은 숫자를 넣게되면 잘못된 입력이라고 나오게된다. 0은 메뉴가 아니기때문에 잘못된 입력이 출력된다.
    System.out.println("0. 뒤로가기\n");

    int menuItemChoice = scanner.nextInt();
    if (menuItemChoice == 0) {
        return; // 뒤로가기
    }
    if (menuItemChoice <= 0 || menuItemChoice > menuItems.size()) {
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    // 선택된 메뉴를 1번부터 선택할수있게 되며, 선택된 아이템은 상품명, 가격, 설명을 보여주게된다.
    MenuItem selectedItem = menuItems.get(menuItemChoice - 1);
    System.out.println(selectedItem.getName()
            + "   | W " + selectedItem.getPrice()
            + " | " + selectedItem.getDescription());
    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n1. 확인        2. 취소");

    // 수량선택 창이 보여지게되고 장바구니에 삼품을 추가하게되면 선택된 상품의 이름과 함께 장바구니에 추가되었다는 문구가 입력된다.
    choice = scanner.nextInt();
    switch (choice) {
        case 1:
            System.out.print("수량을 입력하세요: ");
            int quantity = scanner.nextInt();
            Product product = new Product(selectedItem.getName(), selectedItem.getPrice());
            cartService.addProductToCart(product, quantity);
            break;

        case 2:
            // 취소하게된다.
            break;
        default: // 1과 2이외의 숫자를 입력하게 되면 아래와 같은 문구가 입력된다.
            throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}
}
