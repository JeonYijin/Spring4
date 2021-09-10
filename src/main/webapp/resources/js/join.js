/**
 * 
 */
 
 //1. 비어있는지 확인하기
let not = document.getElementsByClassName("not");
const btn = document.getElementById('btn');
const pws = document.getElementsByClassName('pw');
let pw1 = document.getElementById('pw1');
let pw2 = document.getElementById('PW2');
const frm = document.getElementById('frm');
const id = document.getElementById('id');
const idResult = document.getElementById('idResult');
const pw22 = document.getElementsByClassName('pw22');
const idCheck = document.getElementById('idCheck');

idCheck.addEventListener('click', function(){
	//새창띄우기
	open("./idCheck?id="+id.value, "", "width=400, height=200, top=200, left=300");
});


/*id.addEventListener('keyup', function(){
	if(id.value.trim().length>=6){
		idResult.innerHTML='가능한 아이디입니다';
	}else{
		idResult.innerHTML='6글자 이상 입력하세요';
	}

});

id.addEventListener('blur',function(){
	if(id.value.trim().length<6){
		id.focus();
	}
});

id.addEventListener('change',function(){
	alert('change');
});

*/



pws[1].addEventListener('blur', function(){
	if(pws[0].value != pws[1].value){
		pw22[0].innerHTML = "틀림";
		//alert('틀림')
	}
});



/*btn.addEventListener('click', function(){
	let result = true;
	for(let n of not){
		if(n.value == ""){
			result=false;
			break;
		}
	}
	
	let presult=true;
	if(pw1.value!=pw2.value){
		presult=false;
	}
	
	
	
});*/


btn.addEventListener('click', function(){
	 // 비어있는지 검사 	
	let ce = checkEmpty(not);
	 // 패스워드가 같은지 검사
	let ce2= checkEqual(pws[0].value, pws[1].value);
	
	// 첫번째 비번이 6글자 이상인지
	let cl = checkLength();
	
	if(ce && ce2 && cl){
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


function checkEmpty(puts){
	let result = true;
	for(let r of puts){
		if(r.value==""){
			result=false;
			break;
		}
	}
	
	return result;
};







