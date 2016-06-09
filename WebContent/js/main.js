"use strict";

/*
 * modal 관련한 함수
 */
$(".personal-modify-button").click(function() {
    $(".modal").css("display", "block");
    $(".keyword-form").focus();
});

$(".modal").click(function(event) {
    if (event.target.className === this.className) {
        $(".modal").css("display", ""); 
    }
});

$(".personal-modify-close").click(function() {
   $(".modal").css("display", ""); 
});
/******************* 모달 관련 함수 끝 ********************/

$(".keyword-list").on("click", ".keyword-delete-button", function(){
    // 삭제시 동작하는 ajax
    
    this.parentElement.remove();
});


$(".keyword-form").keyup(function(event) {
    if (event.which === 13) {
        if (event.target.value !== "") {
            addKeyword();
        }
    }
});

$(".personal-modify .add-button").click(function(event) {
    if ($('.keyword-form')[0].value !== "" ) {
        addKeyword();
    }
});

var addKeyword = function() {
    var value = $('.keyword-form')[0].value;
    var span = $("<span></span>").text("x").attr("class", "keyword-delete-button");
    var li = $("<li></li>").text(value).attr("class", "keyword").append(span);
    $(".keyword-list").append(li);
    
    //등록시 동작하는 ajax

    
    $.ajax({
    	url: "./addUserKeyword.do", 
    	data : {
    		keyword : encodeURIComponent( value  )
    	}, 
    	success: function(result){
    		alert(value + '가 추가되었습니다.');
    }});

    $('.keyword-form')[0].value = "";
}

$(".personal-modify > .ok-button").click(function() {
    $(".modal").css("display", "");
});
