<%@ page import="java.util.List" %>
<%@ page import="com.po.Evaluate" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="sun.org.mozilla.javascript.internal.json.JsonParser" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19 0019
  Time: 下午 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>教学评价</title>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="js/jquery.min.js"></script>
</head>
<body>
<div id="page">
    <div id="header">
        <jsp:include page="header.jsp"/>
    </div>

    <div id="left_column">
        <jsp:include page="left_column.jsp"/>
    </div>

    <div id="center_column">
        <div class="doEvaluate">
            <button type="button" class="btn btn-default" name="Submit" style="float: right;width:50px;"
                    onclick="javascript:history.back(-1);" value="返回">返回
            </button>
            <br>
            <h4 align="center">教学评价</h4>
            <br>
            <p align="center">
                <font style="font-size: 12px;" color="red"><s:property value="subjectNo"/><s:property value="#request.getMessInChooseMess"/> </font>
            </p>
            <%
                List<Evaluate> list = (List<Evaluate>) ActionContext.getContext().get("getEvaluateTest");
                if (list == null) {
            %>
            <p align="center" style="color: red;">
                暂无评教题目！
            </p>
            <%
            } else {
            %>

            <p align="center">
                <font style="font-size: 12px;" color="red"><s:property value="#request.doEvaluateErrorMess"/> </font>
            </p>
            <form id="qusList">
                <table class="table table-bordered" style="width: 500px;margin: 0 auto;">
                    <%
                        for (int i = 0; i < list.size(); i++) {
                            Evaluate evaluate = list.get(i);
                    %>
                    <tr>
                        <td subjectNo="<%=evaluate.getSubjectNo()%>"
                            doEvaluateQuestionId="<%=evaluate.getEvaluateQuestionId()%>"
                            doEvaluateContent="<%=evaluate.getEvaluateContent()%>">
                            <%=evaluate.getEvaluateQuestionId() %>. <%=evaluate.getEvaluateContent()%>
                            <br>
                            <br>
                            <input type="radio" name="nowAnswer<%=i %>"
                                   value="<%=evaluate.getSelectA()%>"> <%=evaluate.getSelectA()%>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="radio" name="nowAnswer<%=i %>"
                                   value="<%=evaluate.getSelectB()%>"> <%=evaluate.getSelectB()%>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="radio" name="nowAnswer<%=i %>"
                                   value="<%=evaluate.getSelectC()%>"> <%=evaluate.getSelectC()%>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="radio" name="nowAnswer<%=i %>"
                                   value="<%=evaluate.getSelectD()%>"> <%=evaluate.getSelectD()%>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    <tr>
                        <td>
                            <textarea name="advise" id="advise" cols="60" rows="5" placeholder="有意见尽管吐槽..."></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            <button onclick="doEvaluate()">提交</button>
                        </td>
                    </tr>
                </table>
            </form>
            <%
                }
            %>
        </div>
    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp"/>
    </div>
</div>

<script type="text/javascript">

    $(function () {

    })

    function doEvaluate() {
        var qus = $("#qusList table td");
        var list = [];
        var isAllReady = true;
        var advise = $("textarea").val();

        for (var i = 0; i < qus.length - 2; i++) {
            var subjectNo = $(qus.get(i)).attr("subjectNo");
            var evaluateQuestionId = $(qus.get(i)).attr("doEvaluateQuestionId");
            var evaluateContent = $(qus.get(i)).attr("doEvaluateContent");
            var answer = $(qus.get(i)).find("input[type='radio']:checked").val();
            if (answer == "undefind") {
                isAllReady = false;
                return;
            }
            list.push({
                "doEvaluateId": null,
                "subjectNo": subjectNo,
                "evaluateQuestionId": evaluateQuestionId,
                "evaluateContent": evaluateContent,
                "answer": answer,
                "advise": advise,
                "userId": ""
            })
        }

        if (isAllReady == false) {
            alert("请检查是否完成答卷");
            return;
        }

        if (list.length >= 0) {
            $.ajax({
                type: "post",
                url: "doEvaluateAction.action",
                data: {"doEvaluateList": JSON.stringify(list)},
                success: function (data) {
                    alert("success");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {

                },

            });
        }

    }


</script>
</body>
</html>
