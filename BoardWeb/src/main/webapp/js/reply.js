/**
 * reply.js
 */
console.log(svc.showName());
let page = 1; // 페이징.

//댓글.
function makeReply(reply = {}) {
	let html = `<li data-id="${reply.replyNo}">
					<span class="col-sm-2">${reply.replyNo}</span>
					<span class="col-sm-5">${reply.reply}</span>
					<span class="col-sm-2">${reply.replyer}</span>
					<span class="col-sm-2"><button onclick="deleteRow('${reply.replyNo}')">삭제</button></span>
			    </li>`;
	return html;
}

// 글삭제.
function deleteRow(rno) {
	if (!confirm("삭제하시겠습니까?")) {
		alert('취소합니다.');
		return;
	}

	svc.removeReply(rno//
		, function(result) {
			if (result.retCode == 'OK') {
				document.querySelector('li[data-id="' + rno + '"]').remove();
			}
		}
		, function(err) { console.log(err) });
}

// 댓글목록 출력함수.

function showPageList() {
	//목록보기.
	svc.replyList({ bno, page } //원본글번호
		, // 성공함수.
		function(result) {
			// 기존목록 지우기.
			document.querySelectorAll('li[data-id]').forEach(function(elem) {
				elem.remove();
			});
			let resultAry = result;
			resultAry.forEach(function(reply) {
				let target = document.querySelector('.reply>.content>ul');
				let html = makeReply(reply);
				target.insertAdjacentHTML('beforeend', makeReply(reply));
			});
		}
		, // 실패함수.
		function(err) {
			console.log(err);
		}
	)
} // end of showPageList.

// 목록.
showPageList();

// 페이징 생성.
function showPagingList() {
	svc.makePaging(bno,
		function(result) {
			console.log(result); // {totalCnt: 255}
			const totalCnt = result.totalCnt;
			// startPage, endPage, currPage
			// prev, next 계산.  11 .. 15 .. 20
			let currPage = page;
			let endPage = Math.ceil(currPage / 10) * 10;
			let startPage = endPage - 9;
			let realEnd = Math.ceil(totalCnt / 5);
			endPage = endPage > realEnd ? realEnd : endPage;
			let prev = startPage != 1 ? true : false;
			let next = endPage != realEnd ? true : false;

			// 링크생성.
			let target = document.querySelector('div.footer>nav>ul');
			target.innerHTML = ''; // 이전 페이징 정보 삭제.
			// 이전 페이지 존재.
			let html = '';
			if (prev) {
				html = `<li class="page-item">
				            <a class="page-link" href="#" data-page="${startPage - 1}">Previous</a>
				        </li>`;
			} else {
				html = `<li class="page-item disabled">
						    <a class="page-link" href="#">Previous</a>
						</li>`;
			}
			target.insertAdjacentHTML('beforeend', html);

			for (let p = startPage; p <= endPage; p++) {
				/*if(currPage == p) {
				let html = `<li class="page-item active"><a class="page-link" href="#" data-page="${p}">${p}</a></li>`;
				target.insertAdjacentHTML('beforeend', html);
				} else {
					let html = `<li class="page-item"><a class="page-link" href="#" data-page="${p}">${p}</a></li>`;
								target.insertAdjacentHTML('beforeend', html);
				} 밑에랑 같음. 밑에는 3항 연산자 사용. active가 눌렀을 때 파랗게 되는거*/ 
				let html = `<li class="page-item ${currPage==p?'active':''}"><a class="page-link" href="#" data-page="${p}">${p}</a></li>`;
								target.insertAdjacentHTML('beforeend', html);
			}
			
			// 이후 페이지 존재.
			if (next) {
				html = `<li class="page-item">
						           <a class="page-link" href="#" data-page="${endPage + 1}">Next</a>
						       </li>`;
			} else {
				html = `<li class="page-item disabled">
								    <a class="page-link" href="#">Next</a>
								</li>`;
			}
			target.insertAdjacentHTML('beforeend', html);
			
			// event.
			addLinkEvent(); // 화면의 a태그에 이벤트 등록.
			
		},
		function(err) {
			console.log(err);
		}
	);	
} // end of showPageList().


// 댓글등록 이벤트. id="addReply"
document.querySelector('#addReply').addEventListener('click', function() {
	//글번호: bno, 작성자: logid, 댓글: ?
	// id="reply"
	const reply = document.querySelector('#reply').value;
	const replyer = logid;
	if (!reply || !replyer) {
		alert('필수입력값을 확인.');
		return;
	}

	const parm = { bno, reply, replyer }

	svc.addReply(parm//
		, function(result) {
			if (result.retCode == 'OK') {
				const html = makeReply(result.retVal);
				let target = document.querySelector('.reply>.content>ul');
				target.insertAdjacentHTML('beforeend', html);
			} else {
				alert('처리 예외 발생.');
			}
		}//
		, function(err) { console.log(err) });

});

// 페이징목록의 링크()이벤트.
function addLinkEvent() {
	document.querySelectorAll('div.footer>nav a').forEach(function(item) {
		item.addEventListener('click', function(e) {
			e.preventDefault(); // 링크의 기본기능 X.
			console.log(e.target.getAttribute('data-page'));
			page = e.target.getAttribute('data-page'); // 링크클릭하면 페이지정보.
			//목록보기.
			showPageList();
			//페이지생성.
			showPagingList();
		});
	});
} 
showPagingList();
