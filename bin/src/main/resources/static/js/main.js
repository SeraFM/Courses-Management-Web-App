/*$(document).ready(function(){
	
	$('.table .eBtn').on('click', function(e){
		
		 e.stopImmediatePropagation();
		
		 try {
			
			var href = $(this).attr('href');
		
			$.get(href, function(course, status){
				$('.editForm #courseidEdit').val(course.courseid);
				$('.editForm #nameEdit').val(course.name);
				$('.editForm #yearEdit').val(course.year);
				$('.editForm #syllabusEdit').val(course.syllabus);
				$('.editForm #semesterEdit').val(course.semester);
				$('.editForm #attendanceEdit').val(course.attendance);
			});
		
			//$('.editForm #editModal').modal('show');
		
       	 	
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
	
});*/