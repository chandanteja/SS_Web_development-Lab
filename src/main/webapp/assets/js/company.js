let applied_students_data = document.getElementById('applied-tab');
let eligible_div_id=document.getElementById("id-eligible-students");

/*window.onload = function()
{
    //eligible_div_id.innerHTML="";
    // sendIdToBack(clickId);
    while(eligible_div_id.firstChild) {
        eligible_div_id.removeChild(eligible_div_id.firstChild);
    }
}*/

applied_students_data.addEventListener('click', async (e) => {

    while(eligible_div_id.firstChild) {
         eligible_div_id.removeChild(eligible_div_id.firstChild);
    }
    await createTable1();

});

async function createTable1()
{
    let response = await fetch('api/placement/appliedstudents');
    console.log("response in company.js is :", response);
    let appliedStud = await response.json();
    console.log("appliedSTud",appliedStud);
    //const tableHeadings= ['Roll Number','First Name','Email','CGPA','Specialization','Status','Placement_ID'];
    const tableHeadings= ['Roll Number','First Name','Email','CGPA','Specialization','Status','Domain','Acceptance'];

     /*for(let i = 0; i < appliedStud.length; i++)
    {
        let obj = appliedStud[i];

        console.log("Printing json data description",obj.description);
        console.log("Printing json data org_name",obj.org_name);
        console.log("Printing json data profile",obj.profile);

    }*/
    let tablehtml = "<table><head>Students Applied</head>";

    // insert row of headings
    tablehtml  += "<tr>";
    for(let heading of tableHeadings)
    {
        tablehtml  += `<th style="padding: 0 20px">${heading}</th>`;
    }
    tablehtml += "</tr>";

    // iterate data and add row of cells for each
    //for(let element of elements)
    for(let i = 0; i < appliedStud.length; i++)
    {
        tablehtml  += "<tr>";
        //let obj = appliedStud[i];
        //let href_id="id-org-"+obj.placement_id;        //declared above




        tablehtml += `<td style="padding: 0 20px">${appliedStud[i][0]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${appliedStud[i][1]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${appliedStud[i][2]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${appliedStud[i][3]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${appliedStud[i][4]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${appliedStud[i][5]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${appliedStud[i][6]}</td>`;
        let plac_id=appliedStud[i][0]+" "+appliedStud[i][7];
        tablehtml += `<td style="padding: 0 20px"><button class="btn btn-primary btn-xs" id="${plac_id}"onclick="updatePlacementStatus(this.id);">Accept</button></td>`;


        /*var button = document.createElement('input');
        button.setAttribute('type', 'button');
        button.setAttribute('value', 'Accept');
        button.setAttribute('onclick', 'UpdatePlacementStatus()');
        tablehtml += `<td style="padding: 0 20px" >innerHTML.appendChild(button)</td>`;*/

        //tablehtml += `<td style="padding: 0 20px">${<button value="Accept" id="addToStudents" onclick="addToStudents(event);">Accept</button>}</td>`;
        //td.innerHTML = '<input type="button"...';
        





        //href_id="";
        tablehtml  += "</tr>";
    }

    // end of table
    tablehtml += "</table>";

    // add table to the empty div
    document.getElementById("id-applied-students").innerHTML = tablehtml;
}

async function updatePlacementStatus(clickId)
{
    // window.alert(window.location.href += "?id=" + clickId);
    // let clicked_id= document.getElementById('org-table-id');
    // console.log("Printing clicked_id: ",clicked_id)
    // clicked_id.addEventListener('click',async(e)=>{
    //   e.preventDefault();
    //  e.stopPropagation();
    //  if (clicked_id.checkValidity() === true) {

    console.log("Inside updatePlacementStatus()");
    console.log("ID from button is:",clickId);
    //let clickId1= clickId.match(/\d+/g);
    //console.log("Clicked ID1 (modified):",clickId1);

    let response = await fetch('api/student/updatePlacementStat', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
             clickId
        })
    });
    // let result = await response;
    //   if(response['status'] === 200)
    //    {
    console.log("response updatePlacementStatus method:",response);
    //location.href="company.html";

    //   }

    //  }



    // });


}