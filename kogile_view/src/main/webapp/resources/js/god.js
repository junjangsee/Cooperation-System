(function($) {
  // drag 가 일어나고 있는 Container 를 담아둔다.
  var currentContainer = null;

  // event target list
  dragula(
    [
      document.getElementById("to-do"),
      document.getElementById("doing"),
      document.getElementById("done"),
      document.getElementById("close")
    ],
    {
      removeOnSpill: false
    }
  )
    .on("drag", function(_, container) {
      // drag event 가 일어나면 해당 Container 를 저장한다
      currentContainer = container;
    })
    .on("dragend", function(el, e) {
      // drag event 가 끝났을때 update 여부를 판단한다.
    
      var $currentElement = $(el);
      console.log($currentElement.attr('data-status'));
      console.log("currentElement", $currentElement);

      // element 의 status 를 바탕으로 todo, doing 등 카테고리 체크를 한다.
      var elementStatus = $currentElement.attr("data-status");
      // 최종 Container 의 status 값을 체크한다.
      var containerStatus = $(currentContainer).attr("data-status");

      console.log("elementStatus", elementStatus);
      console.log("containerStatus", containerStatus);
      
      //드래그 대상 p_no검출
      var p_no = $currentElement.attr('data-no');

      // elementStatus 와 containerStatus 가 같지 않다는 것은 카테고리 이동이 있었다는 것이므로 update 를 한다.
      if (elementStatus !== containerStatus) {
        // 이동된 해당 카드의 status 를 update 될 카테고리의 status 로 변경한다.
        // todo (0) => done 으로 이동 => (0) => (1)
        // 같은 카드의 중복이동이 있을 수 있기 때문에 변경
        $currentElement.attr("data-status", containerStatus);

        console.log("타켓 elementStatus", elementStatus);

        // 여기서 ajax call 로 update 처리를 한다.
        console.log("update" + p_no);
        
        DragPost(elementStatus, containerStatus, p_no);

      }
    })
    .on("out", function(_, container) {
      currentContainer = container;
    });
  
  function DragPost(elementStatus, containerStatus, p_no){
	  const data = {
			  p_no : p_no,
			  new_c_no : containerStatus
	  }
	  
	  $.ajax({
		  url : "/kogile/project/drag_post",
		  type : "POST",
		  data : data 
	  }).then(function(){
		  console.log("성공");
	  }).catch(function(){
		  console.log("실패");
	  })
  }
})(jQuery);

