public class CartService {
    private Cart cart;

    // CartService 생성자에서 Cart 객체를 주입받음
    public CartService(Cart cart) {
        this.cart = cart;
    }

    // 장바구니에 상품을 추가하는 메서드
    public void addProductToCart(Product product, int quantity) {
        cart.addItem(product, quantity);
        System.out.println(product.getName() + "이(가) " + quantity + "개 장바구니에 추가되었습니다.");
    }

    // 장바구니에 담긴 상품 목록을 출력하는 메서드
    public void displayCartItems() {
        System.out.println("\n🛒 장바구니 목록:");
        // 장바구니에 담긴 각 상품과 수량을 출력
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("- " + product.getName() + " : " + quantity + "개");
        }
    }

    // 결제를 처리하고 총 금액을 출력하는 메서드
    public void checkout() {
        displayCartItems(); // 장바구니 목록 출력
        int total = 0;
        // 총 금액 계산
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }
        System.out.println("총 결제 금액: " + total + "원");
        cart.clear(); // 결제 후 장바구니 비우기
    }
}