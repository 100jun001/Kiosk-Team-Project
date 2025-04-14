import java.awt.*;
import java.util.List;

public class Menu {
    // 카테고리 이름 필드 추가
    // MenuItem 클래스를 List로 관리
    private final String name;
    private List<MenuItem> menuItem;


    // List에 포함된 MenuItem을 순차적으로 보여주는 함수
    public Menu(String name, List<MenuItem> menuItem) {
        this.name = name;
        this.menuItem = menuItem;
    }

    // List를 리턴하는 함수
    public String getName(){return name;}
    public List<MenuItem> getMenuItem(){return menuItem;}

    // 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.

    //주석 꼭 붙여 주세요.

}