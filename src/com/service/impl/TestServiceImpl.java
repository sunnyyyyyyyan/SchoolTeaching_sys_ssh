package com.service.impl;

import com.dao.SelectionDao;
import com.dao.TestDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.Selection;
import com.po.Test;
import com.service.TestService;

import java.util.List;

public class TestServiceImpl implements TestService {
    private TestDao testDao;
    private SelectionDao selectionDao;

    public SelectionDao getSelectionDao() {
        return selectionDao;
    }

    public void setSelectionDao(SelectionDao selectionDao) {
        this.selectionDao = selectionDao;
    }

    public TestDao getTestDao() {
        return testDao;
    }

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public String addTest(Test test, Selection selection) {
        String sql = "from Test where testName = '"+test.getTestName()+"' and subName = '"+test.getSubName()+"' and questionId = '"+test.getQuestionId()+"'";
        List<Test> list = this.testDao.getData(sql);
        if (list.size()>0){
            ActionContext.getContext().put("addQuestionMess","该题目已存在！");
            return "addQuestionError";
        }
        boolean mess1 = this.testDao.addTest(test);
        boolean mess2 = this.selectionDao.addSelection(selection);
        if (mess1&&mess2){
            ActionContext.getContext().put("addQuestionMess","添加成功！");
            return "addQuestionSuccess";
        }
        ActionContext.getContext().put("addQuestionMess","添加失败！");
        return "addQuestionError";
    }

    @Override
    public String addTest(Test test) {
        String sql = "from Test where testName = '"+test.getTestName()+"' and subName = '"+test.getSubName()+"' and questionId = '"+test.getQuestionId()+"'";
        List<Test> list = this.testDao.getData(sql);
        if (list.size()>0){
            ActionContext.getContext().put("addQuestionMess","该题目已存在！");
            return "addQuestionError";
        }
        if (this.testDao.addTest(test)){
            ActionContext.getContext().put("addQuestionMess","添加成功！");
            return "addQuestionSuccess";
        }
        ActionContext.getContext().put("addQuestionMess","添加失败！");
        return "addQuestionError";
    }

    @Override
    public List<Test> showTest() {
        return null;
    }
}
