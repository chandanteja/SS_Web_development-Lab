let org_table = document.getElementById('org-tab');

org_table.addEventListener('click', async (e) => {
    e.preventDefault();
    e.stopPropagation();
   location.href= "organizations.html";

});