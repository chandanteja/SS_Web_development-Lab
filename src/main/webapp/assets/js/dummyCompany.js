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

async function fetch_specializations()
{
    console.log("entered fetch_dept()");
    let filterhtml= "<div class=\"mb-3\">\n" +
        "      <label for=\"specialization\">Specialization</label>\n" +
        "      <select class=\"custom-select d-block w-100\" id=\"id-specialization-select\" required>\n" +
        "      </select>\n" +
        "<button class=\"btn btn-lg btn-primary btn-block tg3 float-right\" id=\"button1\"  style='margin-top: 15px; margin-bottom: 20px '  type=\"button\" onclick=\"filter()\">"+
        "    Filter  " +
        "</button>" +
        "    </div>";
    document.getElementById("id-specialization-div").innerHTML = filterhtml;


    let response = await fetch("api/student/specialisation");
    let specializations = await response.json(); // read response body and parse as JSON
    console.log(specializations);
    let spl_option = document.getElementById('id-specialization-select');
    spl_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i<specializations.length ; i++){
        spl_option.innerHTML += '<option value="'+specializations[i]+'">'+specializations[i]+'</option>';
    }

}

async function fetch_Domain()
{
    console.log("entered fetch_domain()");
    let domainhtml= "<div class=\"mb-3\">\n" +
        "      <label for=\"domain\">Domain</label>\n" +
        "      <select class=\"custom-select d-block w-100\" id=\"id-domain-select\" required>\n" +
        "      </select>\n" +
        "<button class=\"btn btn-lg btn-primary btn-block tg3 float-right\" id=\"button1\"  style='margin-top: 15px; margin-bottom: 20px '  type=\"button\" onclick=\"filter()\">"+
        "    Filter  " +
        "</button>" +
        "    </div>";
    document.getElementById("id-domain-div").innerHTML = domainhtml;


    let response = await fetch("api/student/domain");
    let domains = await response.json(); // read response body and parse as JSON
    console.log(domains);
    let dmn_option = document.getElementById('id-domain-select');
    dmn_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i<domains.length ; i++){
        dmn_option.innerHTML += '<option value="'+domains[i]+'">'+domains[i]+'</option>';
    }

}

applied_students_data.addEventListener('click', async (e) => {

    while(eligible_div_id.firstChild) {
        eligible_div_id.removeChild(eligible_div_id.firstChild);
    }
    await createTable1();
    await fetch_specializations();
    await fetch_Domain();
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
    let tablehtml = "<table><head style='text-align: center'><strong>Students Applied</strong></head>";

    // insert row of headings
    tablehtml  += "<tr>";
    for(let heading of tableHeadings)
    {
        if (heading == 'CGPA') {
            tablehtml += `<th onclick="sortTable()" style="padding: 0 20px">${heading}</th>`;
            console.log("Inside CGPA==heading")
        }
        else if(heading != 'CGPA' )
        {
            tablehtml += `<th style="padding: 0 20px">${heading}</th>`;
            console.log("Inside cgpa!=heading");

        }
    }
    tablehtml += "</tr>";

    // iterate data and add row of cells for each
    //for(let element of elements)
    for(let i = 0; i < appliedStud.length; i++)
    {
        tablehtml  += "<tr>";
        //let obj = appliedStud[i];
        //let href_id="id-org-"+obj.placement_id;        //declared above

        /* tablehtml += `<td style="padding: 0 20px">${obj.roll_num}</td>`;
         tablehtml += `<td style="padding: 0 20px">${obj.first_name}</a></td> `;
         tablehtml += `<td style="padding: 0 20px">${obj.email}</td>`;
         tablehtml += `<td style="padding: 0 20px">${obj.cgpa}</td>`;
         tablehtml += `<td style="padding: 0 20px">${obj.Specialization}</td>`;
         tablehtml += `<td style="padding: 0 20px">${obj.Status}</td>`;
         //tablehtml += `<td style="padding: 0 20px">${obj.Placement_id}</td>`;*/

        tablehtml += `<td style="padding: 0 20px">${appliedStud[i][0]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${appliedStud[i][1]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${appliedStud[i][2]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${appliedStud[i][3]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${appliedStud[i][4]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${appliedStud[i][5]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${appliedStud[i][6]}</td>`;
        let plac_id=appliedStud[i][0]+" "+appliedStud[i][7];
        tablehtml += `<td style="padding: 0 20px"><button class="btn btn-primary btn-xs" id="${plac_id}"onclick="updatePlacementStatus(this.id);">Accept</button></td>`;

        //href_id="";
        tablehtml  += "</tr>";
    }

    // end of table
    tablehtml += "</table>";
    //tablehtml += "<div class=\"wrapper\">\n" +
    //    "    <button class=\"button\"  id=\"sort-applied\" style=\" border: 2px solid black; background-color: white; color: black; padding: 14px 28px; font-size: 16px; border-color: #2196F3; color: dodgerblue \" > Sort CGPA</button>\n" +
    //    "</div>"

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
}


function sortTable() {
    let table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("id-applied-students");
    switching = true;
    //Set the sorting direction to ascending:
    dir = "asc";
    /*Make a loop that will continue until
    no switching has been done:*/
    while (switching) {
        //start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /*Loop through all table rows (except the
        first, which contains table headers):*/
        for (i = 1; i < (rows.length - 1); i++) {
            //start by saying there should be no switching:
            shouldSwitch = false;
            /*Get the two elements you want to compare,
            one from current row and one from the next:*/
            x = rows[i].getElementsByTagName("TD")[3];
            y = rows[i + 1].getElementsByTagName("TD")[3];
            /*check if the two rows should switch place,
            based on the direction, asc or desc:*/
            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch= true;
                    break;
                }
            } else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /*If a switch has been marked, make the switch
            and mark that a switch has been done:*/
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            //Each time a switch is done, increase this count by 1:
            switchcount ++;
        } else {
            /*If no switching has been done AND the direction is "asc",
            set the direction to "desc" and run the while loop again.*/
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
} // end of sort table function


/*async function filter_tbl()
{
    // let response1 = await fetch('api/placement/appliedstudents');
    // let appliedStud1 = await response1.json();
    console.log("Inside filter_tbl");
    let table, valSel,rows, switching, i, x, y, shouldSwitch, dir, table_complete;
    table = document.getElementById("id-applied-students");
    table_complete=document.getElementById("id-applied-students");;
    valSel=document.getElementById('id-specialization-select').value;
    console.log("valSel: ",valSel);
    //console.log(table);
    // table1=table;
    // table1.innerHTML='';
    switching = true;

    // while (switching) {


    rows = table.rows;

    for (i = 1; i < (rows.length); i++) {

        x = rows[i].getElementsByTagName("TD")[4];
        console.log("x: ",x);
        console.log("x.textContent:",x.textContent);
        if(valSel) {
            if (valSel == 'Select All')
            {
                console.log("Inside select all");
                //  document.getElementById("id-applied-students").innerHTML = table_complete;
                await createTable1();
            }
            else if (x.textContent != valSel) {
                console.log("inside x!=tscd");
                //table.deleteRow(x);
                rows[i].remove();
                // rows = table.rows;
            }
        }
    }
    //   }


}
*/

async function filter()
{
    splVal=document.getElementById('id-specialization-select').value;
    domVal=document.getElementById('id-domain-select').value;
    console.log("Inside filter()");
    console.log("splval: ",splVal);
    console.log("domVal ",domVal);

    let response = await fetch('api/student/Filter', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            splVal,
            domVal

        })
    });
    let filters = await response.json();

    console.log("response filter method:",filters);

    const tableHeadings= ['Roll Number','First Name','Email','CGPA','Specialization','Status','Domain','Acceptance'];


    let tablehtml = "<table><head style='text-align: center'><strong>Students Applied</strong></head>";

    // insert row of headings
    tablehtml  += "<tr>";
    for(let heading of tableHeadings)
    {
        if (heading == 'CGPA') {
            tablehtml += `<th onclick="sortTable()" style="padding: 0 20px">${heading}</th>`;
            console.log("Inside CGPA==heading")
        }
        else if(heading != 'CGPA' )
        {
            tablehtml += `<th style="padding: 0 20px">${heading}</th>`;
            console.log("Inside cgpa!=heading");

        }
    }
    tablehtml += "</tr>";

    // iterate data and add row of cells for each
    //for(let element of elements)
    for(let i = 0; i < filters.length; i++)
    {
        tablehtml  += "<tr>";

        tablehtml += `<td style="padding: 0 20px">${filters[i][0]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${filters[i][1]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${filters[i][2]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${filters[i][3]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${filters[i][4]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${filters[i][5]}</td>`;
        tablehtml += `<td style="padding: 0 20px">${filters[i][6]}</td>`;
        let plac_id=filters[i][0]+" "+filters[i][7];
        tablehtml += `<td style="padding: 0 20px"><button class="btn btn-primary btn-xs" id="${plac_id}"onclick="updatePlacementStatus(this.id);">Accept</button></td>`;

        //href_id="";
        tablehtml  += "</tr>";
    }

    // end of table
    tablehtml += "</table>";
    //tablehtml += "<div class=\"wrapper\">\n" +
    //    "    <button class=\"button\"  id=\"sort-applied\" style=\" border: 2px solid black; background-color: white; color: black; padding: 14px 28px; font-size: 16px; border-color: #2196F3; color: dodgerblue \" > Sort CGPA</button>\n" +
    //    "</div>"

    // add table to the empty div
    document.getElementById("id-applied-students").innerHTML = tablehtml;

}