# 📚 Spring Framework 학습 기록

> **도서**: 그림으로 배우는 스프링 6 (한빛미디어)  


---

## 1. 프레임워크 핵심 개념

### 🛠 Spring vs Spring Boot
| 구분 | Spring Framework | Spring Boot |
| :--- | :--- | :--- |
| **정의** | 자바 기반의 엔터프라이즈 프레임워크 | 스프링을 더 쉽고 빠르게 쓰기 위한 도구 |
| **특징** | 설정이 자유롭지만 복잡함 | 자동 설정(Auto Config), 생산성 및 유지보수성 최적화 |

### 🌐 웹 애플리케이션 방식
- **MPA (Multi Page Application)**: 요청 시마다 서버에서 HTML을 생성하여 반환 (서버 사이드 제어).
- **SPA (Single Page Application)**: 초기 HTML 로드 후, JS가 동적으로 화면을 재구성 (클라이언트 사이드 제어).

---

## 2. 아키텍처

사용자의 요청부터 데이터 저장까지의 흐름을 관리

1. **Input**: 사용자가 입력한 원본 정보.
2. **Controller**: 요청을 받고 전체 흐름을 제어하며 적절한 View/Service를 호출.
3. **Service**: 비즈니스 로직(업무 규칙) 처리 (예: 재고 체크, 예외 처리).
4. **Repository**: 데이터베이스(DB)에 접속하여 데이터를 조회하거나 저장.
5. **Entity**: DB 테이블과 규격을 동일하게 맞춘 데이터 객체.

### 🔄 데이터의 흐름
`브라우저` ➡ `Controller` ➡️ `Service` ➡️ `Repository` ➡️ `DB (Entity 활용)`

---

## 3. DI (Dependency Injection: 의존성 주입)

###  개념
- **정의**: 사용할 객체를 직접 만들지 않고, 외부에서 생성하여 전달(주입)받는 설계 방식.
- **목적**: 프로그램의 부분적인 전환(부품 교체)을 쉽게 만들어 유연성을 높임.

### ️ 운영 vs 테스트 환경의 분리
인터페이스(`TrainingRepo`)를 활용하여 상황에 맞는 구현체를 주입합니다.

- **운영 환경**: `TrainingServiceImpl` ->️ `JdbcTrainingRepo` (실제 DB 연결)
- **테스트 환경**: `TrainingServiceImpl` ->️ `MockTrainingRepo` (가짜 데이터 활용)

###  구현 원칙
- 클래스 내부에서 `new`로 객체를 직접 선언하지 말 것 (**강한 결합 방지**).
- 생성자 파라미터로 객체를 전달받아 `this.repo = repo`로 선언할 것 (**의존성 주입**).

---

## 4. DI 컨테이너와 빈(Bean) 관리

- **DI 컨테이너 (ApplicationContext)**: 객체를 담고 생성/주입을 관리하는 상자.
- **Bean**: DI 컨테이너가 직접 관리하는 **자바 객체**.
- **Bean 정의**: 어떤 클래스를 Bean으로 만들고 어떤 의존성을 주입할지에 대한 설정 정보.
- **JavaConfig**: `@Configuration` 어노테이션을 사용하여 설정 정보를 저장하는 클래스.

여기까지 81p