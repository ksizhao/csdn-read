package com.tom.blog;

import com.tom.blog.redis.RedisTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ： YingZhang
 * @Description:
 * @Date : Create in 6:57 PM 1/15/2019
 */
@Component
@Slf4j
public class ApplicationRunnerImpl {

    @Value("${test.pro}")
    private String v1;

    @Autowired
    RedisTest redisTest;

    private volatile int count = 0;

//    @Override
//    public void run(ApplicationArguments args) {
////        redisTest.doTest();
//        blogRead();
//
//    }

    @PostConstruct
    public void blogRead() {
        doBlogRead();
    }

    private void doBlogRead() {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        while (true) {
            try {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" + v1);

                Map<String, Object> map = new HashMap<>();
                map.put("loginType", "1");
                map.put("pwdOrVerifyCode", "3.1415926zx");
                map.put("userIdentification", "17816873148");
                map.put("uaToken", "122#HlDYxE+uEEx8ZEpZMEpJEJponDJE7SNEEP7rEJ+/7SRECCQLpo7iEDpWnDEeK51HpyGZp9hBuDEEJFOPpC76EJponDJL7gNpEPXZpJRgu4Ep+FQLpoGUEJLWn4yP7SQEEyuLpERnVTL6prZxsyyrvw87qxv+W0T+GThxCnHJXsCtPMsDyaa9gMbiEzU+UTY6e9Odxg8EawDW9FHFdhGEoboclFW8Eqw7prVf3Tglayw897q5J22UewF3UtmaumPY12VmCzDp0+GDqMfoVvJlYjR4lqaEnXfr8oL6+cdyX92tqXoPDokungplul5EELXrGCpiCU5DaC3mqWfWEJpanS+ituaHDtVZ85G6JDEERFtDqMfbDEpxnSp1uOIEEL7Z8CLUJ4bEyF3mqW32D5pangL4ul0EDLIL8oL6xN8EyB3maMV5x4bWy+51Z5nPpG8WldgKugR84Y49ddD4WlCa56msAlHSajtRftVB4Gqd+06t8YcBKxwVAL5ETeH1ZaEc3DUI4HSVGhZbzq6qTjvh4tmIUoTGX5ZjchaznzbnjY3LGh7//udzr7KQ5I2YK7ihQ0IZ5e1Oh+MCchOvlJCJgDiuLu8xs6W+SdwFL6YjGuLS2eSiVKvboTTqXvWYTNyRFUqMH+StocJkx4IxBHusegFjvs21LvPPww6kyq63chCTnz85HHuM0oFqnkhaFdxzRuzqe6PY5o/F9aeFIgBQL9yVl7Ghz7ofLNFj9/8lQ0joQnFtBpOgexuSf7jqVqZOtQPbKaHoOuTmNCWB/6OgktPor+R5NneXNcM9Fnz0MtUG1syzUa/CLu513shBrb0BHvp4tBg+Dz7caPevU1oZ/yHvpQm3mePl/x2MVba+o2kbkDtIX78xZmfnqYlsUnFkC6CVhLnw6sEtjMFah2ERG1613kdJ+Uaw58tyccH3NQi6g4PB9cFlzbqzy86n6JEZCjhcSkkoJWVglPwSW8WS2T6NJnyqih0pLvXp1NX3uAuYDHWsa28AYrxl1darEsKM0Gyqo2T0tPlq9T2OQumrn2LgCadgwSN8yx1YMhPCVdEGOO8brnmU8e31Bg2UiMuFRopl4lY8js6Suf+b8vsfRU/Yr7onohGnrbYcdANzGutWfdctMoi9VcoYPkN2VVgMV81Nx3FumgzdXVozkx5xNEMPRX8p3MZ2XsO7uJClxix5U3D83tSJqnn+KTX2gv0H8/Zdh77ffOF093MHoBVSXnpe+pPzcrPLGLPPhyW8mtkF05e1pO2BZGBpahlPvWdySZUljrVmwC/gW2fZFVRar5FTb73Nh/c+D10Ax8+V8j8jmwW1KLMV4WZx4J2FevFAGiVjGLML5u1//LlMbMaMQM/eIoPLVgdqoiIInY1HhUl/u3Z6LGU/HG3AchujK4Udlp4YR6+F8PMfjCxL0QHOu4cmCVRukz/z5tojsMbfY4TaUC/Nr222vm2VdkMVRxBTnW+jX4UV3g0jMDaBtYQKeYwTXKSI5E==");
                map.put("webUmidToken", "TEB0BF4E8722915C5BE7A9E6511AE94309D3EB14C0E65219DC3FBCF3352");
                System.out.println(HttpUtils.postWithHttp(map, "https://passport.csdn.net/v1/register/pc/login/doLogin"));
                Set<String> urls = new HashSet<>();
                List<String> listurl = new ArrayList<>();
                listurl.add("https://blog.csdn.net/nimazhao/article/details/104029979");
//        listurl.add("https://blog.csdn.net/qq_35720307/article/list/2");
//        listurl.add("https://blog.csdn.net/qq_35720307/article/list/3");
//        listurl.add("https://blog.csdn.net/qq_35720307/article/list/4");

//                for (String s : listurl) {
//                    String content = HttpUtils.getWithHttp(s);
//                    //System.out.println(content);
//                    int start = 0;
//                    int end = 0;
//                    String searchKey = "https://blog.csdn.net/nimazhao/article/details/";
//                    while (content.indexOf(searchKey, start) != -1) {
//                        start = content.indexOf(searchKey, start);
//                        end = start + searchKey.length() + 8;
//                        String url = content.substring(start, end);
//                        urls.add(url);
//                        start = end;
//                    }
//                }

                urls.addAll(listurl);
                System.out.println("请求url：" + urls);
                urls.forEach(url -> {
                    threadPool.execute(() -> {
                        HttpUtils.getWithHttp(url);
                    });

                });
//                if(count%100 == 1){
//                log.info("循环次数" + ++count);}
                Thread.sleep(40000);
                log.info("循环次数" + ++count);
            } catch (InterruptedException e) {
                log.error("error message :", e);
            }
        }

    }
}