package dnf;

public class Attack_Monster_UI {
    public void 몬스터공격화면(전투 전투서비스, String 플레이어id) {
        System.out.println("\n==================================================");
        System.out.println("[JSP UI] Attack_Monster_UI.jsp 상태창 활성화");

        String 결과 = 전투서비스.몬스터공격(플레이어id);

        System.out.println("전투 결과 로그 출력 -> " + 결과);
        System.out.println("==================================================");
    }
}