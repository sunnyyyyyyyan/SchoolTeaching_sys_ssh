package com.service.impl;

import com.dao.EvaluateDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.Evaluate;
import com.service.EvaluateService;

import java.util.List;

public class EvaluateServiceImpl implements EvaluateService {
    private EvaluateDao evaluateDao;

    public EvaluateDao getEvaluateDao() {
        return evaluateDao;
    }

    public void setEvaluateDao(EvaluateDao evaluateDao) {
        this.evaluateDao = evaluateDao;
    }

    @Override
    public List<Evaluate> getEvaluateData() {
        return null;
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
}
