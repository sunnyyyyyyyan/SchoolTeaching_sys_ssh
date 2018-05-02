package com.dao;

import com.po.Evaluate;

import java.util.List;

public interface EvaluateDao {
    public List<Evaluate> getData(String sql);
    public boolean addEvaluate(Evaluate evaluate);
    public boolean delEvaluate(Evaluate evaluate);
    public boolean updateEvaluate(Evaluate evaluate);
}
