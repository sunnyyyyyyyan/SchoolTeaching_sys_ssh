package com.dao;

import com.po.Subject;

import java.util.List;

public interface SubjectDao {
    public List<Subject> getData(String sql);
    public boolean addSubject(Subject subject);
    public boolean delSubject(Subject subject);
    public boolean updateSubject(Subject subject);

    //查询所有课程列表
    public List<Subject> getAllSubjectData(int pageNow, int pageSize);
    public int findAllSubjectSize();
}
