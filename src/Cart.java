import java.util.HashMap;
import java.util.Map;

public class Cart {
    // MenuItem과 수량을 저장
    private final Map<MenuItem, Integer> items = new HashMap<>();

    // 장바구니에 메뉴 추가
    public void addMenuItem(MenuItem item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    // 장바구니 비우기 (비어있었으면 true)
    public boolean clear() {
        if (items.isEmpty()) {
            return true;
        }
        items.clear();
        return false;
    }

    // 장바구니 목록 반환
    public Map<MenuItem, Integer> getItems() {
        return items;
    }

    // 총 가격 계산
    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = entry.getValue();
            total += item.getPrice() * quantity;
        }
        return total;
    }
}
