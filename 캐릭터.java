package dnf;

public abstract class 캐릭터 {
  protected String 캐릭터명;
  protected String 직업;
  protected int 레벨;
  protected int HP;
  protected double 공격력;
  public 인벤토리 인벤토리;

  public 캐릭터(String 캐릭터명, String 직업, int 레벨) {
    this.캐릭터명 = 캐릭터명;
    this.직업 = 직업;
    this.레벨 = 레벨;
    this.인벤토리 = new 인벤토리();
  }

  public abstract double 스킬발동();
}
