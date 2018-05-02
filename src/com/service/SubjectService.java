package com.service;

import com.po.ChooseSubject;
import com.po.Subject;

import java.util.List;

public interface SubjectService {
    public String addSubject(Subject subject);
    public List<Subject> showAllSubject();
    public String updateSubject(Subject subject);

    public String addChooseSubject(ChooseSubject chooseSubject);
    public List<ChooseSubject> showAllChooseSubjectUserId(String subjectNo);
    public List<ChooseSubject> showSubjectByUserId(String userId);
    public List<ChooseSubject> showChooseUser(String userId);
}
