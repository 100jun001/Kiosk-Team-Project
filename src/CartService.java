import java.util.Map;

public class CartService {
    private final Cart cart;

    public CartService(Cart cart) {
        this.cart = cart;
    }

    // 장바구니에 메뉴 추가
    public void addProductToCart(MenuItem item, int quantity) {
        cart.addMenuItem(item, quantity);
        System.out.println(item.getName() + " " + quantity + "개 장바구니에 추가되었습니다.");
    }

    // 장바구니 목록 출력
    public void displayCartItems() {
        Map<MenuItem, Integer> items = cart.getItems();
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return;
        }

        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(item.getName() + " x " + quantity + "개 | W " + (item.getPrice() * quantity));
        }
    }

    // 총 금액 출력
    public void checkout() {
        double totalPrice = cart.getTotalPrice();
        System.out.println("총 금액: W " + totalPrice);
    }
}
