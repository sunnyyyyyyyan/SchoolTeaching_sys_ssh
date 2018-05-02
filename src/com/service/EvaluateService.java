package com.service;

import com.po.Evaluate;

import java.util.List;

public interface EvaluateService {

    public List<Evaluate> getEvaluateData();
    public String addEvaluate(Evaluate evaluate);           //添加学评

    public List<Evaluate> getEvaluateData(String subjectNo);    ////学生根据subjectNo获取教学评价题目

}
