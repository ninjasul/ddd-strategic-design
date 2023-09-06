# 키친포스

## 퀵 스타트

```sh
cd docker
docker compose -p kitchenpos up -d
```

## 요구 사항

### 상품

- 상품을 등록할 수 있다.
- 상품의 가격이 올바르지 않으면 등록할 수 없다.
    - 상품의 가격은 0원 이상이어야 한다.
- 상품의 이름이 올바르지 않으면 등록할 수 없다.
    - 상품의 이름에는 비속어가 포함될 수 없다.
- 상품의 가격을 변경할 수 있다.
- 상품의 가격이 올바르지 않으면 변경할 수 없다.
    - 상품의 가격은 0원 이상이어야 한다.
- 상품의 가격이 변경될 때 메뉴의 가격이 메뉴에 속한 상품 금액의 합보다 크면 메뉴가 숨겨진다.
- 상품의 목록을 조회할 수 있다.

### 메뉴 그룹

- 메뉴 그룹을 등록할 수 있다.
- 메뉴 그룹의 이름이 올바르지 않으면 등록할 수 없다.
    - 메뉴 그룹의 이름은 비워 둘 수 없다.
- 메뉴 그룹의 목록을 조회할 수 있다.

### 메뉴

- 1 개 이상의 등록된 상품으로 메뉴를 등록할 수 있다.
- 상품이 없으면 등록할 수 없다.
- 메뉴에 속한 상품의 수량은 0 이상이어야 한다.
- 메뉴의 가격이 올바르지 않으면 등록할 수 없다.
    - 메뉴의 가격은 0원 이상이어야 한다.
- 메뉴에 속한 상품 금액의 합은 메뉴의 가격보다 크거나 같아야 한다.
- 메뉴는 특정 메뉴 그룹에 속해야 한다.
- 메뉴의 이름이 올바르지 않으면 등록할 수 없다.
    - 메뉴의 이름에는 비속어가 포함될 수 없다.
- 메뉴의 가격을 변경할 수 있다.
- 메뉴의 가격이 올바르지 않으면 변경할 수 없다.
    - 메뉴의 가격은 0원 이상이어야 한다.
- 메뉴에 속한 상품 금액의 합은 메뉴의 가격보다 크거나 같아야 한다.
- 메뉴를 노출할 수 있다.
- 메뉴의 가격이 메뉴에 속한 상품 금액의 합보다 높을 경우 메뉴를 노출할 수 없다.
- 메뉴를 숨길 수 있다.
- 메뉴의 목록을 조회할 수 있다.

### 주문 테이블

- 주문 테이블을 등록할 수 있다.
- 주문 테이블의 이름이 올바르지 않으면 등록할 수 없다.
    - 주문 테이블의 이름은 비워 둘 수 없다.
- 빈 테이블을 해지할 수 있다.
- 빈 테이블로 설정할 수 있다.
- 완료되지 않은 주문이 있는 주문 테이블은 빈 테이블로 설정할 수 없다.
- 방문한 손님 수를 변경할 수 있다.
- 방문한 손님 수가 올바르지 않으면 변경할 수 없다.
    - 방문한 손님 수는 0 이상이어야 한다.
- 빈 테이블은 방문한 손님 수를 변경할 수 없다.
- 주문 테이블의 목록을 조회할 수 있다.

### 주문

- 1개 이상의 등록된 메뉴로 배달 주문을 등록할 수 있다.
- 1개 이상의 등록된 메뉴로 포장 주문을 등록할 수 있다.
- 1개 이상의 등록된 메뉴로 매장 주문을 등록할 수 있다.
- 주문 유형이 올바르지 않으면 등록할 수 없다.
- 메뉴가 없으면 등록할 수 없다.
- 매장 주문은 주문 항목의 수량이 0 미만일 수 있다.
- 매장 주문을 제외한 주문의 경우 주문 항목의 수량은 0 이상이어야 한다.
- 배달 주소가 올바르지 않으면 배달 주문을 등록할 수 없다.
    - 배달 주소는 비워 둘 수 없다.
- 빈 테이블에는 매장 주문을 등록할 수 없다.
- 숨겨진 메뉴는 주문할 수 없다.
- 주문한 메뉴의 가격은 실제 메뉴 가격과 일치해야 한다.
- 주문을 접수한다.
- 접수 대기 중인 주문만 접수할 수 있다.
- 배달 주문을 접수되면 배달 대행사를 호출한다.
- 주문을 서빙한다.
- 접수된 주문만 서빙할 수 있다.
- 주문을 배달한다.
- 배달 주문만 배달할 수 있다.
- 서빙된 주문만 배달할 수 있다.
- 주문을 배달 완료한다.
- 배달 중인 주문만 배달 완료할 수 있다.
- 주문을 완료한다.
- 배달 주문의 경우 배달 완료된 주문만 완료할 수 있다.
- 포장 및 매장 주문의 경우 서빙된 주문만 완료할 수 있다.
- 주문 테이블의 모든 매장 주문이 완료되면 빈 테이블로 설정한다.
- 완료되지 않은 매장 주문이 있는 주문 테이블은 빈 테이블로 설정하지 않는다.
- 주문 목록을 조회할 수 있다.

## 용어 사전

### 상품 (Product)
| 한글명 | 영문명 | 설명                          |
|-------|--------------|-----------------------------|
| 상품 | Product | 메뉴를 구성하는 최소 단위              |
| 비속어 | Profanity | 저속한 표현이 담긴 언어               |
| 상품 가격 | Prouct Price | 상품의 개당 가격으로 메뉴 가격 계산 요소로 사용 |
| 상품 목록 | Change Price | 등록되어 있는 상품의 목록                  |

### 메뉴 그룹 (Menu Group)
| 한글명 | 영문명 | 설명                    |
|----------|-----------------|-----------------------|
| 메뉴 그룹 | Menu Group | 메뉴를 쉽게 볼 수 있도록 분류한 단위 |
| 메뉴 그룹 목록 | Menu Group List | 등록되어 있는 메뉴 그룹의 목록     |

### 메뉴 (Menu)
| 한글명 | 영문명 | 설명                            |
|-------|------------|-------------------------------|
| 메뉴 | Menu | 주문을 위한 최소 단위                  |
| 메뉴 가격 | Menu Price | 메뉴의 개당 가격으로 주문 할 때 지불해야 하는 금액 |
| 메뉴 노출 | Show Menu | 주문을 할 수 있는 메뉴                 |
| 메뉴 숨김 | Hide Menu | 주문을 할 수 없는 메뉴                 |
| 메뉴 목록 | Menu List | 등록되어 있는 메뉴 목록                 |

### 주문 테이블 (Order Table)
| 한글명       | 영문명              | 설명                     |
|-----------|------------------|------------------------|
| 주문 테이블    | Order Table      | 매장 주문을 할 경우 이용 가능한 테이블 |
| 빈 테이블     | Empty Table      | 손님이 없는 테이블      |
| 주문 테이블 목록 | Order Table List | 등록되어 있는 주문 테이블 목록      |

### 주문 (Order)
| 한글명    | 영문명              | 설명                                    |
|--------|------------------|---------------------------------------|
| 주문     | Order            | 메뉴를 접수하는 단위                           |
| 주문 유형  | Order Type       | 메뉴가 손님에게 전달되는 방법으로 매장, 포장, 배달 주문이 있다. |
| 매장 주문  | Eat-In Order     | 매장에 방문하여 메뉴를 주문하는 유형                  |
| 포장 주문  | Take-Out Order   | 매장에서 메뉴를 받아가는 주문 유형                   |
| 배달 주문  | Delivery Order   | 원하는 배달 장소에서 메뉴를 받는 주문 유형              |
| 배달 대행사 | Kitchen Riders   | 주문된 메뉴를 배달하는 업체                       |
| 접수 대기  | Waiting          | 주문을 요청하는 상황                           |
| 주문 접수  | Order Accepted   | 요청한 주문을 수락된 상황                        |
| 주문 서빙  | Order Served     | 주문이 준비된 상황                            |
| 주문 배달  | Order Delivering | 배달 주문의 배달이 시작한 상황                     |
| 배달 완료  | Order Delivered  | 배달 주문의 배달이 완료된 상황                     |
| 주문 완료  | Order Completed  | 주문된 메뉴가 전달 된 상황                       |
| 주문 목록  | Order List       | 등록되어 있는 주문 목록                           |

## 모델링
