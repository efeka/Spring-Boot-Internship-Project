
let laptop;
let monitor;
let phone;

let cart = []
let products = [];
let productCount = 0;

document.addEventListener("DOMContentLoaded", function() {
    setup();
});

function setup() {
    laptop = document.getElementById("laptop");
    monitor = document.getElementById("monitor");
    phone = document.getElementById("phone");

    products[0] = "Laptop";
    products[1] = "Phone";
    products[2] = "Monitor";
    productCount = products.length;

    for (let i = 0; i < productCount; i++) {
        cart[i] = [];
        cart[i][0] = products[i];
        cart[i][1] = 0;
    }
}

function addProductsToCart() {
    if (laptop.checked === true) {
        let index = products.indexOf("Laptop");
        cart[index][1]++;
    }
    if (monitor.checked === true) {
        let index = products.indexOf("Monitor");
        cart[index][1]++;
    }
    if (phone.checked === true) {
        let index = products.indexOf("Phone");
        cart[index][1]++;
    }

    updateCartTable();
}

function deleteProductsFromCart() {
    if (laptop.checked === true) {
        let index = products.indexOf("Laptop");
        if (cart[index][1] > 0)
            cart[index][1]--;
    }
    if (monitor.checked === true) {
        let index = products.indexOf("Monitor");
        if (cart[index][1] > 0)
            cart[index][1]--;
    }
    if (phone.checked === true) {
        let index = products.indexOf("Phone");
        if (cart[index][1] > 0)
            cart[index][1]--;
    }

    updateCartTable();
}

function updateCartTable() {
    let cartItems = document.getElementById("cartItems");
    cartItems.innerHTML = "";
    for (let i = 0; i < productCount; i++) {
        if (cart[i][1] > 0) {
            cartItems.innerHTML += "<td>" + cart[i][0] + " x" + cart[i][1] + "</td>";
        }
    }
}

function  resetCart() {
    let cartItems = document.getElementById("cartItems");
    cartItems.innerHTML = "";
    for (let i = 0; i < productCount; i++) {
        cart[i][1] = 0;
    }
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

/*
function checkControl() {
    let laptop = document.getElementById("laptop");
    let monitor = document.getElementById("monitor");
    let phone = document.getElementById("phone");
    let cartItems = document.getElementById("cartItems");

    if (laptop.checked === true) {
        if(cartItems.innerHTML.includes("Laptop")) {
            let index = cartItems.innerHTML.indexOf("Laptop x");
            let count = parseInt(cartItems.innerHTML.charAt(index + 8));
            count++;

            cartItems.innerHTML = cartItems.innerHTML.replace("Laptop x" + (count - 1),"Laptop x" + count);
        }
        else {
            cartItems.innerHTML = cartItems.innerHTML + "<td>Laptop x1</td>"
        }
    }

    if (monitor.checked === true) {
        if(cartItems.innerHTML.includes("Monitor")) {
            let index = cartItems.innerHTML.indexOf("Monitor x");
            let count = parseInt(cartItems.innerHTML.charAt(index + 9));
            count++;

            cartItems.innerHTML = cartItems.innerHTML.replace("Monitor x" + (count - 1),"Monitor x" + count);
        }
        else {
            cartItems.innerHTML = cartItems.innerHTML + "<td style=\"text-align:center\">Monitor x1</td>"
        }
    }

    if (phone.checked === true) {
        if(cartItems.innerHTML.includes("Phone")) {
            let index = cartItems.innerHTML.indexOf("Phone x");
            let count = parseInt(cartItems.innerHTML.charAt(index + 7));
            count++;

            cartItems.innerHTML = cartItems.innerHTML.replace("Phone x" + (count - 1),"Phone x" + count);
        }
        else {
            cartItems.innerHTML = cartItems.innerHTML + "<td>Phone x1</td>"
        }
    }
}

function  resetCart() {
    let cartItems = document.getElementById("cartItems");
    cartItems.innerHTML = "";
}

function deleteFromCart() {
    let laptop = document.getElementById("laptop");
    let monitor = document.getElementById("monitor");
    let phone = document.getElementById("phone");
    let cartItems = document.getElementById("cartItems");

    if (laptop.checked === true) {
        if(cartItems.innerHTML.includes("Laptop")) {
            let index = cartItems.innerHTML.indexOf("Laptop x");
            let count = parseInt(cartItems.innerHTML.charAt(index + 8));
            count--;

            if (count === 0) {
                cartItems.innerHTML = cartItems.innerHTML.replace("Laptop x" + (count + 1), "");
            }
            else {
                cartItems.innerHTML = cartItems.innerHTML.replace("Laptop x" + (count + 1), "Laptop x" + count);
            }
        }
    }

    if (monitor.checked === true) {
        if(cartItems.innerHTML.includes("Monitor")) {
            let index = cartItems.innerHTML.indexOf("Monitor x");
            let count = parseInt(cartItems.innerHTML.charAt(index + 9));
            count--;

            if (count === 0) {
                cartItems.innerHTML = cartItems.innerHTML.replace("Monitor x" + (count + 1), "");
            }
            else {
                cartItems.innerHTML = cartItems.innerHTML.replace("Monitor x" + (count + 1), "Monitor x" + count);
            }
        }
    }

    if (phone.checked === true) {
        if(cartItems.innerHTML.includes("Phone")) {
            let index = cartItems.innerHTML.indexOf("Phone x");
            let count = parseInt(cartItems.innerHTML.charAt(index + 7));
            count--;

            if (count === 0) {
                cartItems.innerHTML = cartItems.innerHTML.replace("Phone x" + (count + 1), "");
            }
            else {
                cartItems.innerHTML = cartItems.innerHTML.replace("Phone x" + (count + 1), "Phone x" + count);
            }
        }
    }

    let innerTemp = cartItems.innerHTML;
    if (!innerTemp.includes("Laptop") && !innerTemp.includes("Phone") && !innerTemp.includes("Monitor")) {
        cartItems.innerHTML = "";
    }
}
*/
