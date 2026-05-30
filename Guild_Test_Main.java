public class Guild_Test_Main {
  public static void main(String[] args) {
    전투 전투시스템 = new 전투();
    Create_Character_UI 캐릭터생성UI = new Create_Character_UI();
    Join_Guild_UI 길드가입UI = new Join_Guild_UI();

    System.out.println("=== 길드 가입 기능 단독 테스트 ===\n");

    캐릭터생성UI.캐릭터생성화면(전투시스템, "hero", "테스트유저", "전사", 10);

    System.out.println("\n--- 정상 길드 가입 테스트 ---");
    길드가입UI.길드가입화면(전투시스템, "hero1", "아라드기사단");
    길드가입UI.길드가입화면(전투시스템, "hero", "아라드기사단");

    System.out.println("\n--- 길드 정원 한도 초과 테스트 ---");
    길드 아라드길드 = 전투.길드저장소.get("아라드기사단");
    for (int i = 1; i <= 5; i++) {
      전사 더미캐릭터 = new 전사("용병" + i, 20);
      boolean 결과 = 아라드길드.캐릭터가입(더미캐릭터);
      System.out.println(i + "번째 더미 가입: " + (결과 ? "성공" : "실패 (정원 초과)"));
    }
  }
}
