import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private int empno;
    private String ename;
}