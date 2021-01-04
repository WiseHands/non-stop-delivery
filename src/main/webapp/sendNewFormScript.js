// sign up form for team registration

function submitform(ev) {

    event.preventDefault();

    //document.signUpForm.orderNumber.value.required;

    let courierName = 'Вкажіть своє ім\'я';

    let shopNameInput = document.signUpForm.shopName;
    let shopName = shopNameInput.value;

    let orderNumberInput = document.signUpForm.orderNumber;
    let orderNumber = orderNumberInput.value;

    let orderPriceInput = document.signUpForm.orderPrice;
    let orderPrice = orderPriceInput.value;

    let streetNameInput = document.signUpForm.streetName;
    let streetName = streetNameInput.value;

    let buildingNameInput = document.signUpForm.buildingName;
    let buildingName = buildingNameInput.value;

    let apartmentNameInput = document.signUpForm.apartmentName;
    let apartmentName = apartmentNameInput.value;

    let entranceCodeInput = document.signUpForm.entranceCode;
    let entranceCode = entranceCodeInput.value;

    let jsonObject = new Object();
    jsonObject.courierName = courierName;
    jsonObject.shopName = shopName;
    jsonObject.orderNumber = orderNumber;
    jsonObject.orderPrice = orderPrice;
    jsonObject.streetName = streetName;
    jsonObject.buildingName = buildingName;
    jsonObject.apartmentName = apartmentName;
    jsonObject.entranceCode = entranceCode;
    let jsonRequestInString = JSON.stringify(jsonObject);

    if (shopName && orderNumber && orderPrice && streetName && buildingName && apartmentName) {
        let url = '/admin/newrequest';
        sendPostRequest(jsonRequestInString, url);
        document.getElementById('hideifsuccess_0').style.display = 'none';
        document.getElementsByClassName('main-input-button')[0].style.display = 'none';
    } else {
        alert('Помилка при створенні заявки');
    }

    console.log("press button" + orderNumber
        + " " + courierName
        + " " + shopName
        + " " + orderPrice
        + " " + streetName
        + " " + buildingName
        + " " + apartmentName
        + " " + entranceCode
        + " " + jsonRequestInString
        + " " + "/team/signuprequest");
}

// http post request
function sendPostRequest(data, url) {
    spinner.removeAttribute('hidden');
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: data
    })
        .then(function (response) {
            console.log('Request succeeded with JSON response', data);
            if(response.ok) {
				document.getElementById('success').style.display = 'block';
            } else {
            	document.getElementById('error').style.display = 'block';
            }
        })
        .then(data => { spinner.setAttribute('hidden', '') })
        .catch(function (error) {
            console.log('Request failed', error);
        });

}