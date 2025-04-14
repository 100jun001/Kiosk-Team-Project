import java.awt.*;
import java.util.List;


public class Kiosk {


    private final List<Menu> menus;         // Menu로부터 리스트를 가져온다.

    public Kiosk(List<Menu> menus) {        // Menu로 받아온 리스트를 현재 kiosk클래스에서 사용할 수 있도록 선언
        this.menus = menus;
    }

    public List<Menu> getMenus() {         // 리스트를 public으로 선언해주면서 외부로부터  사용이 가능하고 다시 값을 되돌려받는다
        return menus;
    }


}