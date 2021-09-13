/**
 * 
 */
 
let file = '<div class="mb-3" id ="f">';
file = file + '<label for="photo" class="form-label">Photo</label>';
file = file + '<input type="file" name="photo" class="form-control not" id="photo">';
file = file + '</div>';


 
 $("#add").click(function(){
	$("#files").after(file);
	//alert('ddd');
	
});



