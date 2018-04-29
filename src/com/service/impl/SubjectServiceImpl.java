package com.service.impl;

import com.dao.SubjectDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.Subject;
import com.service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    private SubjectDao subjectDao;

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
}
