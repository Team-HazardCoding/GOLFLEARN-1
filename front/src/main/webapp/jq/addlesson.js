$(function(){
   
    //------------썸네일 첨부 START------------

    //------------레슨분류 등록 START------------

    //------------레슨지역 등록 START------------

    //------------레슨정보 등록버튼 START------------
	$('div.tr3>div.tr1>button').click(function(){
		$.ajax({
			url: '/back/addorder',
            method: 'post',
			success: function(jsonObj){
				if(jsonObj.status == 1){	//로그인이 되있을경우
					alert(jsonObj.msg);
					location.href="";
				}else if(jsonObj.status == -1){	//등록실패
					alert(jsonObj.msg);
                    location.href="";
				}
			},
			error: function(jqXHR){
				alert('오류: ' + jqXHR.status);
			}
		});
	});
});