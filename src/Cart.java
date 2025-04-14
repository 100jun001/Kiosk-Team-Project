import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cart {

    // 장바구니에 담긴 메뉴 항목과 수량을 저장하는 Map
    // Key: MenuItem (메뉴 항목), Value: Integer (수량)
    private final Map<MenuItem, Integer> items = new HashMap<>();

    // 장바구니에 상품 추가
    public void addItem(MenuItem item, int quantity) {
        // 이미 담겨있는 상품이면 수량 추가, 아니면 새로 추가
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    // 장바구니 출력용: 장바구니 항목 Map 반환
    public Map<MenuItem, Integer> getItems() {
        return items;
    }

    // 장바구니 비우기
    // 비어있으면 true, 아니면 false 반환
    public boolean clear() {
        if (items.isEmpty()) {
            return true;
        }
        items.clear(); // 모든 항목 삭제
        return false;
    }

    // 전체 가격 계산
    public double getTotalPrice() {
        double total = 0;
        for (Entry<MenuItem, Integer> entry : items.entrySet()) {
            MenuItem item = entry.getKey();       // 메뉴 항목
            int quantity = entry.getValue();      // 수량
            total += item.getPrice() * quantity;  // 가격 * 수량 누적
        }
        return total;
    }
}
