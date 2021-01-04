function submit(ev) {

    event.preventDefault();

    let courierNameInput = document.getElementById('courierName');
    let courierName = courierNameInput.value;

    if (courierName) {
        requestEntryCheckByCourier(courierName);
    } else {
        alert('Помилка при підтвердженні заявки');
    }
}

function requestEntryCheckByCourier(data) {
    console.log('data ', data);
    let apiUrl = '/submission/' + id + '/' + true;
    fetch(apiUrl, {
      method: 'PUT',
      body: data,
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(function(response){
        console.log(response);
        if(response.ok) {
            location.pathname = location.pathname;
            //document.getElementById('hideifsuccess').style.display = 'none';
        	//document.getElementById('success').style.display = 'block';
        	//document.getElementById('success-button').style.display = 'block';
        } else {
            document.getElementById('hideifsuccess').style.display = 'none';
        	document.getElementById('error').style.display = 'block';
        	/*document.getElementById('success-button').style.display = 'block';*/
        }
    }).then(function(data) {

        console.log(data);
    }).catch(function(error) {
          console.log('Request failed', error);})
}