package com.service.impl;

import com.dao.TestDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.Test;
import com.service.TestService;

import java.util.List;

public class TestServiceImpl implements TestService {
    private TestDao testDao;

    public TestDao getTestDao() {
        return testDao;
    }

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }


    @Override
    public String addTest(Test test) {
        String sql = "from Test where testName = '"+test.getTestName()+"' and subName = '"+test.getSubjectNo()+"' and questionId = '"+test.getQuestionId()+"'";
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
        String sql = "from Test";
        List<Test> list = this.testDao.getData(sql);
        return list;
    }

    @Override
    public List<Test> showTest(String subjectNo) {
        String sql = "from Test where subjectNo='"+subjectNo+"'";
        List<Test> list = this.testDao.getData(sql);
        return list;
    }

    @Override
    public List<Test> showAllTestData(int pageNow, int pageSize) {
        List<Test> list = this.testDao.getAllTestData(pageNow,pageSize);
        return list;
    }

    @Override
    public int findAllTestSize() {
        return this.testDao.findAllTestSize();
    }
}
