package com.tom.blog.redis;

import org.springframework.stereotype.Component;

/**
 * @Author ： YingZhang
 * @Description:
 * @Date : Create in 4:50 PM 3/4/2019
 */
@Component
public class RedisTest {
//
//    @Autowired
//    RedisTemplate redisTemplate;
//
//    @Autowired
//    FireDeviceRepository fireDeviceRepository;
//
//    public void doTest(){
//        FireDevice fireDevice = new FireDevice();
//        fireDevice.setBusinessDeviceNo("1");
//        fireDevice.setId(11L);
//        fireDevice.setPoint("22");
//        String id = fireDevice.getId()+"";
//        redisTemplate.opsForValue().set(id,fireDevice);
////        System.out.println(redisTemplate.opsForValue().get("11"));
////        System.out.println(redisTemplate.opsForValue().get("12"));
//
//            insert();
//
////            update();
////            updateAndQuery();
//    }
//
//    private void update() {
//        Optional<FireDevice> optional = fireDeviceRepository.findById(1L);
//        FireDevice fireDevice = optional.get();
//        fireDevice.setLoop("12345");
//        fireDeviceRepository.save(fireDevice);
//    }
//
//    private void updateAndQuery() {
//        Optional<FireDevice> optional = fireDeviceRepository.findById(1L);
//        System.out.println(optional.get().getStatus());
//        System.out.println(optional.get());
//    }
//
//
//    private void insert(){
//        FireDevice fireDevice = new FireDevice();
//        fireDevice.setPoint("123");
//        ArrayList<String> list = new ArrayList<>();
//        list.add("123");
//        list.add("1234");
//        fireDevice.setStatus(list);
//        fireDeviceRepository.save(fireDevice);
//    }



}
