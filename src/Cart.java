import java.util.HashMap;
import java.util.Map;

public class Cart {

    // 장바구니는 MenuItem과 수량(Integer)을 매핑해서 저장함
    private final Map<MenuItem, Integer> items = new HashMap<>();

    // 장바구니에 아이템 추가
    public void addItem(MenuItem item, int quantity) {
        // 기존에 있던 메뉴면 수량만 증가, 아니면 새로 추가
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    // 현재 장바구니에 담긴 항목을 모두 반환
    public Map<MenuItem, Integer> getItems() {
        return items;
    }

    // 장바구니 비우기. 이미 비어 있었는지 여부 반환
    public boolean clear() {
        if (items.isEmpty()) {
            return true;
        }
        items.clear();
        return false;
    }

    // 장바구니가 비어 있는지 확인하는 메서드
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
