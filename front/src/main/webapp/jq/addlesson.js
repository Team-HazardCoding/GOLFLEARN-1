$(function(){
    //------------썸네일 첨부 START------------

    //------------지역 START------------
    //------------레슨분류 START------------
    
	 
    //------------레슨정보 등록버튼 START------------
    let $form = $('form');
    $form.submit(function(){
        let data = $(this).serialize();
        console.log(data);
        $.ajax({
            url : "http://localhost:1124/back/addlesson",
            method : 'post',
            data : data,
            success : function(jsonObj){
                alert(jsonObj.msg);
            },
            error : function(jqXHR){
                alert('오류 : ' + jqXHR.status);
            }
        });
        return false;
    });
});