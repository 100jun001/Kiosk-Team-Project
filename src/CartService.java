import java.util.Map;

public class CartService {
    private final Cart cart; // 장바구니 객체

    public CartService(Cart cart) {
        this.cart = cart; // 생성자에서 외부로부터 cart 받아서 사용
    }

    // 장바구니에 메뉴 추가
    public void addProductToCart(MenuItem item, int quantity) {
        cart.addItem(item, quantity); // Cart 클래스의 addItem() 호출
        System.out.println(item.getName() + " " + quantity + "개가 장바구니에 추가되었습니다.");
    }

    // 장바구니에 담긴 항목들을 화면에 출력
    public void displayCartItems() {
        Map<MenuItem, Integer> items = cart.getItems(); // 장바구니 항목 가져오기

        if (items.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }

        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(item.getName() + " x " + quantity + " | W " + (item.getPrice() * quantity));
        }
    }

    // 전체 가격 출력 (주문 확인 시 사용)
    public void checkout() {
        double totalPrice = cart.getTotalPrice();
        System.out.println("총 가격: W " + totalPrice);
    }
}
