package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.DeliveryStatus;
import jpabook.jpashop.domain.Order;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name="delivery_id")
    private Long id;


    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;


    //ordinal 이면 다른 중간에 다른 상태가 생기면 망한다.
    //ORDINAL 절대 쓰지 말고 STRING 쓰자
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //Ready , comp
}
