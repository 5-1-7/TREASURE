package com.notice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notice.pojo.NoticePojo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试底层转Json对象
 * Json对象是跨平台的数据格式，可以在不同的客户端进行快捷解析
 * 项目添加SpringWeb依赖的时候，默认添加了com.fasterxml.jackson.core依赖
 * 该依赖可以将Json字符串与Java对象互转
 * on 2021/3/14 19:24
 */

@SpringBootTest
public class JsonTest {
    @Test
    void testJsonObject() throws JsonProcessingException {
        NoticePojo notice01= new NoticePojo();
        notice01.setTitle("Json");
        notice01.setId(101L);
        notice01.setStatus("0");
        notice01.setType("1");

        /*基于jackson中ObjectMapper类的实例将Pojo转换为json格式字符串
        将对象转换为json字符串时，pojo对象需要提供get方法*/
        String jsonString = new ObjectMapper().writeValueAsString(notice01);
        System.out.println(jsonString);

        //将Json格式的字符串转换为NoticePojo类型的对象，须要提供对应的set方法
        NoticePojo notice02= new ObjectMapper().
                readValue(jsonString, NoticePojo.class);
        System.out.println(notice02);
    }
}
