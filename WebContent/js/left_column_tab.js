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
    //admin
    var admin_tab_1=document.getElementById("admin_tab_1");
    var admin_tab_1_content=document.getElementById("admin_tab_1_content");
    admin_tab_1.onclick=function()
    {
        Show_Hidden(admin_tab_1_content);
        return false;
    };
    var admin_tab_2=document.getElementById("admin_tab_2");
    var admin_tab_2_content=document.getElementById("admin_tab_2_content");
    admin_tab_2.onclick=function()
    {
        Show_Hidden(admin_tab_2_content);
        return false;
    };
    var admin_tab_3=document.getElementById("admin_tab_3");
    var admin_tab_3_content=document.getElementById("admin_tab_3_content");
    admin_tab_3.onclick=function()
    {
        Show_Hidden(admin_tab_3_content);
        return false;
    };
    var admin_tab_4=document.getElementById("admin_tab_4");
    var admin_tab_4_content=document.getElementById("admin_tab_4_content");
    admin_tab_4.onclick=function()
    {
        Show_Hidden(admin_tab_4_content);
        return false;
    };
    var admin_tab_5=document.getElementById("admin_tab_5");
    var admin_tab_5_content=document.getElementById("admin_tab_5_content");
    admin_tab_5.onclick=function()
    {
        Show_Hidden(admin_tab_5_content);
        return false;
    };



    //teacher
    var teacher_tab_1=document.getElementById("teacher_tab_1");
    var teacher_tab_1_content=document.getElementById("teacher_tab_1_content");
    teacher_tab_1.onclick=function()
    {
        Show_Hidden(teacher_tab_1_content);
        return false;
    };
    var teacher_tab_2=document.getElementById("teacher_tab_2");
    var teacher_tab_2_content=document.getElementById("teacher_tab_2_content");
    teacher_tab_2.onclick=function()
    {
        Show_Hidden(teacher_tab_2_content);
        return false;
    };
    var teacher_tab_3=document.getElementById("teacher_tab_3");
    var teacher_tab_3_content=document.getElementById("teacher_tab_3_content");
    teacher_tab_3.onclick=function()
    {
        Show_Hidden(teacher_tab_3_content);
        return false;
    };
    var teacher_tab_4=document.getElementById("teacher_tab_4");
    var teacher_tab_4_content=document.getElementById("teacher_tab_4_content");
    teacher_tab_4.onclick=function()
    {
        Show_Hidden(teacher_tab_4_content);
        return false;
    };
    var teacher_tab_5=document.getElementById("teacher_tab_5");
    var teacher_tab_5_content=document.getElementById("teacher_tab_5_content");
    teacher_tab_5.onclick=function()
    {
        Show_Hidden(teacher_tab_5_content);
        return false;
    };


    //student
    var student_tab_1=document.getElementById("student_tab_1");
    var student_tab_1_content=document.getElementById("student_tab_1_content");
    student_tab_1.onclick=function()
    {
        Show_Hidden(student_tab_1_content);
        return false;
    };
    var student_tab_2=document.getElementById("student_tab_2");
    var student_tab_2_content=document.getElementById("student_tab_2_content");
    student_tab_2.onclick=function()
    {
        Show_Hidden(student_tab_2_content);
        return false;
    };
    var student_tab_3=document.getElementById("student_tab_3");
    var student_tab_3_content=document.getElementById("student_tab_3_content");
    student_tab_3.onclick=function()
    {
        Show_Hidden(student_tab_3_content);
        return false;
    };
    var student_tab_4=document.getElementById("student_tab_4");
    var student_tab_4_content=document.getElementById("student_tab_4_content");
    student_tab_4.onclick=function()
    {
        Show_Hidden(student_tab_4_content);
        return false;
    };
    var student_tab_5=document.getElementById("student_tab_5");
    var student_tab_5_content=document.getElementById("student_tab_5_content");
    student_tab_5.onclick=function()
    {
        Show_Hidden(student_tab_5_content);
        return false;
    };
};
