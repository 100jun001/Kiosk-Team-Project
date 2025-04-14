import java.util.HashMap;
import java.util.Map;

public class Cart {
    // 장바구니: 상품(Product 이름 기준)과 수량을 저장하는 맵
    private final Map<String, Integer> items = new HashMap<>();

    // 장바구니에 상품을 추가하는 메서드
    public void addItem(String itemName, int quantity) {
        // 기존에 있던 상품이면 수량을 누적
        items.put(itemName, items.getOrDefault(itemName, 0) + quantity);
    }

    // 장바구니 내용을 가져오는 메서드
    public Map<String, Integer> getItems() {
        return items;
    }

    // 장바구니를 비우는 메서드 (비워졌는지 boolean으로 반환)
    public boolean clear() {
        if (items.isEmpty()) {
            return true;
        }
        items.clear();
        return false;
    }

    // 장바구니가 비어있는지 확인하는 메서드
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
