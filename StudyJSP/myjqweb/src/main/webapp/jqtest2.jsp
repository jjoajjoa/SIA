<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<body>
	
	<p> 0부터 100 사이의 숫자: <input type="text" id="input"> </p>
	<i id="myIcon" class="bi bi-arrow-down"></i><br/>
	<input type="button" value="전송" id="myBtn" />

	<script>
	let random;
	let count = 0;
	let list = [];
		$(function() {
			random = Math.floor(Math.random() *100);
			//alert(random);
			
			$('#myBtn').on('click', () => {
				//$('#myIcon').removeClass('bi-arrow-down');
				//$('#myIcon').addClass('bi-arrow-up');
				//$('#myIcon').toggleClass('bi-arrow-up bi-arrow-down');
				count++;
				list.push($('#input').val());
				if($('#input').val() > random) { //입력된 숫자가 실제 랜덤보다 크면
					$('#myIcon').removeClass('bi-arrow-up');
					$('#myIcon').addClass('bi-arrow-down');
				} else if ($('#input').val() < random) {
					$('#myIcon').removeClass('bi-arrow-down');
					$('#myIcon').addClass('bi-arrow-up');
				} else {
					alert('BINGO! count = ' + count);
				}
			});
			
			$('#input').val(11);
		});
	</script>
	
</body>
</html>