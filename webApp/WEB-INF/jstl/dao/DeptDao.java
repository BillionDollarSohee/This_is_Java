import java.util.List;
import java.util.ArrayList;

public class DeptDao {
    public List<Dept> getDeptList() {
        // DB 연결 select 결과로 부서 4개가 온 시나리오
        List<Dept> list = new ArrayList<>();
        list.add(new Dept(10, "aa", "aaa"));
        list.add(new Dept(20, "bb", "bbb"));
        list.add(new Dept(30, "cc", "ccc"));
        list.add(new Dept(40, "dd", "ddd"));

        return list;
    }
}