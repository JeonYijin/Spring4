/**
 * 
 */
 
const pws = document.getElementsByClassName('pw'); 
const btn = document.getElementById('btn');

btn.addEventListener('click', function(){
	 // 패스워드가 같은지 검사
	let ce2= checkEqual(pws[0].value, pws[1].value);
	
	// 첫번째 비번이 6글자 이상인지
	let cl = checkLength();
	
	if(ce2 && cl){
		frm.submit();
	}else{
		alert('실패')
	}
	 
});



 function checkLength(){
	let l = pws[0].value.trim().length
	if(l>=6){
		return true;
	}else{
		return false;
	}
};

function checkEqual(check1, check2){
	return check1 == check2; // check1.value == check2.value로 하면 위에서 안해도 됨
};

