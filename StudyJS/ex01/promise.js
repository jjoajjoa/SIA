//일반함수
function add1(a, b) {
    return a + b;
}
const result = add1(10, 10);
console.log(`더하기 결과: ${result}`);
//화살표함수
const add2 = (a, b) => {
    return a + b;
}
//콜백함수 (더하기)
const add3 = (a, b, callback) => {
    const result = a + b;
    callback(result);
}
add3(10, 10, (result) => {
    console.log(`콜백함수 안에서의 더하기 결과: ${result}`);
})
//콜백함수 (나누기)
// const divide = (a, b, callback) => {
//     const result = a / b;
//     callback(result);
// }
// divide(100, 0, (result) => {
//     console.log(`콜백함수 안에서의 나누기 결과: ${result}`);
// }) //Infinity가 출력됨 -> 에러라고 표시하고싶은데..
const divide1 = (a, b, callback) => {
    if (b == 0) {
        callback('두번째 값이 없어용', null);
        return;
    }
    const result = a / b;
    callback(null, result);
}
divide1(100, 0, (err, result) => {
    if (err) {
        console.error(`에러발생: ${err}`);
        return;
    }
    console.log(`콜백함수 안에서의 나누기 결과: ${result}`);
})
//아 이거 너무 복잡한데...
//콜백함수를 쓸 수 밖에 없는 상황에서는 어짜피 써야함
//예를 들어 setTimeout 같은 함수
//브라우저에서 요청 -> 웹서버가 응답
//1.장비랑 케이블이 엄청 연결 되어있음(중간에 장비를 엄청 많이 거침)
//중간에 장비 성능이 떨어지면 응답이 언제 올지 모르게 됨
//응답을 받아서 콜백함수를 실행한다고 할 때, 콜백이 언제 실행될지 알 수가 없어짐
//2.관계형DB에서 테이블로 만드는 이유: 찾기 편하게 하기 위해
//DB가 실제로는 서버처럼 요청가능, 응답 받을 수 있음
//그래서 DB도 응답이 언제 올지 몰라
//예시를 만들어보자
const divide2 = (a, b, callback) => {
    setTimeout(() => {
        if (b == 0) {
            callback('두번째 값이 없어용', null);
            return;
        }
        const result = a / b;
        callback(null, result);
    }, 1000)
}
divide2(100, 10, (err, result) => {
    if (err) {
        console.error(`에러발생: ${err}`);
        return;
    }
    console.log(`콜백함수 안에서의 나누기 결과: ${result} 68라인`);
})
const add4 = (a, b, callback) => {
    setTimeout(() => {
        const result = a + b;
        callback(null, result);
    }, 500);
}
add4(10, 10, (err, result) => {
    console.log(`콜백함수 안에서의 더하기 결과: ${result} 77라인`);
})
//출력 결과 77라인이 먼저 나옴
//순서대로 실행되야하는게 맞지만 setTimeout으로 인해 시간 차이가 생겨버림
//68라인:1초뒤 | 77라인:0.5초뒤
//=> 서버 응답이 순서대로 오지 않을 수도 있다
//
//리턴은 결과가 아래쪽 구멍으로 떨어지게 만들어줌 -> 결과가 나올때까지 대기함
//대기하지 않도록 하게 만들어주는 방법이 콜백함수
//웹서버는 요청이 들어오는데로 큐에 쌓아둠
//언제 요청했는지에 따라 순서대로 처리
//그 과정이 성능이 너무떨어짐
//요청들어와? 실행먼저해 들어오는데로 걍 실행해(콜백등록해)
//각각 결과가 만들어지면 그때 응답해

//나누기 결과를 가지고 더해주고 싶다면?
divide2(100, 10, (err, result) => {
    if (err) {
        console.error(`divide2 에러발생: ${err}`);
        return;
    }
    console.log(`콜백함수 안에서의 나누기 결과: ${result}`);

    add4(result, 10, (err, result2) => {
        if (err) {
            console.error(`divide2 add4 에러발생: ${err}`);
            return;
        }
        console.log(`콜백함수 안에서의 더하기 결과: ${result2}`);
    })
})
//다른 개발자가 만든거 우리는 사용만 할 수 있음
//더하기나 나누기 결과가 언제 올지 몰라
//근데 나눈 결과로 더해야해
//그럼 이런 형태가 나올 수 밖에 없음
//
//순서대로 하고싶으면 콜백 안에 다른 함수를 넣을 수 밖에 없음
//계속 들여쓰기 되는 형태
//들여쓰기가 10개까지 늘어나는 상황이 있을 수 있음
//이거 너무 별론데 정리 함 해야겠는데
//
//정리 함 해주자고
// Promise -> 사용을 최대한 단순하게 만든 방법 -> async awite
//
//결론: 
//응답이 언제 올지 모르는 상황이 웹서버에서는 빈번하다
//그 응답을 순서대로 처리해주고 싶다
//그럴때 사용하는 async awite <- 꼭 알아둬야 함!

// Promise 사용해보기
//복잡해보이지만 간단해지고있는 과정
const addFunc = (a, b) => new Promise((resolve, reject) => {
    add4(a, b, (err, result) => {
        if (err) {
            reject(err);
            return;
        }
        resolve(result);
    })
})
// Promise는 중괄호 없어도 됨
const divideFunc = (a, b) => new Promise((resolve, reject) => {
    divide1(a, b, (err, result) => {
        if (err) {
            reject(err);
            return;
        }
        resolve(result);
    })
})
// 그러면 이렇게 간단하게 바뀔수있음
const doCalc = async () => {
    try {
        const result1 = await divideFunc(200, 10); //콜백이아니게됨
        console.log(`나눈결과: ${result1}`);
        const result2 = await addFunc(result1, 10);
        console.log(`더한결과: ${result2}`);
    }
    catch (err) {
        console.error(`doCalc에서 에러 발생: ${err}`);
    }
}
doCalc();