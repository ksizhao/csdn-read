import java.util.ArrayList;
import java.util.List;

/**
 * @Author ： YingZhang
 * @Description:
 * @Date : Create in 5:11 PM 1/19/2019
 */
public class UrlTest {
    public static void main(String[] args){
//        Map<String,Object> map = new HashMap<>();
//        map.put("loginType","1");
//        map.put("pwdOrVerifyCode","zhangying123");
//        map.put("userIdentification","weixin_44561366");
//        System.out.println(HttpUtils.postWithHttp(map, "https://passport.csdn.net/v1/register/pc/login/doLogin"));
//
//        HttpUtils.getWithHttp("https://blog.csdn.net/qq_35720307/article/list/1");


        String ss = " ";

        char[] charArray = ss.toCharArray();

        int max = 1;
        for(int i = 0;i<charArray.length;i++) {
            List<Character> lists = new ArrayList<Character>();
            for (int j = i; j < charArray.length; j++) {
                char s = charArray[j];
                if (lists.contains(s)) {
                   break;
                } else {
                    lists.add(s);
                }
            }
            if(lists.size() > max){
                max = lists.size();
            }
        }
        System.out.println(max);
    }
}
