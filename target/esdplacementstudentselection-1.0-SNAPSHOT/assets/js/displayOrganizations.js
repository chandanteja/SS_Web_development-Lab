let disp_org = document.getElementById('org-div-id');

window.onload = function()
{
    createTable1();

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
        let href_id="id-org-"+obj.placement_id;

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
