import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Dept {
    private int deptno;
    private String dname;
    private String loc;
}