/**
 * FileName: Message
 * Author:   linwd
 * Date:     2021/4/5 12:10
 * Description: DTO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangxf.demoWebSocket;

/**
 * 〈一句话功能简述〉<br> 
 * 〈DTO〉
 *
 * @author linwd
 * @create 2021/4/5
 * @since 1.0.0
 */
public class Message {
    private String name;
    private String context;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Message() {
    }
}
