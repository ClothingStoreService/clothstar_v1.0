# order 패키지 README

## 패키지 개요

이 패키지는 주문에 대한 기능을 구현하기 위한 패키지이다.

### 주문 생성 설계안

1. 주문 유효성 검사
    - 로그인된 상태에서만 주문 가능
2. 주문 정보 입력
   2-1. 자동 입력되는 정보
    - 기존 배송지, 수령인, 연락처, 총 배송비, 총 결제 금액(총 상품금액 + 쿠폰/포인트/등급 할인 금액 + 배송비)
      2-1-1. 총 배송비 계산 규칙
        - 사업자가 달라도 기본적인 배송비는 3천원으로 동일
        - 제주도 및 도서 산간 지역은 추가 배송비 3천원
        - 2만원 이상 주문시 배송비 무료(지역에 상관없이)
          2-2. 추가 입력해야하는 정보
    - 신규 배송지: 배송지 목록에 추가 후, 목록에서 선택
    - 배송시 요청사항 입력
    - 쿠폰 선택
    - 보유 포인트 사용시 포인트 입력
    - 결제방법 선택(신용/체크카드, 네이버페이, 카카오페이, 무통장 입금)
3. 주문 생성
   3-1. 주문 생성 유효성 검사
    - 주문 생성시 재고 수량이 0이라면 주문이 생성되지 않고, '품정된 상품입니다' 알림
      3-2. 주문이 생성되는 경우
    - 고유 주문번호, 주문일자 생성
    - 사용한 포인트와 쿠폰 차감
    - 배송상태가 [ 주문 승인 ]으로 변경됨
    - 신규 배송지 저장

### 주문 조회 설계안

1. 주문 상세 내역 조회
   1-1. 주문 상세 내역 조회
    - 주문일자, 주문번호, 배송 진행 상태(+ 택배사 이름, 운송장 번호 - 판매자가 배송 보내면 입력됨), 주문 상품 정보(상품 이름, 브랜드 이름, 가격, 수량????),
      -배송 진행 상태 단계
      [ 주문 승인 → 배송 준비 → 배송지 도착 → 배송중 → 배송 완료 ]
      1-2. 구매자 정보 조회
    - 구매자 이름, 이메일 주소, 연락처
      1-3. 결제 정보 조회
    - 결제 수단, 주문 금액(상품금액 + 배송비), 할인(포인트, 쿠폰, 등급), 총 결제 금액, 결제 수단
      1-4. 배송지 정보 조회
    - 수령인, 연락처, 배송지, 배송요청사항
2. 구매 확정 시(구매자가 구매 확정을 하는 경우)
    - 주문상태가 구매 확정이 됨
        - 주문상태: [ 주문 승인 -> 배송 완료 -> 구매 확정 ]
        - 상태의 변경 과정을 validation 한다(주문 승인에서 바로 구매 확정으로 넘어가지 않도록)
    - 포인트 지급
    - 반품 및 교환 불가

### 주문 취소 설계안

1. 주문 취소 조건 확인
    - [ 배송 준비 이전 ] 상태일 경우만 주문 취소 가능
2. 주문 취소 신청
    - 회원이 주문 취소 사유 작성
3. 환불 시스템
    - 환불은 결제했던 수단으로 다시 환불
    - 영업일 기준 3~7일 이내에 처리
4. 주문 취소 완료
    - 재고와 사용한 쿠폰, 포인트를 롤백
    - 주문 상태를 [ 주문 취소 ]로 변경

### (판매자) 주문 관리 설계안

1. 승인된 주문 조회
2. 주문 취소 여부 결정
3. 주문 최종 승인시
    - 배송을 보냄 -> 배송id 생성
    - 운송장 번호 입력
    - 배송상태를 [ 배송중 ]으로 변경
    - 배송상태가 [ 배송중 ]이 되면, 배송 상태 조회 가능

### API 디자인

- 주문 생성: POST /v1/orders
  신규 배송지 생성: POST /v1/orders/{userId}
  쿠폰/포인트 사용시 차감: PATCH /v1/orders/{userId}
  배송상태 변경: PATCH /v1/orders/{orderId}
    - 프로세스
        1. 주문 정보 입력
            - 자동 입력되는 정보: 기존 배송지, 수령인, 연락처, 총 배송비, 총 결제 금액(총 상품금액 + 쿠폰/포인트/등급 할인 금액 + 배송비)
            - 추가 입력 해야하는 정보: 신규 배송지, 배송시 요청사항, 쿠폰 선택, 보유 포인트 사용시 포인트 입력, 결제방법 선택(신용/체크카드, 네이버페이, 카카오페이, 무통장 입금),
        2. 주문 생성 유효성 검사
            - 주문 생성시 재고 수량이 0이라면 주문이 생성되지 않고, '품정된 상품입니다' 알림
        3. 주문 생성
            - 고유 주문번호, 주문일자 생성
            - 사용한 포인트와 쿠폰 차감(PATCH)
            - 배송상태가 [ 주문 승인 ]으로 변경됨(PATCH)
            - 신규 배송지 저장(POST)

- 주문 조회 : GET /v1/orders/{orderId}
  구매 확정: PATCH /v1/orders/{orderId}
    - 프로세스
        1. 주문 조회
            - 주문 상세 내역: 주문일자, 주문번호, 배송 진행 상태(+ 택배사 이름, 운송장 번호 - 판매자가 배송 보내면 입력됨), 주문 상품 정보(상품 이름, 브랜드 이름, 가격, 수량)
            - 구매자 정보: 구매자 이름, 이메일 주소, 연락처
            - 결제 정보: 결제 수단, 주문 금액(상품금액 + 배송비), 할인(포인트, 쿠폰, 등급), 총 결제 금액, 결제 수단
            - 배송지 정보: 수령인, 연락처, 배송지, 배송요청사항
        2. 구매 확정시(구매자가 구매 확정을 하는 경우)
            - 주문상태가 구매 확정이 됨(PATCH)
            - 주문상태: [ 주문 승인 -> 배송 완료 -> 구매 확정 ]
            - 상태의 변경 과정을 validation 한다(주문 승인에서 바로 구매 확정으로 넘어가지 않도록)
            - 포인트 지급(PATCH)
            - 반품 및 교환 불가

- 주문 취소 : PATCH /v1/orders/{orderId}
    - 프로세스
        1. 주문 취소 조건 확인
            - 배송 상태가 [ 주문 승인 ] 상태일 경우만 주문 취소 가능
        2. 주문 취소 신청
            - 회원이 주문 취소 사유 작성
        3. 환불
            - 결제했던 수단으로 환불 처리
            - 영업일 기준 3~7일 이내에 처리됨
        4. 주문 취소 완료
            - 재고와 사용한 쿠폰, 포인트를 롤백
            - 주문 상태를 [ 주문 취소 ]로 변경

- (판매자) 주문 관리 :
  승인 주문 조회: GET /v1/seller/orders/{orderId}
  주문 취소 여부 결정: PATCH /v1/seller/orders/{orderId}-cancel
  주문 최종 승인시: PATCH /v1/seller/orders/{orderId}-approve
    - 프로세스
        1. 승인된 주문 조회(GET)
        2. 주문 취소 여부 결정(PATCH)
        3. 주문 최종 승인시(PATCH)
            - 배송을 보냄 -> 배송id 생성
            - 운송장 번호 입력
            - 배송상태를 [ 배송중 ]으로 변경
            - 배송상태가 [ 배송중 ]이 되면, 배송 상태 조회 가능