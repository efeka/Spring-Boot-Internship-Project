
function checkControl() {

    let laptop = document.getElementById("laptop");
    let monitor = document.getElementById("monitor");
    let phone = document.getElementById("phone");

    let cartItems = document.getElementById("cartItems");

    if (laptop.checked == true) {

        if(cartItems.innerHTML.includes("Laptop")) {

            let index = cartItems.innerHTML.indexOf("Laptop x");
            let count = parseInt(cartItems.innerHTML.charAt(index+8));
            count++;

        cartItems.innerHTML = cartItems.innerHTML.replace("Laptop x"+(count-1),"Laptop x"+count); }

        else {
        cartItems.innerHTML = cartItems.innerHTML + "<td>Laptop x1</td>"}
    }

    if (monitor.checked == true) {

        if(cartItems.innerHTML.includes("Monitor")) {

            let index = cartItems.innerHTML.indexOf("Monitor x");
            let count = parseInt(cartItems.innerHTML.charAt(index+9));
            count++;

            cartItems.innerHTML = cartItems.innerHTML.replace("Monitor x"+(count-1),"Monitor x"+count); }

        else {
            cartItems.innerHTML = cartItems.innerHTML + "<td style=\"text-align:center\">Monitor x1</td>"}
    }

    if (phone.checked == true) {

        if(cartItems.innerHTML.includes("Phone")) {

            let index = cartItems.innerHTML.indexOf("Phone x");
            let count = parseInt(cartItems.innerHTML.charAt(index+7));
            count++;

            cartItems.innerHTML = cartItems.innerHTML.replace("Phone x"+(count-1),"Phone x"+count); }

        else {
            cartItems.innerHTML = cartItems.innerHTML + "<td>Phone x1</td>"}
    }

}

function  resetCart() {
    let cartItems = document.getElementById("cartItems");
    cartItems.innerHTML = "";
}

/*
$( "#confirmCart").submit(function( event ) {

    // Stop form from submitting normally
    event.preventDefault();

    // Get some values from elements on the page:
    var $form = $( this ),
        term = $form.find( "input[name='s']" ).val(), // inputlardan productlar alınıacak
        url = "http://localhost:8080/jpa/62f119fbddb15819e7c435ae/carts"

    // Send the data using post
    var posting = $.post( url, "{ \"id\": \"62f119fbddb15819e7c435b5\", \"name\": \"ab\", \"price\": 100}" ); //JSON OLARAK GONDERİLECEK

    // Put the results in a div
    posting.done(function( data ) {
        //var content = $( data ).find( "#content" );
        $( "#result" ).empty().append( data );
    });
});
*/

function getData() {
    $.get({
        type: 'GET',
        //url: 'http://localhost:8080/jpa/62f11ca72c5e5f131c972215/carts',
        url: 'http://localhost:8080/jpa/carts',
        //data: "{ \"id\": \"62f11ca72c5e5f131c97221b\", \"name\": \"ab\", \"price\": 100}",
        success: function (data) {
            alert('data: ' + JSON.stringify(data));
        },
        contentType: "application/json",
        dataType: 'json'
    });
}

function sendData() {
    $.ajax({
        type: 'POST',
        //url: 'http://localhost:8080/jpa/62f1224e96ac205c1288dcf9/carts',
        url : 'http://localhost:8080/jpa/customers',
        data:   {
            "name": "Efe123123",
            "birthDate": "1999-07-27",
            "email": "abc@default.com"
        },
        success: function (data) {
            alert('data: ' + JSON.stringify(data));
        },
        contentType: "application/json",
        dataType: 'json'
    });
}
