/**
 * boardFile.js
 최대 5개까지만 추가할 수 있도록 5개 넘어가면 alert창 뜸
 */
 
let file = '<div class="input-group mb-3" id="del1">';
file = file + '<input type="file" name="files" class="form-control">';
file = file + '<button  class="btn btn-outline-secondary del" type="button">X</button>';
file = file + '</div>'
 
let count=0;
/* $("#add").click(function(){
	count++;
	if(count>5){
		
	}else{
		$("#file").append(file);
	}
	
});*/

//let index=0;
 $("#add").click(function(){
/*	index++;
let file = '<div class="input-group mb-3" id="del'+index+'">';
file = file + '<input type="file" class="form-control">';
file = file + '<button data-btn-id="'+index+'" class="btn btn-outline-secondary del" type="button">X</button>';
file = file + '</div>'*/
	if(count<5){
		count++;
		$("#file").append(file);
	
	}else{
		alert('5개까지만 추가가능');
	}
	
});


$("#file").on('click','.del',function(){
/*	let num = $(this).attr('data-btn-id');
	$("#del"+num).remove();*/
	$(this).parent().remove();
	
	count--;
});


/*$(".del").click(function(){
	alert('test');
	
});*/

