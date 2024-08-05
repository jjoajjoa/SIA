const http = require('http');
const express = require('express');
const mariadb = require('mariadb');

const path = require('path');

const pool = mariadb.createPool({
    host: 'localhost',
    port: 4406,
    user: 'root',
    password: 'admin',
    database: 'test',
    connectionLimit: 10,
    debug: false
})

const app = express();

const router = express.Router();
app.use('/', router);

//폴더 오픈하기
app.use('/', express.static(path.join(__dirname, './public')));


//JSON.stringify의 에러 잡아줌
BigInt.prototype.toJSON = () => {
    return this.toString();
}

//SELECT
router.route('/person/list').get(async (req, res) => {
    // console.log('/person/list 요청됨')
    let conn; //여기에 커넥션 가져와서 저기에넣게되면 파이널리에서 사용할수있게됨
    try {
        conn = await pool.getConnection(); //데이터베이스연결
        const sql = `SELECT id, name, age, mobile FROM test.person`;
        const rows = await conn.query(sql, []); //에스큐엘실행
        console.log(`SQL 실행 결과: ${JSON.stringify(rows)}`);
        const output = {
            code: 200,
            message: 'OK',
            header: {},
            data: rows
        } //결과를여기넣고
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(JSON.stringify(output)); //웹에 응답으로 보냄
    } catch (err) {
        console.error(`에러발생! ${err}`)
        const output = {
            code: 400,
            message: `공습경보! ${err}`
        }
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(JSON.stringify(output));
    } finally {
        if (conn) { conn.end(); }
    }
})

//INSERT
router.route('/person/add').get(async (req, res) => {
    //요청 파라미터 확인하기
    const params = req.query;
    console.log(`params -> ${JSON.stringify(params)}`);

    let conn;
    try {
        conn = await pool.getConnection();
        const sql = `insert into test.person(name, age, mobile) 
                    values ('${params.name}', ${params.age}, '${params.mobile}')`;
        const rows = await conn.query(sql, []);
        console.log(`SQL 실행 결과: ${JSON.stringify(rows)}`);
        const output = {
            code: 200,
            message: 'OK',
            header: {},
            data: rows
        }
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(JSON.stringify(output));
    } catch (err) {
        console.error(`에러발생! ${err}`)
        const output = {
            code: 400,
            message: `공습경보! ${err}`
        }
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(JSON.stringify(output));
    } finally {
        if (conn) { conn.end(); }
    }
})

//UPDATE
router.route('/person/update').get(async (req, res) => {
    let conn;
    try {
        conn = await pool.getConnection();
        const sql = `update test.person set name = '홍길동77' where id = 1`;
        const rows = await conn.query(sql, []);
        console.log(`SQL 실행 결과: ${JSON.stringify(rows)}`);
        const output = {
            code: 200,
            message: 'OK',
            header: {},
            data: rows
        }
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(JSON.stringify(output));
    } catch (err) {
        console.error(`에러발생! ${err}`)
        const output = {
            code: 400,
            message: `공습경보! ${err}`
        }
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(JSON.stringify(output));
    } finally {
        if (conn) { conn.end(); }
    }
})

//DELETE
router.route('/person/remove').get(async (req, res) => {
    let conn;
    try {
        conn = await pool.getConnection();
        const sql = `delete from test.person where id = 3`;
        const rows = await conn.query(sql, []);
        console.log(`SQL 실행 결과: ${JSON.stringify(rows)}`);
        const output = {
            code: 200,
            message: 'OK',
            header: {},
            data: rows
        }
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(JSON.stringify(output));
    } catch (err) {
        console.error(`에러발생! ${err}`)
        const output = {
            code: 400,
            message: `공습경보! ${err}`
        }
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(JSON.stringify(output));
    } finally {
        if (conn) { conn.end(); }
    }
})

app.use((req, res, next) => {
    console.log('첫번째 미들웨어 호출됨');
    next();

})

app.use((req, res, next) => {
    console.log('두번째 미들웨어 호출됨');
    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
    res.end('<h3>페이지를 찾을 수 없습니다.</h3>');
})
//응답을 보내면 끝나버림

http.createServer(app).listen(7001, () => {
    console.log(`   웹 서버 실행됨: 7001`);
})
console.log(`   웹 서버 실행 요청함`);
