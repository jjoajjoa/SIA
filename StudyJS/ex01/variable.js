console.log('hi');

/* 변수상자 */
let name1;
name1 = '홍길동1';
console.log(`   name1의 자료형: ${typeof(name1)}`);
//string
let age = 21;
console.log(`   age의 자료형: ${typeof(age)}`);
//number
let visible = true;
console.log(`   visible의 자료형: ${typeof(visible)}`);
//boolean
let name2;
console.log(`   name2의 자료형: ${typeof(name2)}`);
//undefined
/* JS는 값을 최초에 할당받을 때 자료형이 결정된다 */
/* 그래서 값을 안집어넣어주면 undefined가 나오게 됨 */
console.log(`이름: ${name1}, 나이: ${age}`);

if (typeof(name2) == 'undefined') {
    console.log('name2의 자료형이 결정되지 않았어용');
} else {
    console.log('자료형이 결정되어있네용');
}

name2 = '홍길동2';
if(name2) {
    console.log('자료형이 결정되었네용');
} else {
    console.log('name2의 자료형이 결정되지 않았어용');
}


let age2 = '22';
let age3 = Number(age2);
console.log(`   age3의 자료형: ${typeof(age3)}}`); //형변환

let age22 = '22가';
let age33 = Number(age22);
console.log(`   age22의 값: ${age22}`)
// NaN : Not a Number 숫자가 아닌데 숫자로 바꾸려해서
// 타입은 Number로 나옴 -> 숫자가 들어갈 크기인데 숫자가 아닌게 들어가있다