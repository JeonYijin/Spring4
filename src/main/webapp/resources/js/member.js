/**
 * 
 */
 
let c1 = document.getElementsByClassName("c1");
const all = document.getElementById('all');
const id4 = document.getElementById('id4');
let c2 = document.getElementsByClassName("c2");

let btn = document.getElementById('btn');
/*
btn.addEventListener('click', function(){
	if(all.checked){
		location.href="./join";
	}else{
		alert('필수 약관에 동의하세요');
	}
});
*/

btn.addEventListener('click', function(){
	
	let result = true;
	for(let c of c2){
		if(!c.checked){
			result = false;
			break;
		}
	}
	
	if(result){
		location.href="./join";
	}else{
		alert('필수약관에 동의하세요')
	}
})




//c2라고 필수약관만 클래스 따로 주기
/*btn.addEventListener('click', function(){
	for(let ch of c2){
		if(ch.checked){
			location.href="./join";
		}else{
			alert("필수약관을 동의하세요")
		}
	}
	
})*/

/* id를 줬을 때 - 코드 너무 길어요..
btn.addEventListener('click', function(){
	if(all.checked){
		location.href="./join";
	}else if(id1.checked ==true && id2.checked==true && id3.checked==true && id4.checked==false){
		location.href="./join";
	}
	else{
		alert('필수 약관에 동의하세요')
	}
	
	
	
})*/


all.addEventListener('click',function(){
	for(let i of c1){
		i.checked = all.checked;
	}
	
});

//------------1개 또는 여러개가 체크된거 구별하기
for(let i of c1){
	i.addEventListener('click', function(){
		let result = true;
		
		for(let c of c1){
			if(!c.checked){
				result = false;
				break;	
			}
		}
		all.checked = result;
		
	});
};

//------------------필수 약관 아닌거 체크 제외








