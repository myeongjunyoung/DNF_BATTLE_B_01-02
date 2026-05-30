package dnf;

public class Join_Guild_UI {
    public void 길드가입화면(전투 전투서비스, String 플레이어id, String 길드명) {
        System.out.println("\n==================================================");
        System.out.println("[JSP UI] Join_Guild_UI.jsp 상태창 활성화");
        System.out.println("가입 요청 중... 길드명: [" + 길드명 + "]");

        전투서비스.길드가입(플레이어id, 길드명);

        System.out.println("==================================================");
    }
}