package com.guighost.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author GuiGhost
 * @date 2021/03/31
 * @className User()
 * 描述：
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
//在企业中，所有的pojo类都会序列化
public class User implements Serializable {
    private String name;
    private Integer age;
}
