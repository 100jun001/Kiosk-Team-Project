import java.util.Map;

public class CartService {
    private Cart cart;

    public CartService(Cart cart) {
        this.cart = cart;
    }

    public void addProductToCart(Product product, int quantity) {
        cart.addItem(product, quantity);
        System.out.println(product.getName() + "이(가) " + quantity + "개 장바구니에 추가되었습니다.");
    }

    public void displayCartItems() {
        System.out.println("\n🛒 장바구니 목록:");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("- " + product.getName() + " : " + quantity + "개");
        }
    }

    public void checkout() {
        displayCartItems();
        int total = 0;
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }
        System.out.println("총 결제 금액: " + total + "원");
        cart.clear();
    }
}