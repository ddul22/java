/**
 * memberm.js
 */
// 삭제함수.
function deletRow(id) {
	console.log(id);
	let btn = this;
} // end of deletRow.
    fetch("removeMember.do?mid="+ id)
    .then(function(result) {
	    return result.json();
    })
   .then((result) => {
	   console.log(result);
	   if(result.retCode == "OK") {
		  this.parentElement.parentElement.remove();
	   } else if (result.retCode == "NG") {
		   alert('삭제오류 발생');
	   } else{
		   alert('알 수 없는 코드입니다.');
	   }
   })
   .then(function(result) {
	   const memberAry = result;
	   memberAry.forEach(function(member) {
		   console.log(member);
		   const target = document.querySelector('#list');
		   const html = `<tr>
		                   <td>${member.memberId}</td>
						   <td>${member.passwd}</td>
						   <td>${member.memberName}</td>
						   <td>${member.responsibility}</td>
						   <td><button onclick="deletRow('${member.memberId}')"class="btn btn-danger">삭제</button></td>
						 </tr>`;
		   target.insertAdjacentHTML('beforeend', html);
		
	   });
   })