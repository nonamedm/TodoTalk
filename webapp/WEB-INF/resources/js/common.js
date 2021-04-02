var lang= location.href.replace(/^http.+(\/[a-z]{2})\/.*$/gi, "$1");



$(function(){
    //tracking btns
    function inMotion(){
        var titleBox = $(".section_top .top_title");
        if(titleBox.length < 1) return;

        //if(location.href.indexOf("room") > -1 || location.href.indexOf("dining") > -1 || location.href.indexOf("meeting_and_wedding") > -1 || location.href.indexOf("facility") > -1){
        if(location.href.indexOf("room") > -1 || location.href.indexOf("dining") > -1 || location.href.indexOf("meeting_and_wedding") > -1 || location.href.indexOf("facility") > -1){
            var titleStr = titleBox.html();
            titleStr = titleStr.replace("&amp;", "&");
            var sliceArr = titleStr.split("");
            var spanLens = sliceArr.length;

            if(titleBox.find("img").length > 0){
                titleBox.find("img").addClass("active");
            }else{
                titleBox.empty();

                for(var i = 0, len = spanLens; i < len; ++i){
                    var appendStr = sliceArr[i];
                    if(appendStr == " ") appendStr = "&nbsp;";
                    titleBox.append("<span>"+appendStr+"</span>");

                    if(i%2) titleBox.find("span").eq(i).addClass("top");
                    else titleBox.find("span").eq(i).addClass("bottom");
                }

                setTimeout(function(){ titleBox.find("span").removeClass("top").removeClass("bottom").addClass("active");}, 500);
            }
        }
    }

   inMotion();
})





