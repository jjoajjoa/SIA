//상속
class Fish {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    swim() {
        console.log('어푸어푸 붕어빵');
    }
}

class Shark extends Fish {

}

const fish1 = new Fish('붕어빵1', 1);
const shark1 = new Shark('상어빵1', 1);

console.log(`상어빵: ${shark1.name}, ${shark1.age}살`);