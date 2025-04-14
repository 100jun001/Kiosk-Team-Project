import java.util.Map;

public class CartService {

    private final Cart cart;

    // Cart 객체를 받아서 내부 필드에 저장
    public CartService(Cart cart) {
        this.cart = cart;
    }

    // 장바구니에 메뉴 아이템 추가
    public void addProductToCart(MenuItem item, int quantity) {
        cart.addItem(item, quantity);
        System.out.println(item.getName() + " " + quantity + "개가 장바구니에 추가되었습니다.");
    }

    // 장바구니에 담긴 항목들을 출력
    public void displayCartItems() {
        Map<MenuItem, Integer> items = cart.getItems();

        if (items.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }

        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(item.getName() + " x " + quantity + "개 | W " + (item.getPrice() * quantity));
        }
    }

    // 장바구니의 전체 금액을 계산하고 출력
    public void checkout() {
        Map<MenuItem, Integer> items = cart.getItems();
        double total = 0;

        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = entry.getValue();
            total += item.getPrice() * quantity;
        }

        System.out.println("총 합계: W " + total);
    }

    // 장바구니 비우기
    public boolean clearCart() {
        return cart.clear();
    }
}
