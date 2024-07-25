/* 함수 */

// 매개변수 없음
function print1() {
    console.log('hi');
}
print1();

// 매개변수 한개
function print2(a) {
    console.log(`전달받은값: ${a}`);
}
print2(21);

// 매개변수 두개
function print3(a, b) {
    console.log(`전달받은값: ${a}, ${b}`);
    return a + b;
}
let result = print3(10, 10);
console.log(`print3 결과: ${result}`);

console.log(`print1의 자료형: ${typeof (print1)}`) //function
// 자료형이 function?!
// JS에서는 함수가 변수에 들어갈 수 있다! == 함수를 1급객체로 담는다
// 왜 굳이 넣을까 : 굉장히 다양한 형태로 코드를 만들 수 있어짐
let show1 = print1;
show1();
// 변수에 함수가 들어갈 수 있는 예시
// 그래서 자료형에 function이라는 단어가 나올 수 있게 됨
let show2 = function print4() {
    console.log('print4 호출됨');
}
show2();
// 함수를 만들면서 변수에 넣어주는 것도 가능
let show22 = function () {
    console.log('print4 호출됨');
}
show22();
// 어차피 변수에 들어갈거라서 함수 이름을 그냥 없애버림
let show3 = () => {
    console.log('print5 호출됨');
}
show3();
// 화살표함수 형태로 변경 가능


/* 콜백함수 */
function add1(a, b) {
    return a + b;
}
let res = add1(10, 11);
console.log(`더하기결과: ${res}`);
// 위: 일반적인 함수 | 아래: 콜백함수
function add2(a, b, c) {
    c(a + b);
}
add2(10, 11, (result) => {
    console.log(`더하기결과: ${result}`);
})


/** 함수 다시 정리 */
function addFunc1(a, b) { return a + b; }
const res1 = addFunc1(10, 20);
console.log(`addFunc1 결과: ${res1}`);

// 화살표함수로 바꾸기
const addFunc2 = (a, b) => { return a + b; }

// 콜백함수 사용
function addFunc3(a, b, callback) { callback(a + b); }
addFunc3(11, 12, (res3) => { console.log(`addFunc3 결과: ${res3}`); })

// 원래는 이렇게 했었다
function addFunc4(a, b) {  return a + b; }
addFunc3(11, 12, function (res4) { console.log(`addFunc4 결과: ${res4}`); })

// 익명함수가 아니라면 이렇게
function addFunc5(a, b, callback) { callback(a + b); }
// const callback = (res5) => { console.log(`addFunc5 결과: ${res5}`); }
function callback(res5) { console.log(`addFunc5 결과: ${res5}`); }


/* for문이랑 콜백함수써서 1~10 더하기 */
// for문 사용
let sum = 0;
for (let i = 0; i < 10; i++) {
    sum = sum + (i + 1);
}
console.log(`1부터 10까지의 누적합: ${sum}`);
// 함수로 분리
let calc = (start, end) => {
    sumsum = 0;
    for (let i = start; i < end + 1; i++) {
        sumsum += i;
    }
    return sumsum;
}
let calcRes1 = calc(0, 10);
console.log(`1부터 10까지의 누적합: ${calcRes1}`);
let calcRes2 = calc(0, 100);
console.log(`1부터 100까지의 누적합: ${calcRes2}`);
// 콜백함수로 바꾸기
let calc2 = (start, end, callback) => {
    sumsum = 0;
    for (let i = start; i < end + 1; i++) {
        sumsum += i;
    }
    callback(sumsum);
}
calc2(0, 10, (result123) => {
    console.log(`1부터 10까지의 누적합: ${result123}`);
});
// 과제수행
function sumTotal(x, y, sumFunc) {
    if (x > y) {
        console.log('뒷숫자가 더 커야함');
    } else {
        z = 0;
        for (let i = x; i < y + 1; i++) {
            z += i;
        }
        sumFunc(z);
    }
}
sumTotal(1, 11, (result) => {
    console.log(`누적합 결과: ${result}`);
})