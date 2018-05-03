package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.po.DoEvaluate;
import com.po.Evaluate;
import com.service.EvaluateService;

import java.util.List;

public class EvaluateAction {
    private String subjectNo;
    private String evaluateQuestionId;
    private String evaluateContent;
    private String selectA;
    private String selectB;
    private String selectC;
    private String selectD;
    private EvaluateService evaluateService;


    private String answer;
    private String advise;
    private String userId;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAdvise() {
        return advise;
    }

    public void setAdvise(String advise) {
        this.advise = advise;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo;
    }

    public String getEvaluateQuestionId() {
        return evaluateQuestionId;
    }

    public void setEvaluateQuestionId(String evaluateQuestionId) {
        this.evaluateQuestionId = evaluateQuestionId;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public String getSelectA() {
        return selectA;
    }

    public void setSelectA(String selectA) {
        this.selectA = selectA;
    }

    public String getSelectB() {
        return selectB;
    }

    public void setSelectB(String selectB) {
        this.selectB = selectB;
    }

    public String getSelectC() {
        return selectC;
    }

    public void setSelectC(String selectC) {
        this.selectC = selectC;
    }

    public String getSelectD() {
        return selectD;
    }

    public void setSelectD(String selectD) {
        this.selectD = selectD;
    }

    public EvaluateService getEvaluateService() {
        return evaluateService;
    }

    public void setEvaluateService(EvaluateService evaluateService) {
        this.evaluateService = evaluateService;
    }

    //添加学评
    public String addEvaluate(){
        if (this.getSubjectNo()==null||this.getSubjectNo().equals("")||
                this.getEvaluateQuestionId()==null||this.getEvaluateQuestionId().equals("")||
                this.getEvaluateContent()==null||this.getEvaluateContent().equals("")){
            ActionContext.getContext().put("addEvaluateMess","*不能为空！");
            return "addEvaluateError";
        }
        Evaluate evaluate = new Evaluate();
        evaluate.setSubjectNo(this.subjectNo);
        evaluate.setEvaluateQuestionId(this.evaluateQuestionId);
        evaluate.setEvaluateContent(this.evaluateContent);
        evaluate.setSelectA(this.selectA);
        evaluate.setSelectB(this.selectB);
        evaluate.setSelectC(this.selectC);
        evaluate.setSelectD(this.selectD);
        String strMess = this.evaluateService.addEvaluate(evaluate);
        if (strMess.equals("addEvaluateSuccess")) {
            return "addEvaluateSuccess";
        }
        return "addEvaluateError";
    }


    //学生根据subjectNo获取教学评价题目
    public String getEvaluateTest(){
        List<Evaluate> list = this.evaluateService.getEvaluateData(this.subjectNo);
        if (list.size()>0) {
            ActionContext.getContext().put("getEvaluateTest", list);
            return "getEvaluateTestSuccess";
        }
        ActionContext.getContext().put("getEvaluateTestMess", "暂无评教题目！");
        return "getEvaluateTestError";
    }

    //保存学生的评价答案
    public String doEvaluate(){
        DoEvaluate doEvaluate = new DoEvaluate();
        doEvaluate.setSubjectNo(this.subjectNo);
        doEvaluate.setEvaluateQuestionId(this.evaluateQuestionId);
        doEvaluate.setEvaluateContent(this.evaluateContent);
        doEvaluate.setAnswer(this.answer);
        doEvaluate.setAdvise(this.advise);
        doEvaluate.setUserId(this.userId);
        String strMess = this.evaluateService.addDoEvaluate(doEvaluate);
        if (strMess.equals("doEvaluateSuccess")) {
            return "doEvaluateSuccess";
        }
        return "doEvaluateError";
    }
}
