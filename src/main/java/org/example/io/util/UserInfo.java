package org.example.io.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class UserInfo implements Serializable { // 이 제품은 직렬화가 가능합니다.(레고)
    private String userId;
    private String userPwd;
    private int age;
}
