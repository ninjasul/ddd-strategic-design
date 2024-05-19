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

### 상품

| 한글명   | 영문명            | 설명                                                     |
|-------|----------------|--------------------------------------------------------|
| 상품    | Product        | 키친포스에서 판매될 수 있는 상품 이름, 상품 가격을 속성으로 가지는 품목              |
| 상품 이름 | Product Name   | 상품의 이름                                                 |
| 상품 가격 | Product Price  | 상품의 가격                                                 |
| 상품 등록 | Create Product | 비속어가 포함되지 않은 상품 이름과 0원 이상의 상품 가격을 가진 상품을 키친포스에 등록하는 행위 |
| 비속어   | Profanity      | 상풍 이름에 포함할 수 없는 욕설 또는 비속어                              |
| 상품 목록 | Product List   | 0개 이상의 상품을 모은 목록                                    |


### 메뉴 그룹

| 한글명      | 영문명                | 설명                                                          |
|----------|--------------------|-------------------------------------------------------------|
| 메뉴 그룹    | Menu Group         | 0개 이상의 메뉴가 모여있는 집합                                          |
| 메뉴 그룹 이름 | Menu Group Name    | 메뉴 그룹이 가지는 이름. 메뉴 그룹의 이름을 입력해야 만 메뉴 그룹을 등록할 수 있음.           |
| 메뉴 그룹 등록 | Create Menu Group  | 메뉴 그룹을 키친포스에 등록하는 행위. 메뉴를 등록하려면 해당 메뉴가 속할 메뉴 그룹을 우선 등록해야 함. |
| 메뉴 그룹 목록 | Menu Group List    | 0개 이상의 메뉴 그룹을 모은 목록                                        |


### 메뉴

| 한글명      | 영문명                | 설명                                                                                |
|----------|--------------------|-----------------------------------------------------------------------------------|
| 메뉴       | Menu               | 한 개 이상의 메뉴 상품으로 이루어진 상품의 집합                                                       |
| 메뉴 이름    | Menu Name          | 메뉴의 이름. 비속어를 포함할 수 없음.                                                            |
| 메뉴 가격    | Menu Price         | 메뉴의 가격. 메뉴의 가격은 0원 이상이어야 하고 해당 메뉴에 속한 메뉴 상품 금액의 합보다 클 수 없음.                       |
| 메뉴 상품    | Menu Product       | 등록된 상품들 중 특정 메뉴에 속한 상품                                                            |
| 메뉴 등록    | Create Menu        | 메뉴 이름, 메뉴 가격, 한 개 이상의 등록된 상품으로 메뉴 상품을 구성하여 메뉴를 등록하는 행위                            |
| 비속어      | Profanity          | 메뉴 이름에 포함할 수 없는 욕설 또는 비속어                                                         |
| 메뉴 노출    | Display Menu       | 메뉴를 손님에게 노출하는 행위. 손님은 노출된 메뉴만 주문할 수 있음.                                           |
| 메뉴 숨김    | Hide Menu          | 메뉴를 고객에게 노출하지 않고 숨기는 행위. 숨겨진 메뉴는 고객이 주문할 수 없음.                                    |
| 메뉴 가격 변경 | Change Menu Price  | 메뉴 가격을 변경하는 행위. 메뉴 가격 변경 시 메뉴 가격은 메뉴는 0원 이상이어야 하고 해당 메뉴에 속한 메뉴 상품 금액의 합보다 클 수 없음. |
| 메뉴 목록    | Menu List          | 0개 이상의 메뉴를 모은 목록                                                                  |


### 주문 테이블

| 한글명        | 영문명                      | 설명                                          |
|------------|--------------------------|---------------------------------------------|
| 주문 테이블     | Order Table              | 매장 내에서 손님이 이용할 수 있는 테이블.                    |
| 주문 테이블 이름  | Order Table Name         | 주문 테이블의 이름. 주문 테이블 이름은 비워둘 수 없음.            |
| 방문 손님 수    | Number Of Guests         | 매장을 방문하여 주문 테이블을 사용하는 손님의 수.                |
| 주문 테이블 등록  | Order Table Registration | 주문 테이블을 등록하는 행위                             |
| 빈 테이블      | Empty Order Table        | 손님이 앉지 않아서 사용 가능한 테이블                       |
| 주문 테이블 사용  | Sit Order Table          | 손님이 주문 테이블에 앉아서 해당 주문 테이블을 사용 중인 상태로 만드는 행위 |
| 주문 테이블 비움  | Clear Order Table        | 사용 중이었던 주문 테이블을 빈 테이블로 만드는 행위               |
| 방문 손님 수 변경 | Change Number Of Guests  | 주문 테이블을 사용하는 방문 손님 수를 변경하는 행위               |
| 주문 테이블 목록  | Order Table List         | 0개 이상의 주문 테이블을 모은 목록                       |


### 주문

### 주문 공통
| 한글명      | 영문명            | 설명                                                                                          |
|----------|----------------|---------------------------------------------------------------------------------------------|
| 손님       | Customer       | 음식점에서 음식을 주문하는 고객                                                                           |
| 매장       | Restaurant     | 키친포스를 사용하여 손님에게 음식을 판매하는 식당                                                                 |
| 주문       | Order          | 손님이 매장의 메뉴를 구매한 구매 정보                                                                       |
| 주문 항목 수량 | Order Quantity | 손님이 구매한 주문 항목의 개수                                                                           |
| 주문 등록    | Create Order   | 손님이 매장에 있는 메뉴를 구매하는 행위                                                                      |
| 주문 상태    | Order Status   | 주문이 접수 되기 전부터 완료될 때까지의 상태. 주문 상태에는 `접수 대기 중`, `접수 완료`, `서빙 완료`, `배달 중`, `배달 완료`, `완료` 가 있음. |
| 주문 유형    | Order Type     | 손님이 주문할 수 있는 주문의 방식. 주문 유형에는 `배달 주문`, `포장 주문`, `매장 내 주문`이 있음.                               |

### 배달 주문

| 한글명          | 영문명               | 설명                                                                                          |
|--------------|-------------------|---------------------------------------------------------------------------------------------|
| 배달 주문        | Delivery Order    | 손님이 주문을 하면 배달 대행사를 통해 특정 장소로 배달되는 주문                                                        |
| 배달 주소        | Delivery Address  | 손님의 음식이 배달될 주소. `배달 주문` 시 비어 있으면 안됨.                                                        |
| 배달 대행사       | Delivery Agency   | 배달을 전문으로 하는 외부 대행사. 매장이 배달 대행사에게 조리된 배달 요청을 하면 배달 주소로 음식을 배달 해 줌.                           |
| 주문 상태        | Order Status      | 주문 접수 대기 부터 완료될 때까지 상태. 배달 주문의 상태에는 `접수 대기`, `접수 완료`, `서빙 완료`, `배달 시작`, `배달 완료`, `완료` 가 있음. |
| 접수 대기 중 상태   | Waiting           | 손님이 `배달 주문`을 했으나 매장이 `배달 주문`을 아직 접수하지 않은 상태                                                 |
| 접수 완료 상태     | Accepted          | 매장이 `배달 주문`을 접수하고 음식을 조리 중인 상태                                                              |
| 서빙 완료 상태     | Served            | 매장이 배달 대행사에게 배달 될 음식을 제공한 상태                                                                |
| 배달 중 상태      | Delivering        | 배달 대행사가 손님에게 음식을 배달하고 있는 상태                                                                 |
| 배달 완료 상태     | Delivered         | 배달 대행사가 손님에게 음식 배달을 완료한 상태                                                                  |
| 완료 상태        | Complete          | 배달 주문의 전 과정이 완료된 상태                                                                         |
| 주문 등록        | Create Order      | 손님이 매장의 메뉴를 `배달 주문` 유형으로 구매하는 행위. 주문 상태는 `접수 대기 중` 상태로 변경됨.                                 |
| 주문 접수        | Accept Order      | 매장이 손님의 주문을 접수하고 음식을 조리하기 시작하는 행위. 주문 상태는 `접수 완료` 상태로 변경됨.                                  |
| 배달 요청        | Request Delivery  | 손님에게 배달을 하기 위해 매장이 외부 배달 대행사에게 배달을 요청하는 행위.                                                 |
| 주문 서빙        | Serve Order       | 매장이 조리 완료된 음식 배달을 위해 배달 대행사에게 넘겨주는 행위. 주문 상태는 `서빙 완료` 상태로 변경됨.                              |
| 배달 시작        | Start Delivery    | 배달 대행사가 조리 완료된 음식을 배달 시작하도록 처리해 주는 행위. 주문 상태는 `배달 시작` 상태로 변경됨.                              |
| 배달 완료        | Complete Delivery | 배달 대행사가 배달 주소로 조리된 음식을 배달을 완료하는 행위. 주문 상태는 `배달 완료` 상태로 변경됨.                                 |
| 주문 완료        | Complete Order    | `배달 주문`의 모든 과정을 완료 처리 해 주는 행위. 주문 상태는 `완료` 로 변경됨.                                           |

### 포장 주문

| 한글명      | 영문명               | 설명                                                                                   |
|----------|-------------------|--------------------------------------------------------------------------------------|
| 포장 주문    | TakeOut Order     | 손님이 주문을 하고 음식이 조리되면 직접 매장에서 음식을 찾아가는 주문                                              |
| 주문 상태    | Order Status      | `접수 대기 중`부터 `완료`될 때까지의 주문의 상태. `포장 주문`의 상태에는 `접수 대기 중`, `접수 완료`, `서빙 완료`, `완료` 가 있음. |
| 접수 대기 중  | Waiting           | 손님이 `포장 주문`을 했으나 매장이 아직 주문을 접수하지 않은 상태                                               |
| 접수 완료    | Accepted          | 매장이 `포장 주문`을 접수하고 음식을 조리 중인 상태                                                       |
| 서빙 완료    | Served            | 매장이 손님에게 포장된 음식을 제공한 상태                                                              |
| 완료       | Complete          | 손님이 주문한 음식을 매장으로부터 포장 된 상태로 전달 받아 `포장 주문`의 전 과정이 완료된 상태                              |
| 주문 등록    | Create Order      | 손님이 매장의 메뉴를 `포장 주문` 유형으로 구매하는 행위. 주문 상태는 `접수 대기 중` 상태로 변경됨.                          |
| 주문 접수    | Accept Order      | 매장이 손님의 주문을 접수하고 음식을 조리하기 시작하는 행위. 주문 상태는 `접수 완료` 상태로 변경됨.                           |
| 주문 서빙    | Serve Order       | 매장이 조리 완료된 음식을 포장하여 손님에게 제공하는 행위. 주문 상태는 `서빙 완료` 상태로 변경됨.                            |
| 주문 완료    | Complete Order    | `포장 주문` 의 모든 과정을 완료 처리 해 주는 행위. 주문 상태는 `완료` 로 변경됨.                                   |

### 매장 내 주문

| 한글명     | 영문명            | 설명                                                                                      |
|---------|----------------|-----------------------------------------------------------------------------------------|
| 매장 내 주문 | Eat-In Order   | 손님이 매장 내에서 직접 식사를 하는 주문                                                                 |
| 주문 상태   | Order Status   | `접수 대기 중`부터 `완료`될 때까지의 주문의 상태. `매장 내 주문` 의 상태에는 `접수 대기 중`, `접수 완료`, `서빙 완료`, `완료` 가 있음. |
| 접수 대기   | Waiting        | 손님이 `매장 내 주문`을 했으나 매장이 아직 접수하지 않은 상태                                                    |
| 접수 완료   | Accepted       | 매장이 `매장 내 주문`을 접수하고 음식을 조리 중인 상태                                                        |
| 서빙 완료   | Served         | 매장이 `매장 내 주문`을 한 손님에게 음식을 제공한 상태                                                        |
| 완료      | Completed      | `매장 내 주문`을 한 손님이 식사를 마치고 주문 전 과정이 완료된 상태                                                |
| 주문 등록   | Create Order   | 손님이 매장의 메뉴를 `매장 내 주문` 유형으로 구매하는 행위. 주문 상태는 `접수 대기 중` 상태로 변경됨.                           |
| 주문 접수   | Accept Order   | 매장이 손님의 주문을 접수하고 음식을 조리하기 시작하는 행위. 주문 상태는 `접수 완료` 상태로 변경됨.                              |
| 주문 서빙   | Serve Order    | 매장이 조리 완료된 음식을 손님이 앉아있는 주문 테이블로 제공하는 행위. 주문 상태는 `서빙 완료` 상태로 변경됨.                        |
| 주문 완료   | Complete Order | `매장 내 주문` 의 모든 과정을 완료 처리 해 주는 행위. 주문 상태는 `완료` 로 변경됨.                                    |

## 모델링
