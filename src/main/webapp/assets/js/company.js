let applied_students_data = document.getElementById('applied-tab');


applied_students_data.addEventListener('click', async (e) => {

   await createTable1();

});

async function createTable1()
{
    let response = await fetch('api/placement/appliedstudents');
    console.log("response in company.js is :", response);
    let appliedStud = await response.json();
    console.log("appliedSTud",appliedStud);
    const tableHeadings= ['Roll Number','First Name','Email','CGPA','Specialization','Status','Placement_ID'];


   /*  for(let i = 0; i < appliedStud.length; i++)
    {
        let obj = appliedStud[i];

        console.log("Printing json data description",obj.description);
        console.log("Printing json data org_name",obj.org_name);
        console.log("Printing json data profile",obj.profile);

    }*/
  /*  let tablehtml = "<table><caption>Elements</caption>";

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
        let obj = appliedStud[i];
        let href_id="id-org-"+obj.placement_id;        //declared above

        tablehtml += `<td style="padding: 0 20px">${obj.placement_id}</td>`;
        tablehtml += `<td style="padding: 0 20px"> <a href="index.html" id="${href_id}" > ${obj.org_name}</a></td> `;
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
    document.getElementById("id-applied-students").innerHTML = tablehtml;

   */
}