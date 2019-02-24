$(document)
		.ready(
				function() {

					var result = '<c:out value="${result}"/>';

					checkModal(result);

					history.replaceState({}, null, null);

					function checkModal(result) {

						if (result === '' || history.state) {
							return;
						}

						if (parseInt(result) > 0) {
							$(".modal-body").html(
									"게시글 " + parseInt(result) + " 번이 등록되었습니다.");
						}

						$("#myModal").modal("show");
					}

					$("#regBtn").on("click", function() {

						self.location = "kogile/board/insertBoard";

					});

					var actionForm = $("#actionForm");

					$(".paginate_button a").on(
							"click",
							function(e) {

								e.preventDefault();

								console.log('click');

								actionForm.find("input[name='pageNum']").val(
										$(this).attr("href"));
								actionForm.submit();
							});

					$(".move")
							.on(
									"click",
									function(e) {

										e.preventDefault();
										actionForm
												.append("<input type='hidden' name='bno' value='"
														+ $(this).attr("href")
														+ "'>");
										actionForm.attr("action", "kogile/board/detailBoard");
										actionForm.submit();

									});

					var searchForm = $("#searchForm");

					$("#searchForm button").on("click", function(e) {

						if (!searchForm.find("option:selected").val()) {
							alert("검색종류를 선택하세요");
							return false;
						}

						if (!searchForm.find("input[name='keyword']").val()) {
							alert("키워드를 입력하세요");
							return false;
						}

						searchForm.find("input[name='pageNum']").val("1");
						e.preventDefault();

						searchForm.submit();

					});

				});
