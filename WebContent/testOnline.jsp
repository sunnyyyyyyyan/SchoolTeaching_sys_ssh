<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testOnline</title>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <style type="text/css">
        #maintable{
            font-family: "宋体";
            background-color: #D3D3D3;
            text-align: left;
            width: 95%;
            height: auto;
            vertical-align: middle;
        }
        .div-inline{
            display:inline;
            position: relative;
            top: 20%;
        }
    </style>
    <script type="text/javascript">
        var maxtime = 3*60*60 //按秒计算，自己调整!时-h 分-'(min) 秒-"(s)
        function CountDown(){
            if(maxtime>=0){
                hours = Math.floor(maxtime/60/60%24);
                minutes = Math.floor(maxtime/60%60);
                seconds = Math.floor(maxtime%60);
                msg = "剩余时间："+hours+":"+minutes+":"+seconds;
                document.all["timer"].innerHTML = msg;
                if(maxtime == 5*60) alert('注意，还有5分钟!');
                --maxtime;
            }else{
                clearInterval(timer);
                //alert("时间到，结束!");
                //window.location = "testLogin.jsp";//重定位
                window.location.href = "<{$app}>/ceshi/Exam/result";//跳转，未提交表单数据
                //var action = document.getElementById("form1").action;
                //document.forms[0].action = action;
                //document.forms[0].submit();
            }
        }
        timer = setInterval("CountDown()",1000);
    </script>
</head>
<body>
<div id="page">
    <div id="header">
        <jsp:include page="header.jsp" />
    </div>

    <div id="left_column">
        <jsp:include page="left_column.jsp" />
    </div>

    <div id="center_column">
        <div class="testOnline">
            <br><!--  style="border:1px solid #f00;"红色边框 style="border:1px solid #0ff;width: 800px;height: 28px;" -->
            <div style="width: 90%;height: 30px;border:1px solid #000;position: relative;left: 5%;" id="topdiv">
                &nbsp;<div class="div-inline" id="tester">测试工号：CS00351 <div class="div-inline" id="timer" style="color:red;">剩余时间：2:48:50</div></div>
                <div class="div-inline" id="empty">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>

            </div>&nbsp;
            <div style="width: 90%;height: auto;border:1px solid #000;position: relative;left: 5%;" id="formdiv">
                <form id="form1" name="subform" action="#" method="post">
                    <input type="hidden" name="badgeNo" value="CS00351">
                    <h2 align="center">在线测试</h2>
                    <h3 align="right">（考试时间:180分钟    题型:多选题    满分:100分）</h3><hr>
                    <h4>&nbsp;&nbsp;多选题（错选、少选、多选不得分）</h4><hr>

                    <h5>&nbsp;&nbsp;1、testDS13</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A219" value="A">&nbsp;&nbsp;A&nbsp;testDScA13<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B219" value="B">&nbsp;&nbsp;B&nbsp;testDScb13<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C219" value="C">&nbsp;&nbsp;C&nbsp;testDScc13<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D219" value="D">&nbsp;&nbsp;D&nbsp;testDScd13<hr>

                    <h5>&nbsp;&nbsp;2、testDS15</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A221" value="A">&nbsp;&nbsp;A&nbsp;testDScA15<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B221" value="B">&nbsp;&nbsp;B&nbsp;testDScb15<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C221" value="C">&nbsp;&nbsp;C&nbsp;testDScc15<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D221" value="D">&nbsp;&nbsp;D&nbsp;testDScd15<hr>

                    <h5>&nbsp;&nbsp;3、testDS20</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A226" value="A">&nbsp;&nbsp;A&nbsp;testDScA20<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B226" value="B">&nbsp;&nbsp;B&nbsp;testDScb20<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C226" value="C">&nbsp;&nbsp;C&nbsp;testDScc20<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D226" value="D">&nbsp;&nbsp;D&nbsp;testDScd20<hr>

                    <h5>&nbsp;&nbsp;4、testDS23</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A229" value="A">&nbsp;&nbsp;A&nbsp;testDScA23<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B229" value="B">&nbsp;&nbsp;B&nbsp;testDScb23<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C229" value="C">&nbsp;&nbsp;C&nbsp;testDScc23<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D229" value="D">&nbsp;&nbsp;D&nbsp;testDScd23<hr>

                    <h5>&nbsp;&nbsp;5、testDS43</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A249" value="A">&nbsp;&nbsp;A&nbsp;testDScA43<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B249" value="B">&nbsp;&nbsp;B&nbsp;testDScb43<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C249" value="C">&nbsp;&nbsp;C&nbsp;testDScc43<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D249" value="D">&nbsp;&nbsp;D&nbsp;testDScd43<hr>

                    <h5>&nbsp;&nbsp;6、testDS53</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A259" value="A">&nbsp;&nbsp;A&nbsp;testDScA53<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B259" value="B">&nbsp;&nbsp;B&nbsp;testDScb53<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C259" value="C">&nbsp;&nbsp;C&nbsp;testDScc53<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D259" value="D">&nbsp;&nbsp;D&nbsp;testDScd53<hr>

                    <h5>&nbsp;&nbsp;7、testDS72</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A278" value="A">&nbsp;&nbsp;A&nbsp;testDScA72<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B278" value="B">&nbsp;&nbsp;B&nbsp;testDScb72<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C278" value="C">&nbsp;&nbsp;C&nbsp;testDScc72<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D278" value="D">&nbsp;&nbsp;D&nbsp;testDScd72<hr>

                    <h5>&nbsp;&nbsp;8、testDS77</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A283" value="A">&nbsp;&nbsp;A&nbsp;testDScA77<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B283" value="B">&nbsp;&nbsp;B&nbsp;testDScb77<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C283" value="C">&nbsp;&nbsp;C&nbsp;testDScc77<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D283" value="D">&nbsp;&nbsp;D&nbsp;testDScd77<hr>

                    <h5>&nbsp;&nbsp;9、testDS91</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A297" value="A">&nbsp;&nbsp;A&nbsp;testDScA91<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B297" value="B">&nbsp;&nbsp;B&nbsp;testDScb91<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C297" value="C">&nbsp;&nbsp;C&nbsp;testDScc91<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D297" value="D">&nbsp;&nbsp;D&nbsp;testDScd91<hr>

                    <h5>&nbsp;&nbsp;10、testDS95</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A301" value="A">&nbsp;&nbsp;A&nbsp;testDScA95<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B301" value="B">&nbsp;&nbsp;B&nbsp;testDScb95<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C301" value="C">&nbsp;&nbsp;C&nbsp;testDScc95<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D301" value="D">&nbsp;&nbsp;D&nbsp;testDScd95<hr>

                    <h5>&nbsp;&nbsp;11、testDS98</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A304" value="A">&nbsp;&nbsp;A&nbsp;testDScA98<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B304" value="B">&nbsp;&nbsp;B&nbsp;testDScb98<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C304" value="C">&nbsp;&nbsp;C&nbsp;testDScc98<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D304" value="D">&nbsp;&nbsp;D&nbsp;testDScd98<hr>

                    <h5>&nbsp;&nbsp;12、testDS120</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A326" value="A">&nbsp;&nbsp;A&nbsp;testDScA120<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B326" value="B">&nbsp;&nbsp;B&nbsp;testDScb120<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C326" value="C">&nbsp;&nbsp;C&nbsp;testDScc120<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D326" value="D">&nbsp;&nbsp;D&nbsp;testDScd120<hr>

                    <h5>&nbsp;&nbsp;13、testDS124</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A330" value="A">&nbsp;&nbsp;A&nbsp;testDScA124<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B330" value="B">&nbsp;&nbsp;B&nbsp;testDScb124<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C330" value="C">&nbsp;&nbsp;C&nbsp;testDScc124<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D330" value="D">&nbsp;&nbsp;D&nbsp;testDScd124<hr>

                    <h5>&nbsp;&nbsp;14、testDS130</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A336" value="A">&nbsp;&nbsp;A&nbsp;testDScA130<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B336" value="B">&nbsp;&nbsp;B&nbsp;testDScb130<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C336" value="C">&nbsp;&nbsp;C&nbsp;testDScc130<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D336" value="D">&nbsp;&nbsp;D&nbsp;testDScd130<hr>

                    <h5>&nbsp;&nbsp;15、testDS132</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A338" value="A">&nbsp;&nbsp;A&nbsp;testDScA132<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B338" value="B">&nbsp;&nbsp;B&nbsp;testDScb132<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C338" value="C">&nbsp;&nbsp;C&nbsp;testDScc132<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D338" value="D">&nbsp;&nbsp;D&nbsp;testDScd132<hr>

                    <h5>&nbsp;&nbsp;16、testDS160</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A366" value="A">&nbsp;&nbsp;A&nbsp;testDScA160<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B366" value="B">&nbsp;&nbsp;B&nbsp;testDScb160<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C366" value="C">&nbsp;&nbsp;C&nbsp;testDScc160<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D366" value="D">&nbsp;&nbsp;D&nbsp;testDScd160<hr>

                    <h5>&nbsp;&nbsp;17、testDS164</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A370" value="A">&nbsp;&nbsp;A&nbsp;testDScA164<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B370" value="B">&nbsp;&nbsp;B&nbsp;testDScb164<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C370" value="C">&nbsp;&nbsp;C&nbsp;testDScc164<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D370" value="D">&nbsp;&nbsp;D&nbsp;testDScd164<hr>

                    <h5>&nbsp;&nbsp;18、testDS166</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A372" value="A">&nbsp;&nbsp;A&nbsp;testDScA166<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B372" value="B">&nbsp;&nbsp;B&nbsp;testDScb166<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C372" value="C">&nbsp;&nbsp;C&nbsp;testDScc166<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D372" value="D">&nbsp;&nbsp;D&nbsp;testDScd166<hr>

                    <h5>&nbsp;&nbsp;19、testDS178</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A384" value="A">&nbsp;&nbsp;A&nbsp;testDScA178<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B384" value="B">&nbsp;&nbsp;B&nbsp;testDScb178<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C384" value="C">&nbsp;&nbsp;C&nbsp;testDScc178<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D384" value="D">&nbsp;&nbsp;D&nbsp;testDScd178<hr>

                    <h5>&nbsp;&nbsp;20、testDS179</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A385" value="A">&nbsp;&nbsp;A&nbsp;testDScA179<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B385" value="B">&nbsp;&nbsp;B&nbsp;testDScb179<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C385" value="C">&nbsp;&nbsp;C&nbsp;testDScc179<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D385" value="D">&nbsp;&nbsp;D&nbsp;testDScd179<hr>

                    <h5>&nbsp;&nbsp;21、testDS185</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A391" value="A">&nbsp;&nbsp;A&nbsp;testDScA185<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B391" value="B">&nbsp;&nbsp;B&nbsp;testDScb185<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C391" value="C">&nbsp;&nbsp;C&nbsp;testDScc185<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D391" value="D">&nbsp;&nbsp;D&nbsp;testDScd185<hr>

                    <h5>&nbsp;&nbsp;22、testDS193</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A399" value="A">&nbsp;&nbsp;A&nbsp;testDScA193<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B399" value="B">&nbsp;&nbsp;B&nbsp;testDScb193<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C399" value="C">&nbsp;&nbsp;C&nbsp;testDScc193<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D399" value="D">&nbsp;&nbsp;D&nbsp;testDScd193<hr>

                    <h5>&nbsp;&nbsp;23、testDS194</h5>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="A400" value="A">&nbsp;&nbsp;A&nbsp;testDScA194<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="B400" value="B">&nbsp;&nbsp;B&nbsp;testDScb194<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="C400" value="C">&nbsp;&nbsp;C&nbsp;testDScc194<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="D400" value="D">&nbsp;&nbsp;D&nbsp;testDScd194<hr>

                    <input style="width: 120px;height: 50px;font-size: 30px;position: relative;left: 45%;" type="submit" name="submit" value="交卷">
                    <div style="width: 90%;height: 8px;"></div>
                </form>
            </div>
        </div>
    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp" />
    </div>
</div>
</body>
</html>
