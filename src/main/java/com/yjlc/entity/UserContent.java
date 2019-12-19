package com.yjlc.entity;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * Created by Liuziyuan on 2019/9/21.
 */
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
@Getter
@Setter
public class UserContent {
    private String username;
    private String pwd;
}
