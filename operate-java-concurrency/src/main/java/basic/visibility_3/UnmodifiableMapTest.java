package basic.visibility_3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import sun.plugin.javascript.JSObject;

/**
 * @Author: wy
 * @Date: 2019/5/7 16:09
 * @Description:
 */
public class UnmodifiableMapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        User user1 = new User("111");
        User user2 = new User("222");
        hashMap.put("111",user1);
        hashMap.put("222",user2);
        Map map = Collections.unmodifiableMap(new HashMap(hashMap));
        //map.put("111",user1); // 报异常
        ((User)hashMap.get("111")).setName("fdf"); // 修改正常
        System.out.println(JSONObject.toJSONString(map));
        System.out.println(JSONObject.toJSONString(hashMap));
    }

    static class User{
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
