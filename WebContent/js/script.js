/**
 * 
 */
setTimeout(function() {
	$('#err').fadeOut(2500);
}, 5000);

$(document).ready(function() {
	$(".btn-close").click(function() {
		$("#err").fadeOut('fast');
	});
});