package org.MVC.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private LocalDateTime hiredate;
    private int sal;
    private int comm;
    private int deptno;

}
