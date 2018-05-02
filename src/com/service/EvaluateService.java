package com.service;

import com.po.Evaluate;

import java.util.List;

public interface EvaluateService {

    public List<Evaluate> getEvaluateData();
    public String addEvaluate(Evaluate evaluate);

}
