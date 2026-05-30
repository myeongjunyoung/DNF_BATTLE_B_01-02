public class Item_Test_Main {
  public static void main(String[] args) {
    전투 전투시스템 = new 전투();
    Create_Character_UI 캐릭터생성UI = new Create_Character_UI();
    Add_Item_UI 아이템획득UI = new Add_Item_UI();

    System.out.println("=== 아이템 획득 기능 단독 테스트 ===\n");

    캐릭터생성UI.캐릭터생성화면(전투시스템, "hero", "테스트유저", "전사", 10);

    System.out.println("\n--- 인증 실패 테스트 ---");
    아이템획득UI.아이템획득화면(전투시스템, "hero1", "낡은검", "무기", 100);

    System.out.println("\n--- 등급별 아이템 획득 테스트 ---");
    아이템획득UI.아이템획득화면(전투시스템, "hero", "회복포션", "물약", 100);
    아이템획득UI.아이템획득화면(전투시스템, "hero", "강철검", "무기", 500);
    아이템획득UI.아이템획득화면(전투시스템, "hero", "전설갑옷", "방어구", 1000);

    System.out.println("\n--- 인벤토리 한도 초과 테스트 ---");
    for (int i = 1; i <= 7; i++) {
      아이템획득UI.아이템획득화면(전투시스템, "hero", "잡템" + i, "물약", 50);
    }
    아이템획득UI.아이템획득화면(전투시스템, "hero", "초과아이템", "물약", 100);
  }
}
