/**
 * boardFile.js
 최대 5개까지만 추가할 수 있도록 5개 넘어가면 alert창 뜸
 */
 
 let file = '<div class="input-group mb-3">';
file = file + ' <input type="file" class="form-control">';
file = file + '  <button class="btn btn-outline-secondary" type="button" id="button-addon2">ADD</button>';
file = file + '</div>';
 
let count=0;
 $("#add").click(function(){
	count++;
	if(count>5){
		alert('5개까지만 추가가능');
	}else{
		$("#file").append(file);
	}
	
});
 