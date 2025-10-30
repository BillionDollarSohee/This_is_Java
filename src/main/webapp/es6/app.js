// javaScript 파일을 export한 데이터를 사용
// {}를 써서 여러개를 import 함
import {pi, sum} from './data.js';
console.log(pi);

const data = sum(10, 20);
console.log("data : " + data);