/** 여러 개의 값을 하나의 변수 상자에 넣기 */

let names = ['홍길동1', '홍길동2', '홍길동3'] //세칸 세개 배열 만들어짐
console.log(`names 배열 크기: ${names.length}`) //names 배열 크기: 3
let first = names[0];
console.log(`첫번째 칸: ${first}`); //첫번째 칸: 홍길동1
console.log(`names의 타입: ${typeof (names)}`); //names의 타입: object
console.log(`첫번째 칸의 타입: ${typeof (names[0])}`); //첫번째 칸의 타입: string
let fish1 = { name: '붕어빵1', age: 1 };
console.log(`fish1의 타입: ${typeof (fish1)}`); //fish1의 타입: object
// 왜 배열인데 타입이 object 일까
// JS가 원래 그럼
// 그럼 어떻게 구별하지
if (Array.isArray(names)) {
    console.log(`names는 배열이에용`);
} // 얘만 나옴
if (Array.isArray(fish1)) {
    console.log(`fish1은 배열이에용`);
}


/** 배열에서 요소 꺼내기 */
// C스타일 for문 (성능저하)
for (let i = 0; i < names.length; i++) {
    console.log(`names의 ${i}번째 요소: ${names[i]}`);
}
// forEach문 (권장!)
names.forEach((value, index) => {
    console.log(`names의 ${index}번째 요소: ${value}`);
});
// for문 업그레이드
for (let name of names) {
    console.log(`names의 요소: ${name}`);
}

/** 배열에 추가하기 */
names.push('홍길동4');
console.log(`names 전체 출력: ${JSON.stringify(names)}`);
// names 전체 출력: ["홍길동1","홍길동2","홍길동3","홍길동4"]
// JSON.stringify(어쩌구)
// 자바스크립트 객체 포맷 -> 자바스크립트 객체를 글자로 바꿔줌
// 실제 서버로 검색한다는 가정 -> 결과로 가져온 속성을 JSON 포멧으로 바꿔(== 글자로 바꿔) -> 그걸 나한테 던져
// 자바스크립트의 붕어빵 정보를 글자 형태로 바꿔서 전달하는 것이 JSON
// 붕어빵을 그대로 보내면 그 안에 변수상자는 내 컴퓨터의 메모리 주소가 적혀있음
// 다른 사람 컴퓨터에는 메모리의 그 위치에 다른게 들어있을 수도 있음
// json.parse 해주면 그대로 다시 복원할 수 있음
console.log(`fish1 전체 출력: ${JSON.stringify(fish1)}`);
// fish1 전체 출력: {"name":"붕어빵1","age":1}
// 함수는 보여주지 않음
// JSON의 주목적이 데이터를 보여주기위함이기 때문에


/** 붕어빵 안에 배열을 넣어보자 */
const fish2 = {
    name: '붕어빵2',
    children: [
        { name: '자식붕어빵1', age: 1 },
        { name: '자식붕어빵2', age: 2 }
    ]
}
console.log(`fish2 이름: ${fish2.name}`);
console.log(`fish2 이름: ${fish2['name']}`);
// fish2 이름: 붕어빵2
// 같은 결과가 나오는데 굳이 배열에서 name을 찾아야할까?
const attr = 'name';
console.log(`fish2 속성: ${fish2[attr]}`);
// fish2 속성: 붕어빵2
// 사용자가 화면에서 붕어빵의 이름을 가져올지, 나이를 가져올지 선택해야하는 기능이 있을 때
// 변수만 바꿔주면 되니까 자유도가 훨씬 올라가버림
console.log(`fish2의 두번째 자식 나이: ${fish2['children'][1]['age']}`);
// fish2의 두번째 자식 나이: 2