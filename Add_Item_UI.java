package dnf;

public class Add_Item_UI {
    public void
    아이템획득화면(전투 전투서비스, String 플레이어id, String 아이템명, String 타입, int 가치) {
        System.out.println("\n==================================================");
        System.out.println("[JSP UI] Add_Item_UI.jsp 상태창 활성화");
        System.out.println("드롭 아이템 정보 감지 -> [" + 타입 + "] " + 아이템명 + " (가치: " + 가치 + ")");

        전투서비스.아이템획득(플레이어id, 아이템명, 타입, 가치);

        System.out.println("==================================================");
    }
}