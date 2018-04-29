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

/*window.onload=function()
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
};*/

function onSearch(obj){//js函数开始
    setTimeout(function(){//因为是即时查询，需要用setTimeout进行延迟，让值写入到input内，再读取
        var storeId = document.getElementById('store');//获取table的id标识
        var rowsLength = storeId.rows.length;//表格总共有多少行
        var key = obj.value;//获取输入框的值

        var searchCol = 3;//要搜索的哪一列，这里是第一列，从0开始数起

        for(var i=1;i<rowsLength;i++){//按表的行数进行循环，本例第一行是标题，所以i=1，从第二行开始筛选（从0数起）
            var searchText = storeId.rows[i].cells[searchCol].innerHTML;//取得table行，列的值

            if(searchText.match(key)){//用match函数进行筛选，如果input的值，即变量 key的值为空，返回的是ture，
                storeId.rows[i].style.display='';//显示行操作，
            }else{
                storeId.rows[i].style.display='none';//隐藏行操作
            }
        }
    },200);//200为延时时间
}

function onSearchGrade(obj){//js函数开始
    setTimeout(function(){//因为是即时查询，需要用setTimeout进行延迟，让值写入到input内，再读取
        var storeId = document.getElementById('store');//获取table的id标识
        var rowsLength = storeId.rows.length;//表格总共有多少行
        var key = obj.value;//获取输入框的值

        var searchCol = 1;//要搜索的哪一列，这里是第一列，从0开始数起

        for(var i=1;i<rowsLength;i++){//按表的行数进行循环，本例第一行是标题，所以i=1，从第二行开始筛选（从0数起）
            var searchText = storeId.rows[i].cells[searchCol].innerHTML;//取得table行，列的值

            if(searchText.match(key)){//用match函数进行筛选，如果input的值，即变量 key的值为空，返回的是ture，
                storeId.rows[i].style.display='';//显示行操作，
            }else{
                storeId.rows[i].style.display='none';//隐藏行操作
            }
        }
    },200);//200为延时时间
}
