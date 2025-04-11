import java.util.HashMap;
import java.util.Map;

public class Cart {
    // 상품(Product)과 해당 수량(Integer)을 저장하는 HashMap
    private Map<Product, Integer> items;

    public Cart() {
        // HashMap을 사용하여 장바구니 초기화
        items = new HashMap<>();
    }

    // 장바구니에 상품을 추가하는 메서드
    public void addItem(Product product, int quantity) {
        // 이미 장바구니에 있는 상품이면 수량을 증가시키고,
        // 없으면 새로운 상품을 추가
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    // 장바구니에 담긴 모든 상품과 수량을 반환하는 메서드
    public Map<Product, Integer> getItems() {
        return items;
    }

    // 장바구니를 비우는 메서드
    public void clear() {
        items.clear();
    }
}