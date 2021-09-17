/**
 * 
 */

//id, pw, name, email, phone이 비어있는지 체크

$('#id').blur(function () {
	let id = $('#id').val();
	
	$.get("./idCheckAjax?id="+id,function(result){
		result=result.trim();
		if(result==1){	
			$('#idResult').html('사용가능한 아이디입니다');
		}else{
			$('#idResult').html('중복된 아이디입니다');
		}
	});
});
	

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