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
        String sql = "from Test";
        List<Test> list = this.testDao.getData(sql);
        /*for (int i = 0; i < list.size(); i++) {
            Test test = list.get(i);
            if (test.getQuestionType().equals("选择")){
                String hql = "select new Test(t.testAdder, t.testName, t.subName, t.subNo, t.questionType, t.questionId, t.questionContent, t.answer, t.setGrade, s.selectA, s.selectB, s.selectC, s.selectD) from Test t,Selection s where t.subName=s.subName and t.subNo=s.subNo and t.questionId=s.questionId and t.testId='"+test.getTestId()+"'";
                List<Test> list1 = this.testDao.getData(hql);
                return list1;
            }
            return list;
        }*/
        return list;
    }

    @Override
    public List<Test> showTest(String subjectNo) {
        String sql = "from Test where subjectNo='"+subjectNo+"'";
        List<Test> list = this.testDao.getData(sql);
        if (list.size()>0) {
            Test test = list.get(0);
            String subjectName = test.getSubName();
            ActionContext.getContext().getSession().put("subjectName", subjectName);
            return list;
        }
        return null;
    }
}
