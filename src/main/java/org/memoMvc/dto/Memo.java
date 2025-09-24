package org.memoMvc.dto;

/*
create table memo(
    id varchar2(20) not null,
    email varchar2(20) not nill,
    content varchar22(100)
)

 */

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Memo {
    private String id;
    private String email;
    private String content;

    public Memo() {
        this.content = content;
    }
}