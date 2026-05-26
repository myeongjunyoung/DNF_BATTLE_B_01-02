```mermaid
sequenceDiagram
    actor User as 플레이어(Actor)
    participant UI as Join_Guild_UI(Boundary)
    participant Ctrl as 전투(Control)
    participant Player as 플레이어(Entity)
    participant Guild as 길드(Entity)

    Note over User, Guild: Use Case: 길드가입 (Aggregation)
    
    User->>UI: 길드명 입력 및 가입 요청
    activate UI
    UI->>Ctrl: 길드가입(플레이어id, 길드명)
    activate Ctrl
    
    %% 플레이어 체크 (Include)
    Ctrl->>Player: 플레이어체크(플레이어id)
    activate Player
    Player-->>Ctrl: boolean (true: "hero")
    deactivate Player
    
    alt 검증 통과 (true)
        Ctrl->>Guild: 기존 길드 객체 참조 및 인원 확인
        activate Guild
        
        alt 캐릭터리스트 크기 < 최대인원(5)
            Guild-->>Ctrl: 가입 가능
            
            Ctrl->>Guild: 캐릭터가입(캐릭터객체)
            Guild->>Guild: 캐릭터리스트.add() (Aggregation)
            Guild-->>Ctrl: void
            Ctrl-->>UI: 가입 성공 처리
            UI-->>User: 길드 가입 완료 메시지 출력
        else 최대인원 도달 (5명)
            Guild-->>Ctrl: 가입 불가
            Ctrl-->>UI: 가입 실패 (정원 초과)
            UI-->>User: 정원 초과 에러 메시지 출력
        end
        deactivate Guild
        
    else 검증 실패 (false)
        Ctrl-->>UI: 가입 실패 (권한 없음)
        UI-->>User: 플레이어 ID 불일치 에러 출력
    end
    deactivate Ctrl
    deactivate UI