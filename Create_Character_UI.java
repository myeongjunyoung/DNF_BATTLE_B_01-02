package dnf;

public class Create_Character_UI {
  public void 캐릭터생성화면(전투 전투서비스, String 플레이어id, String 캐릭터명, String 직업, int 레벨) {
    System.out.println("\n==================================================");
    System.out.println("[JSP UI] Create_Character_UI.jsp 상태창 활성화");
    System.out.println("-> 입력 데이터 전송 중... [ID]: " + 플레이어id + ", [이름]: " + 캐릭터명 + ", [직업]: " + 직업 + ", [Lv]: " + 레벨);

    boolean 성공 = 전투서비스.캐릭터생성(플레이어id, 캐릭터명, 직업, 레벨);

    if (성공) {
      System.out.println("결과: 캐릭터 생성 성공! (인벤토리 10칸 오픈 완료)");
    } else {
      System.out.println("결과: 캐릭터 생성 실패 (인증오류 또는 직업선택오류)");
    }
    System.out.println("==================================================");
  }
}
