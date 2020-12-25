let eligible_students_data = document.getElementById('eligible-tab');
let applied_div_id=document.getElementById("id-applied-students");
let specialization_div_id=document.getElementById("id-specialization-div");


/*eligible_students_data.addEventListener('click', async (e) => {

    await createTable2();

});*/
window.onload = function()
{
    createTable2();
    // sendIdToBack(clickId);
}
eligible_students_data.addEventListener('click', async (e) => {
    e.preventDefault();
    /*while(specialization_div_id) {
        specialization_div_id.removeChild(specialization_div_id);
    }*/
    while(applied_div_id.firstChild) {
        applied_div_id.removeChild(applied_div_id.firstChild);
    }

    await createTable2();

});

async function createTable2()
{
    let response = await fetch('api/placement/eligiblestudents');
    console.log("response in eligible.js is :", response);
    let eligibleStud = await response.json();
    console.log("eligibleSTud",eligibleStud);
    //const tableHeadings= ['Roll Number','First Name','Email','CGPA','Specialization','Placement_ID'];
    const tableHeadings= ['Roll Number','First Name','Email','CGPA','Specialization','Domain'];

    /*for(let i = 0; i < appliedStud.length; i++)
   {
       let obj = appliedStud[i];

       console.log("Printing json data description",obj.description);
       console.log("Printing json data org_name",obj.org_name);
       console.log("Printing json data profile",obj.profile);

   }*/
    let tablehtml = "<table><head>Students Eligible</head>";

    //insert row of headings
    tablehtml  += "<tr>";
    for(let heading of tableHeadings)
    {
        tablehtml  += `<th style="padding: 0 20px">${heading}</th>`;
    }
    tablehtml += "</tr>";

    // iterate data and add row of cells for each
    //for(let element of elements)
    for(let i = 0; i < eligibleStud.length; i++)
    {
        tablehtml  += "<tr>";
        //let obj = eligibleStud[i];
        //let href_id="id-org-"+obj.placement_id;        //declared above

        /*tablehtml += `<td style="padding: 0 20px">${obj.roll_num}</td>`;
        tablehtml += `<td style="padding: 0 20px">${obj.first_name}</a></td> `;
        tablehtml += `<td style="padding: 0 20px">${obj.email}</td>`;
        tablehtml += `<td style="padding: 0 20px">${obj.cgpa}</td>`;
        tablehtml += `<td style="padding: 0 20px">${obj.Specialization}</td>`;
        tablehtml += `<td style="padding: 0 20px">${obj.Placement_id}</td>`;*/

        tablehtml += `<td style="padding: 0 20px">${eligibleStud[i][0]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${eligibleStud[i][1]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${eligibleStud[i][2]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${eligibleStud[i][3]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${eligibleStud[i][4]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${eligibleStud[i][5]}</td>`;
        //tablehtml += `<td style="padding: 0 20px">${eligibleStud[i][5]}</td>`;

        //href_id="";
        tablehtml  += "</tr>";
    }

    // end of table
    tablehtml += "</table>";

    // add table to the empty div
    document.getElementById("id-eligible-students").innerHTML = tablehtml;
}