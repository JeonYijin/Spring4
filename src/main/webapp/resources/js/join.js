/**
 * 
 */

//id, pw, name, email, phone이 비어있는지 체크

/*$("#btn").click(function(){
	let result = true;
	$(".not").each(function(){
		if($(".not").val() == ""){
			alert("비어있음");
			result = false;
		}else{
			alert("안비었음");
		}
	});
	
});

$("#btn").click(function(){
	let result = true;
	let t ;
	$(".not").each(function(s1,s2){
		if($("s2").val()==""){
			result=false;
			t = s2;
		}
	
	});
	
	if(result){
			//$("#frm").submit();
			alert("submit");
		}else{
			alert("필수 입력");
			$(t).focus(); // 비어있는 곳에 포커스 넣기
		}

});

*/

$("#btn").click(function(){
	 
	let result=true;
	let t;
	 $(".not").each(function(s1, s2){
		if($(s2).val() == ""){
			result=false;
			t=s2;
		}
	});
	
	if(result){
			alert('submit');
			//$("#frm").submit();
		}else {
			alert('필수 입력');	
			$(t).focus();
		}

});