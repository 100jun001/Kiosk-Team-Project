import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Menu 객체 생성하면서 카테고리 이름 설정
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입

        //메뉴의 '종류'입니다.
        ArrayList<Menu> burger = new ArrayList<>();
        ArrayList<Menu> side = new ArrayList<>();
        ArrayList<Menu> drink = new ArrayList<>();


        // 메뉴아이템(햄버거)의 설명(빈)칸입니다.
        // 만약 추가하시려면 "이름"을 바꾸고 아래 적힌것처럼 비슫하게 추가해주세요.
        // ArrayList<MenuItem> 이름 = new ArrayList<>();
        ArrayList<MenuItem> ham = new ArrayList<>();
        ArrayList<MenuItem> bull = new ArrayList<>();

        // 메뉴아이템(햄버거)의 빈칸에 추가할 '설명'입니다.
        // 이름.add(new MenuItem("버거이름", 가격, "설명"));
        ham.add(new MenuItem("햄버거", 10, "기본에 충실한 패티와 케첩 양상추가 들어간 버거"));
        bull.add(new MenuItem("불고기 버거",12, "불고기 패티와 불고기 소스가 들어간 단짠단짠 햄버거"));

        // 메뉴(버거)의 빈칸에 추가할 '설명'입니다. ("종류", 설명)
        // burger.add(new Menu("햄버거", 이름));
        burger.add(new Menu("햄버거", ham));
        burger.add(new Menu("햄버거", bull));


        // 메뉴아이템(음료수)의 설명(빈)칸입니다.
        // 만약 추가하시려면 "이름"을 바꾸고 아래 적힌것처럼 비슫하게 추가해주세요.
        // ArrayList<MenuItem> 이름 = new ArrayList<>();
        ArrayList<MenuItem> coke = new ArrayList<>();
        ArrayList<MenuItem> soda = new ArrayList<>();

        // 메뉴아이템(음료수)의 빈칸에 추가할 '설명'입니다.
        // 이름.add(new MenuItem("음료이름", 가격, "설명"));
        coke.add(new MenuItem("콜라", 3, "톡쏘는향의 달콤한 탄산음료"));
        soda.add(new MenuItem("사이다",3, "라임향의 달콤한 탄산음료"));

        // 메뉴(음료)의 빈칸에 추가할 '설명'입니다. ("종류", 설명)
        // burger.add(new Menu("음료", 이름));
        drink.add(new Menu("음료수",coke));
        drink.add(new Menu("음료수",soda));


        // 메뉴아이템(사이드메뉴)의 설명(빈)칸입니다.
        // 만약 추가하시려면 "이름"을 바꾸고 아래 적힌것처럼 비슫하게 추가해주세요.
        //ArrayList<MenuItem> 이름 = new ArrayList<>();
        ArrayList<MenuItem> chips = new ArrayList<>();
        ArrayList<MenuItem> icecream = new ArrayList<>();

        // 메뉴아이템(사이드메뉴)의 빈칸에 추가할 '설명'입니다.
        // 이름.add(new MenuItem("사이드이름", 가격, "설명"));
        chips.add(new MenuItem("감자튀김", 1, "고소하고 짭잘한 바삭한 감자 튀김"));
        icecream.add(new MenuItem("아이스크림",1, "고소하고 달콤한 차가운 크림"));

        // 메뉴(사이드메뉴)의 빈칸에 추가할 '설명'입니다. ("종류", 설명)
        // burger.add(new Menu("사이드메뉴", 이름));
        side.add(new Menu("사이드 메뉴",chips));
        side.add(new Menu("사이드 메뉴",icecream));



        // Kiosk, Cart 객체 생성
        List<Kiosk> kiosks = new ArrayList<>();
        List<Cart> carts = new ArrayList<>();



        // Kiosk 내 시작하는 함수 호출


        //주석 꼭 붙여 주세요




    }
}