import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Menu 객체 생성하면서 카테고리 이름 설정
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입

        Menu burger = new Menu("Buger",   //메뉴의 객체 생성하면서 카테고리 이름 설정
                new ArrayList<>(                //Menu클레스에 상자 안에서 리스트 만들어서
                        List.of(new MenuItem("햄버거", 10, "기본에 충실한 패티와 케첩 양상추가 들어간 버거"),
                                new MenuItem("불고기 버거",12, "불고기 패티와 불고기 소스가 들어간 단짠단짠 햄버거")
                        )
                )
        );

        Menu side = new Menu("Side",
                new ArrayList<>(
                        List.of(new MenuItem("콜라", 3, "톡쏘는향의 달콤한 탄산음료"),
                                new MenuItem("사이다",3, "라임향의 달콤한 탄산음료")
                        )
                )
        );

        Menu drink = new Menu("Drink",
                new ArrayList<>(
                        List.of(new MenuItem("감자튀김", 1, "고소하고 짭잘한 바삭한 감자 튀김"),
                                new MenuItem("아이스크림",1, "고소하고 달콤한 차가운 크림")
                        )
                )
        );


        // Kiosk, Kioskservice, Cart, Cartservice 객체 생성, 선언 << Cartservice에서의 start 메서드를 사용하기 위해
        Scanner sc = new Scanner(System.in);

        Cart cart = new Cart();
        Kiosk kiosk = new Kiosk(List.of(burger, side, drink));

        CartService cartService = new CartService(cart);
        KioskService kioskService = new KioskService(sc, kiosk, cartService);



        // Kiosk 내 시작하는 함수 호출
        KioskService.start();

        //주석 꼭 붙여 주세요




    }
}