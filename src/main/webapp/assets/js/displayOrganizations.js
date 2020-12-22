let disp_org = document.getElementById('org-div-id');

window.onload = function()
{
    createTable1();
    sendIdToBack();

}

async function createTable1()
{

    const tableHeadings= ['ID','Company Name','Min CGPA','Profile Offering','Intake','Description'];
    let response = await fetch("api/placement/displayorg");
    console.log("response is :", response);
    let companies = await response.json(); // read response body and parse as JSON
    console.log(companies);
   /* for(let i = 0; i < companies.length; i++)
    {
        let obj = companies[i];

        console.log("Printing json data description",obj.description);
        console.log("Printing json data org_name",obj.org_name);
        console.log("Printing json data profile",obj.profile);

    }*/


    let tablehtml = "<table><caption>Elements</caption>";

    // insert row of headings
    tablehtml  += "<tr>";
    for(let heading of tableHeadings)
    {
        tablehtml  += `<th style="padding: 0 20px">${heading}</th>`;
    }
    tablehtml += "</tr>";

    // iterate data and add row of cells for each
    //for(let element of elements)
    for(let i = 0; i < companies.length; i++)
    {
        tablehtml  += "<tr>";
        let obj = companies[i];
        let href_id="id-org-"+obj.placement_id;        //declared above

        tablehtml += `<td style="padding: 0 20px">${obj.placement_id}</td>`;
        tablehtml += `<td style="padding: 0 20px"> <a href="index.html" id="${href_id}"> ${obj.org_name}</a></td> `;
        tablehtml += `<td style="padding: 0 20px">${obj.min_cgpa}</td>`;
        tablehtml += `<td style="padding: 0 20px">${obj.profile}</td>`;
        tablehtml += `<td style="padding: 0 20px">${obj.intake}</td>`;
        tablehtml += `<td style="padding: 0 20px">${obj.description}</td>`;

        href_id="";


        tablehtml  += "</tr>";
    }

    // end of table
    tablehtml += "</table>";

    // add table to the empty div
    document.getElementById("org-table-id").innerHTML = tablehtml;

}


//this function needs to be modified as per my requirement.
async function sendIdToBack()
{
    let clicked_id= document.getElementById('org-table-id');
    clicked_id.addEventListener('click',async(e)=>{
        e.preventDefault();
        e.stopPropagation();

        if (clicked_id.checkValidity() === true) {
            console.log("Inside sendIdToBack()");
            let response = await fetch('api/students/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                body: JSON.stringify({
                    first_name: document.getElementById('first_name').value,
                    last_name: document.getElementById('last_name').value,
                    courses: [{'course_id':document.getElementById('courses').value}],
                    email: document.getElementById('email').value,
                })
            }).then(
                response => {
                    if (response['status'] === 203) {
                        document.getElementById("login-success").style.display = "none";
                        document.getElementById("login-alert").style.display = "block";

                    } else {
                        document.getElementById("login-alert").style.display = "none";
                        document.getElementById("login-success").style.display = "block";

                    }
                }
            );
        } else {
            student_form.classList.add('was-validated');
        }

    });
}
