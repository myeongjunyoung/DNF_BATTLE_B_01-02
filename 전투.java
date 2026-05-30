package dnf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class 전투 implements Serializable {
  private final 플레이어 플레이어객체 = new 플레이어("hero");
  private 캐릭터 캐릭터;

  public static final Map<String, 길드> 길드저장소 = new HashMap<>();
  static {
    길드저장소.put("아라드기사단", new 길드("아라드기사단"));
  }

  public boolean 캐릭터생성(String 플레이어id, String 캐릭터명, String 직업, int 레벨) {
    if (!플레이어객체.플레이어체크(플레이어id)) {
      System.out.println("[전투 시스템] 플레이어 인증에 실패하여 캐릭터를 생성할 수 없습니다.");
      return false;
    }
    캐릭터 생성된캐릭터 = null;
    if ("전사".equals(직업)) {
      생성된캐릭터 = new 전사(캐릭터명, 레벨);
    } else if ("마법사".equals(직업)) {
      생성된캐릭터 = new 마법사(캐릭터명, 레벨);
    }
    if (생성된캐릭터 == null) {
      System.out.println("[전투 시스템] 잘못된 직업 유형입니다.");
      return false;
    }
    this.캐릭터 = 생성된캐릭터;
    return true;
  }

  public String 몬스터공격(String 플레이어id) {
    if (!플레이어객체.플레이어체크(플레이어id)) {
      return "FAIL:인증실패";
    }
    if (this.캐릭터 == null) {
      return "FAIL:캐릭터없음";
    }
    double 데미지 = this.캐릭터.스킬발동();
    String 등급;
    if (데미지 >= 200) {
      등급 = "S급";
    } else if (데미지 >= 100) {
      등급 = "A급";
    } else {
      등급 = "B급";
    }
    return "데미지:" + 데미지 + ",등급:" + 등급;
  }

  public void 아이템획득(String 플레이어id, String 아이템명, String 아이템타입, int 아이템가치) {
    if (!플레이어객체.플레이어체크(플레이어id)) {
      System.out.println("[전투 시스템] 인증되지 않은 플레이어는 아이템을 획득할 수 없습니다.");
      return;
    }
    String 등급;
    if (아이템가치 >= 1000) {
      등급 = "전설(Legendary)";
    } else if (아이템가치 >= 500) {
      등급 = "희귀(Rare)";
    } else {
      등급 = "일반(Common)";
    }
    아이템 획득아이템 = new 아이템(아이템명, 아이템타입, 아이템가치, 등급);
    boolean 성공 = this.캐릭터.인벤토리.아이템추가(획득아이템);
    if (성공) {
      System.out.println("[인벤토리 추가] '" + 아이템명 + "' [" + 등급 + "] 가방에 적재됨.");
    } else {
      System.out.println("[인벤토리 오류] 인벤토리가 가득 차서 더 이상 아이템을 획득할 수 없습니다. (최대 10칸)");
    }
  }

  public void 길드가입(String 플레이어id, String 길드명) {
    if (!플레이어객체.플레이어체크(플레이어id)) {
      System.out.println("[전투 시스템] 인증되지 않은 플레이어는 길드에 가입할 수 없습니다.");
      return;
    }
    if (this.캐릭터 == null) {
      System.out.println("[전투 시스템] 길드에 가입할 캐릭터가 존재하지 않습니다.");
      return;
    }
    길드 대상길드 = 길드저장소.get(길드명);
    if (대상길드 == null) {
      System.out.println("[전투 시스템] 존재하지 않는 길드명입니다: " + 길드명);
      return;
    }
    boolean 성공 = 대상길드.캐릭터가입(this.캐릭터);
    if (성공) {
      System.out.println("[길드 가입] '" + 길드명 + "' 길드에 가입되었습니다.");
    } else {
      System.out.println("[길드 가입 오류] '" + 길드명 + "' 길드의 정원이 가득 찼습니다. (최대 5명)");
    }
  }

}
