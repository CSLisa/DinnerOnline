
$(function() {
	$(document).ready(function () {
		// 全选        
		$(".allselect").click(function () {
			$(".gwc_tb2 input[name=newslist]").each(function () {
				$(this).attr("checked", true);
			});
			setTotal();
		});

		//反选
		$("#invert").click(function () {
			$(".gwc_tb2 input[name=newslist]").each(function () {
				if ($(this).attr("checked")) {
					$(this).attr("checked", false);

				} else {
					$(this).attr("checked", true);

				} 
			});
			setTotal();
		});
		//取消
		$("#cancel").click(function () {
			$(".gwc_tb2 input[name=newslist]").each(function () {
				$(this).attr("checked", false);

			});
			setTotal();
		});

		
	});
		// 输出
		//$(".gwc_tb2 input[name=newslist]").click(function () {
		//$("#lists").on("click",".newslist", function() {
		$("#lists input").live("click",function() {
			setTotal();
		});
	
		
		//$(".add").click(
		//		function() {   
		$("#lists .add").live("click", function() {
					for(var i=1;i<=parseInt($("#size").val());i++){         
						var t = $(this).parent().find("input[class*=text_box_"+i+"]");
						t.val(parseInt(t.val()) + 1);
						setTotal();
						
						
						
						var quantity=$(".text_box_"+i+"").val();
						var orderId=$("#newslist_"+i+"").val();
						var path=$("#path").val();
						
						 $.ajax({
						        data:{"id":orderId,"quantity":quantity},
				               type: "post",
				                url: path+"/cart/doUpdate.do"
				              }); 
					}
				});
		/*$(".min").click(
				function() {*/
		$("#lists .min").live("click", function() {
					for(var i=1;i<=parseInt($("#size").val());i++){         
					var t = $(this).parent().find("input[class*=text_box_"+i+"]");
					t.val(parseInt(t.val()) - 1);
					if (parseInt(t.val()) < 1) {
						t.val(1);
					}
					setTotal();
					
					
					var quantity=$(".text_box_"+i+"").val();
					var orderId=$("#newslist_"+i+"").val();
					var path=$("#path").val();
					 $.ajax({
					        data:{"id":orderId,"quantity":quantity},
			               type: "post",
			                url: path+"/cart/doUpdate.do"
			              }); 
					}
				});
	
	
	$("#newslist").click(
			function() {

				setTotal();
			});		

	function setTotal() {

		var s = 0;
		var c=0;
		//.gwc_tb2 input[name=newslist]
		for(var i=1;i<=parseInt($("#size").val());i++){         
			if($("#newslist_"+i+"").attr('checked')){
				s += parseInt($(".text_box_"+i+"").val()) * parseFloat($(".price_"+i+"").text());
				c++;
			}
		}
				
			
		$("#zong1").html(s.toFixed(2));
		$("#shuliang").text(c);
	}
	setTotal();
    
    
});


	
	
