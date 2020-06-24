// Include truYum form validation functions here
function validateMenuItemForm(){
    var name = document.menuItemForm.name.value;
    var price = document.menuItemForm.price.value;
    var date = document.menuItemForm.date.value;
    name = name.trim();
    price = price.trim();
    var len = name.length;
    var invalid = /\d/;
    if(name==null || name=="")
    {
        window.alert("Name cannot be empty.");
        return false;
    }
    else if(invalid.test(price)==false)
    {
        window.alert("Price can only have numbers.");
        return false;
    }
    else if(len<2||len>65)
    {
        window.alert("Name can only range from 2-65 characters.");
        return false;
    }
    else if(price.length==0)
    {
    	window.alert("Price cannot be empty");
    	return false;
	}
    else if(date.length==0)
    {
    	window.alert("Date of Launch is required");
    	return false;
	}
    else
    {
    	window.alert('Form Submitted Successfully');
    }
    return(true);
}