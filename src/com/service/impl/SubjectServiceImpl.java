package com.service.impl;

import com.dao.ChooseSubjectDao;
import com.dao.SubjectDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.ChooseSubject;
import com.po.Subject;
import com.service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    private SubjectDao subjectDao;
    private ChooseSubjectDao chooseSubjectDao;

    public ChooseSubjectDao getChooseSubjectDao() {
        return chooseSubjectDao;
    }

    public void setChooseSubjectDao(ChooseSubjectDao chooseSubjectDao) {
        this.chooseSubjectDao = chooseSubjectDao;
    }

    public SubjectDao getSubjectDao() {
        return subjectDao;
    }

    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }


    //添加课程
    @Override
    public String addSubject(Subject subject) {
        String sql = "from Subject where subjectNo='"+subject.getSubjectNo()+"'";
        List<Subject> list = this.subjectDao.getData(sql);
        if (list.size()>0){
            ActionContext.getContext().put("addSubjectMess","课程已存在！");
            return "addSubjectError";
        }
        if (this.subjectDao.addSubject(subject)){
            ActionContext.getContext().put("addSubjectMess","添加成功！");
            return "addSubjectSuccess";
        }
        ActionContext.getContext().put("addSubjectMess","添加失败！");
        return "addSubjectError";
    }

    @Override
    public List<Subject> showAllSubject() {
        String sql = "from Subject";
        List<Subject> list = this.subjectDao.getData(sql);
        return list;
    }

    @Override
    public String updateSubject(Subject subject) {
        String sql = "from Subject where subjectNo='"+subject.getSubjectNo()+"'";
        List<Subject> list = this.subjectDao.getData(sql);
        Subject subject1 = list.get(0);
        subject1.setUserId(subject.getChangeUserId());
        if (this.subjectDao.updateSubject(subject1)){
            return "changeUserSubjectSuccess";
        }
        return "changeUserSubjectError";
    }

    //根据userId获取课程信息
    @Override
    public List<ChooseSubject> showSubjectByUserId(String userId) {
        String sql = "from ChooseSubject where chooseUserId='"+userId+"'";
        List<ChooseSubject> list =this.chooseSubjectDao.getData(sql);
        return list;
    }

    @Override
    public String addChooseSubject(ChooseSubject chooseSubject) {
        String sql = "from ChooseSubject where subjectNo='"+chooseSubject.getSubjectNo()+"' and chooseUserId='"+chooseSubject.getChooseUserId()+"'";
        List<ChooseSubject> list = this.chooseSubjectDao.getData(sql);
        if (list.size()>0){
            ActionContext.getContext().put("chooseSubjectMess","你已选过此课程！");
            return "chooseSubjectError";
        }
        if (this.chooseSubjectDao.addChooseSubject(chooseSubject)){
            ActionContext.getContext().put("chooseSubjectMess","选课成功！");
            return "chooseSubjectSuccess";
        }
        ActionContext.getContext().put("chooseSubjectMess","选课失败！");
        return "chooseSubjectError";
    }

    @Override
    public List<ChooseSubject> showAllChooseSubjectUserId(String subjectNo) {
        String hql = "select new ChooseSubject(c.subjectName,c.chooseUserId,u.username) from User u,ChooseSubject c where u.userId=c.chooseUserId and c.subjectNo='"+subjectNo+"'";
        //String sql = "from ChooseSubject where subjectNo='"+subjectNo+"'";
        List<ChooseSubject> list = this.chooseSubjectDao.getData(hql);
        return list;
    }
}
