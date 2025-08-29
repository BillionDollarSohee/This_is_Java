2025년 8월 29일
지하철에서 다형성 코드를 보면서 출근하다보니
어제의 과제에서 수정해야 할  사항

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jumin;

        do {
            System.out.print("please Input (Ex: 990101-1234567): ");
            jumin = sc.nextLine();

            if (!Ex07_String_Total_Quzi.juminDisplay(jumin)) {
                System.out.println("Not Jumin.");
                continue;
            }

            if (!Ex07_String_Total_Quzi.Validator(jumin)) {
                System.out.println("Noy first number is 1~4.");
                continue;
            }

            // 올바른 주민번호라면 성별 출력
            Ex07_String_Total_Quzi.gender(jumin);
            break; 

        } while (true);

        sc.close();
        

    }
}
        
// 주민번호 14자리인지 확인 t/f 최대한 짧게
// 뒷번호 1~4만 허옹 t/f
// 1,3, 남자 2,4, 여자
            
class Ex07_String_Total_Quzi {

    static boolean juminDisplay(String jumin) {
        return jumin.matches("\\d{6}-\\d{7}");
    }

    static boolean Validator(String jumin) {
        char firstNum = jumin.charAt(7);
        return firstNum == '1' || firstNum == '2' || firstNum == '3' || firstNum == '4';
    }

    static void gender(String jumin) {
        char firstNum = jumin.charAt(7); // 뒷자리 첫 숫자
        if (firstNum == '1' || firstNum == '3') {
            System.out.println("man");
        } else if (firstNum == '2' || firstNum == '4') {
            System.out.println("woman");
        }
    }
}
```




println만들기
```
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Ssystem.out.add("어떤 함수야?");
		Ssystem.out.add(100);
    }
}

class Ssystem {
    public static final print out;
        static {
            out = new print();
        }
}

class print {
    void add(int i) {System.out.println(i);}
    void add(String s) {System.out.println(s);}
}
```

클래스 안에 클래스 두지 말것
변수명 확인 잘할것
