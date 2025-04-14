import java.util.Map;

public class CartService {
    private final Cart cart;

    // Cart 객체를 생성자 주입 받아 저장
    public CartService(Cart cart) {
        this.cart = cart;
    }

    // 장바구니에 상품을 추가하는 메서드
    public void addProductToCart(MenuItem item, int quantity) {
        cart.addItem(item.getName(), quantity);
        System.out.println(item.getName() + " " + quantity + "개가 장바구니에 추가되었습니다.");
    }

    // 장바구니에 담긴 상품들을 출력하는 메서드
    public void displayCartItems() {
        Map<String, Integer> items = cart.getItems();
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + " x " + entry.getValue());
        }
    }

    // 총 금액 계산 및 출력
    public void checkout() {
        Map<String, Integer> items = cart.getItems();
        double total = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();

            // 가격은 MenuItem에서 가져와야 하므로, 실제 구현에서는 item 객체 저장 방식 필요
            // 현재 구조에서는 가격 정보가 없으므로 예시로 처리
            double price = 0; // 이 부분은 구조적으로 수정 필요 (예: Map<MenuItem, Integer>로 변경)
            System.out.println(itemName + " x " + quantity + " = W " + (price * quantity));
            total += price * quantity;
        }
        System.out.println("총합: W " + total);
    }

    public boolean clearCart() {
        return cart.clear();
    }
}
