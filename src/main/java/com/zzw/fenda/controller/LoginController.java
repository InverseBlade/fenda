package com.zzw.fenda.controller;

import com.alibaba.fastjson.JSONObject;
import com.zzw.fenda.dao.UserDao;
import com.zzw.fenda.po.User;
import com.zzw.fenda.util.Functions;
import com.zzw.fenda.util.JsonR;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserDao userDao;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public JsonR login(String code,
                       String avatarUrl,
                       Integer gender,
                       String nickname,
                       HttpServletRequest request) {

        String res, param;

        param = String.format(
                "appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",
                "wxc6527edcf40e4a19",
                "16489b7a6d830c0fdc05d14e2c04fa58",
                code
        );
        res = sendGet("https://api.weixin.qq.com/sns/jscode2session", param);
        JSONObject root = JSONObject.parseObject(res);

        String sessionId = root.getString("session_key");
        String openId = root.getString("openid");
        String receipt;
        Integer uid;

        try {
            User user;
            //判断是否第一次使用
            if ((user = userDao.selectByOpenId(openId)) == null) {
                user = new User();
                user.setNickname(nickname)
                        .setGender(gender)
                        .setPhoto(avatarUrl)
                        .setOpenid(openId);
                userDao.insertAndGetUId(user);
            }
            uid = user.getUid();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String hash = Functions.md5(uid + "qa+angle" + timestamp, "its unbroken");

            receipt = uid + "|" + timestamp + "|" + hash;
            Base64.Encoder encoder = Base64.getEncoder();
            receipt = encoder.encodeToString(receipt.getBytes(StandardCharsets.UTF_8));

            return JsonR.createSuccess(receipt);

        } catch (Exception e) {
            return JsonR.createFail(e.getMessage());
        }
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    private String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

}
