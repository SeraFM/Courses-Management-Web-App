$(document).ready(function(){
	
	$('.table .eBtn').on('click', function(e){
		
		 e.stopImmediatePropagation();
		
		 try {
			
			var href = $(this).attr('href');
		
			$.get(href, function(course, status){
				$('.editForm #courseid').val(course.courseid);
				$('.editForm #name').val(course.name);
				$('.editForm #year').val(course.year);
				$('.editForm #syllabus').val(course.syllabus);
				$('.editForm #semester').val(course.semester);
				$('.editForm #attendance').val(course.attendance);
			});
		
			$('.editForm #editModal').modal('show');
		
       	 	
	    } catch(ex) {
	        alert('An error occurred and I need to write some code to handle this!');
	    }
    	e.preventDefault();
		
	});
	
	$('.table .delBtn').on('click', function(){
		
		//event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal('show');

	});
	
});