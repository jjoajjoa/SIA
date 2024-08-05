/* 붕어빵(객체) 만들기 */

let name = '붕어빵';
let age = 11;

// 1.붕어빵 한마리씩 빚어내기
let fish1 = {
    name: '붕어빵1',
    age: 21,
    swim: function() {
        console.log('붕어빵 헤엄치기');
    } //익명함수
}
console.log(`붕어빵 이름: ${fish1.name}`);
fish1.swim();

// 2.붕어빵 틀 만들기
class Fish {
    constructor(name, age) { //생성자
        this.name = name;
        this.age = age;
        //this.가 없는데 어떻게 동작하지
        //자동으로 만들어주기 때문에!
        //대신 저 형태(this.어쩌구)는 꼭 지켜줘야함
    }
    swim() {
        console.log('붕어가 헤엄치는 중');
    }
}
let fish2 = new Fish('붕어빵2', 2);
console.log(`fish2 이름: ${fish2.name}`);