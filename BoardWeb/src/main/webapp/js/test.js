/*
 * js/test.js
 * JSON 포맷 (문자열 - 객체)
 */
console.log('경로정상');

let json = `{"name": "홍길동", "age": 20}`;
let obj = JSON.parse(json);
document.querySelector('input[name="name"]').value = obj.name;
document.querySelector('input[name="age"]').value = obj.age;

// 서버(서블릿) - jsp페이지.
// Asynchronous Javascript And Xml 
// 비동기방식: fetch나 Ajax 1->3->2. 동기방식은 순서대로 1->2->3.
console.log('1');

fetch('testData.do')
    .then(function(result) {
	    console.log(result); // body: stream
		return result.json(); // stream(json문자열) -> object 변환.
    })
	.then(function(result) {
		console.log(result);	
		document.querySelector('input[name="name"]').value = result.name;
		document.querySelector('input[name="age"]').value = result.age;
		console.log('2');
		})

console.log('3');
