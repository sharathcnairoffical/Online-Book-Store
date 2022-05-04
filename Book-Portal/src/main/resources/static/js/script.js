
function validateQuantity() {
	
	var qunatity = document.cart.quantity.value;
	
	if(qunatity > 0)
		return true;
	
	alert("Quantity should be greater than Zero");

	return false;
	
}