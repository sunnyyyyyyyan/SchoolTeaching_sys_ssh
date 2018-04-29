package com.service;

import com.po.Subject;

import java.util.List;

public interface SubjectService {
    public String addSubject(Subject subject);
    public List<Subject> showAllSubject();
    public String updateSubject(Subject subject);
}
