package com.tom.blog.redis;

import java.util.ArrayList;

/**
 * @Author ： YingZhang
 * @Description: ModbusTcp设备
 * @Date : Create in 4:32 PM 12/14/2018
 */
//@Table(name = "fire_device")
//@Entity
//@Data
//@EntityListeners(AuditingEntityListener.class)
public class FireDevice {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
//
//    @CreatedDate
//    @JsonIgnore
//    @Column(name = "create_time")
//    private Date createTime;
//
//    @LastModifiedDate
//    @JsonIgnore
//    @Column(name = "update_time")
//    private Date updateTime;

    // 设备台账共有
    private String businessDeviceNo;

    // 区域（A/B/C/D）
    private String network;
    // 回路号
    private String loop;
    // 区号
    private String zone;
    // 点号
    private String point;

    private ArrayList<String> status;

}
