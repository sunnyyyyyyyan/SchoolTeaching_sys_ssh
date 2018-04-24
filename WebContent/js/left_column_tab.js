function Show_Hidden(obj)
{
    if(obj.style.display=="block")
    {
        obj.style.display='none';
    }
    else
    {
        obj.style.display='block';
    }
}

window.onload=function()
{
    var tab_1=document.getElementById("tab_1");
    var tab_1_content=document.getElementById("tab_1_content");
    tab_1.onclick=function()
    {
        Show_Hidden(tab_1_content);
        return false;
    };
    var tab_2=document.getElementById("tab_2");
    var tab_2_content=document.getElementById("tab_2_content");
    tab_2.onclick=function()
    {
        Show_Hidden(tab_2_content);
        return false;
    };
    var tab_3=document.getElementById("tab_3");
    var tab_3_content=document.getElementById("tab_3_content");
    tab_3.onclick=function()
    {
        Show_Hidden(tab_3_content);
        return false;
    };
    var tab_4=document.getElementById("tab_4");
    var tab_4_content=document.getElementById("tab_4_content");
    tab_4.onclick=function()
    {
        Show_Hidden(tab_4_content);
        return false;
    };
    var tab_5=document.getElementById("tab_5");
    var tab_5_content=document.getElementById("tab_5_content");
    tab_5.onclick=function()
    {
        Show_Hidden(tab_5_content);
        return false;
    };
};
