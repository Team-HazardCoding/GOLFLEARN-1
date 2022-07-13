$(function(){
	$('div.tr3>div.tr1>button').click(function(){
		$.ajax({
			url: '/back/addorder',
            method: 'post',
			success: function(jsonObj){
				if(jsonObj.status == 1){	//로그인이 되있을경우
					alert(jsonObj.msg);
					// location.href="";
					$('nav>a[href="productlist.html"]').trigger('click');	//상품목록
				}else if(jsonObj.status == 0){	//로그인 안된 경우
					alert(jsonObj.msg);
					$('nav>a[href="login.html"]').trigger('click');	//로그인
				}else if(jsonObj.status == -1){	//주문실패
					alert(jsonObj.msg);
				}
			},
			error: function(jqXHR){
				alert('오류: ' + jqXHR.status);
			}
		});
	});
});