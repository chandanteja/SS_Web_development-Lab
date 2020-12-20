let login_form = document.getElementById('login-validation');
window.onload = fetch_department;

login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();

    if (login_form.checkValidity() === true) {
        let response = await fetch('api/employee/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                email: document.getElementById('email').value,          //getting email and department values entered in the form
                department: document.getElementById("departments").value,
            })
        });
        let result = await response;
        if(result["status"]===200)
        {

            document.getElementById("login-success").style.display = "block";
            setTimeout(() => { location.href = "dashboard1.html"; }, 2000);
                   // To navigate to dashboard.html page

            window.setTimeout(function() {
                $(".alert").fadeTo(1000, 0)
            }, 2000);

        }
        else
        {
            document.getElementById("login-alert").style.display = "block";

            //This below code is for fading out the alerts  is not working as expected.need to look into this again

              window.setTimeout(function() {
                  $(".alert").fadeTo(3000, 0)
              }, 3000);


        }
    }
});

async function fetch_department(){
    let response = await fetch("api/employee/get");
    let departments = await response.json(); // read response body and parse as JSON
    console.log(departments);
    let dep_option = document.getElementById('departments');
    dep_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i<departments.length ; i++){
        dep_option.innerHTML += '<option value="'+departments[i]+'">'+departments[i]+'</option>';
    }

    let response2 = await fetch("api/employee/addEmp", {method: 'POST'});
}