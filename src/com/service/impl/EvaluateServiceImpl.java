package com.service.impl;

import com.dao.DoEvaluateDao;
import com.dao.EvaluateDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.DoEvaluate;
import com.po.Evaluate;
import com.service.EvaluateService;

import java.util.List;

public class EvaluateServiceImpl implements EvaluateService {
    private EvaluateDao evaluateDao;
    private DoEvaluateDao doEvaluateDao;

    public DoEvaluateDao getDoEvaluateDao() {
        return doEvaluateDao;
    }

    public void setDoEvaluateDao(DoEvaluateDao doEvaluateDao) {
        this.doEvaluateDao = doEvaluateDao;
    }

    public EvaluateDao getEvaluateDao() {
        return evaluateDao;
    }

    public void setEvaluateDao(EvaluateDao evaluateDao) {
        this.evaluateDao = evaluateDao;
    }

    @Override
    public List<Evaluate> getEvaluateData() {
        String sql = "from Evaluate";
        List<Evaluate> list = this.evaluateDao.getData(sql);
        return list;
    }

    @Override
    public String addEvaluate(Evaluate evaluate) {
        String sql = "from Evaluate where subjectNo='"+evaluate.getSubjectNo()+"' and evaluateQuestionId='"+evaluate.getEvaluateQuestionId()+"'";
        List<Evaluate> list = this.evaluateDao.getData(sql);
        if (list.size()>0){
            ActionContext.getContext().put("addEvaluateMess","该题号已存在！");
            return "addEvaluateError";
        }
        if (this.evaluateDao.addEvaluate(evaluate)){
            ActionContext.getContext().put("addEvaluateMess","添加成功！");
            return "addEvaluateSuccess";
        }
        ActionContext.getContext().put("addEvaluateMess","添加失败！");
        return "addEvaluateError";
    }

    @Override
    public List<Evaluate> getEvaluateData(String subjectNo) {
        String sql = "from Evaluate where subjectNo='"+subjectNo+"'";
        List<Evaluate> list = this.evaluateDao.getData(sql);
        return list;
    }

    @Override
    public String addDoEvaluate(DoEvaluate doEvaluate) {
        String sql = "from DoEvaluate where subjectNo='"+doEvaluate.getSubjectNo()+"' and evaluateQuestionId='"+doEvaluate.getEvaluateQuestionId()+"' and userId='"+doEvaluate.getUserId()+"'";
        List<DoEvaluate> list = this.doEvaluateDao.getData(sql);
        if (list.size()>0){
            ActionContext.getContext().put("doEvaluateErrorMess","已评教！");
            return "doEvaluateError";
        }
        if (this.doEvaluateDao.updateDoEvaluate(doEvaluate)){
            ActionContext.getContext().put("doEvaluateErrorMess","评教成功！");
            return "doEvaluateSuccess";
        }
        ActionContext.getContext().put("doEvaluateErrorMess","评教失败！");
        return "doEvaluateError";
    }

    @Override
    public List<DoEvaluate> getDoEvaluate() {
        return null;
    }
}
