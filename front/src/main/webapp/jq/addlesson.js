$(function () {
	//화면로딩되자마자 시도 목록 출력
	$.ajax({
        url: 'http://localhost:1124/back/main', 
        success: function (jsonObj) {
            $sidoObj = $('select[name=sd]');
            var arr = [];
            let sido = '';
            $(jsonObj.sido).each(function(key, item) {
                // console.log(Object.values(item));
                $keyObj = Object.keys(item);
                $itemObj = Object.values(item);
                for ( let i = 0; i < $itemObj.length; i++ ) {
                    arr.push($itemObj[i]);
                    console.log($keyObj);
                    sido += '<option class="sido" name="sido" value="' + $keyObj[i] + '"';
                    sido+= '>' + $itemObj[i] + '</option>';
                }
            })
            // sido += '</ul>';
            $sidoObj.append(sido);
            return false;
        },
        error: function (jqXHR) {
            alert("error: " + jqXHR.status);
        }

    });

	//------------레슨정보 등록버튼 START------------
	let $btRegister = $('button[name=register]');

	$btRegister.click(function () {
	
		let $formObj = $('form.lessonregister');
		let formData = new FormData($formObj[0]);

		//WB에서 입력한 값이 잘 추출되는지 확인
		let $locNoVal = $('option[name=sigungu]').val();
		let $clubNo = $('input[name=club_no]').val();
		let $lessonTitle = $('input[name=lsn_title]').val();
		let $lessonPrice = $('input[name=lsn_price]').val();
		let $lessonLV = $('input[name=lsn_lv]').val();
		let $lsnCntSum = $('input[name=lsn_cnt_sum]').val();
		let $lsnPerTime = $('input[name=lsn_per_time]').val();
		let $lsnIntro = $('input[name=lsn_intro]').val();
		let $lsnDays = $('input[name=lsn_days]').val();

		$.ajax({
			url: "http://localhost:1124/back/addlesson",
			method: 'post',
			data: formData,
			processData: false,
			contentType: false,
			success: function (jsonObj) {
				if (jsonObj.status == 1) {
					alert("등록성공");
					location.replace("http://localhost:1124/front/html/main.html");
				}
			},
			error: function (jqXHR) {
				alert('오류 : ' + jqXHR.status);

				//WB에서 입력한 값이 잘 추출되는지 확인
				console.log($locNoVal);
				console.log($clubNo);
				console.log($lessonTitle);
				console.log($lessonPrice);
				console.log($lessonLV);
				console.log($lsnCntSum);
				console.log($lsnPerTime);
				console.log($lsnIntro);
				console.log($lsnDays);
			}
		});
		return false;	
	});
});