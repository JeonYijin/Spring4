/**
 * 
 */
 let c1 = document.getElementsByClassName("c1");
 
const btn = document.getElementById('btn');
 
btn.addEventListener('click', function(){
	
	for(let i of c1){
		i.checked= true;
	};
	
}) ;
 
 for(let i of c1){
	if(i.checked){
		i.checked = !i.checked;
	}else{
		i.checked= !i.checked;
	}
}
 
 
 for(let i of c1){ //let 안쓰면 전역변수 for문이 끝나도 사용가능
	i.addEventListener('click', function(){
		alert(i.checked);
	})
};
 