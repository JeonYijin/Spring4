/**
 * 
 */
 
 let fn1 = function(){
	alert('222')
	
};
 
  

 
 let b1 =document.getElementById("b1");
 b1.addEventListener("click", function(){
	
	let title =document.getElementById("title");
	let writer =document.getElementById("writer");
	const frm = document.getElementById("frm");
	let t1 = document.getElementById("t1");
	let t2 =document.getElementById("t2");
	t1.innerHTML="";
	t2.innerHTML="";
	
	
	let t = title.value;
	let w = writer.value;
	
	
	let check = true;
	
	//1.
/*	if(t != "" && w !=""){
		alert('true');
	}else{
		alert('false');
	}*/

	//2.
	
	if(t==""){
		check=false;
		//t1.innerHTML="title 입력";
		t1.innerText="title 입력";
	}
	
	if(w==""){
		check= false;
		//t2.innerHTML="작성자 입력";
		t2.innerText="작성자 입력";
	}
	
	if(check){
		frm.submit();
	}else{
		alert('필수 입력')
	}
	
	
	
});
 

 