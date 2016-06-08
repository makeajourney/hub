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

/*
 * keyword 클릭시 삭제
 */
$(".keyword-list").on("click", ".keyword", function(){
    $(this).remove();
});


$(".keyword-form").keyup(function(event) {
    if (event.which === 13) {
        if (event.target.value !== "") {
            var li = $("<li></li>").text(event.target.value).attr("class", "keyword");
            $(".keyword-list").append(li);
            event.target.value = "";
        }
    }
});

/*
 * OK 버튼을 눌렀을 경우 동작하는 함수
 */
$(".personal-modify > .ok-button").click(function() {
    // keyword 등록 모듈
    
    $(".modal").css("display", "");
});
