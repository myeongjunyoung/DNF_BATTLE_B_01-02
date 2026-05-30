package dnf;

import java.util.ArrayList;
import java.util.List;

public class 인벤토리 {
  private List<아이템> 아이템리스트;
  private int 최대용량;

  public 인벤토리() {
    this.아이템리스트 = new ArrayList<>();
    this.최대용량 = 10;
  }

  public boolean 아이템추가(아이템 아이템객체) {
    if (아이템리스트.size() >= 최대용량) {
      return false;
    }
    아이템리스트.add(아이템객체);
    return true;
  }
}
