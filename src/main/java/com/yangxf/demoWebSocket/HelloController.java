/**
 * FileName: HelloController
 * Author:   linwd
 * Date:     2021/4/5 12:07
 * Description: 测试控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangxf.demoWebSocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试控制器〉
 *
 * @author linwd
 * @create 2021/4/5
 * @since 1.0.0
 */
@RestController
public class HelloController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greetings(Message message) throws Exception {
        return message;
    }
}
