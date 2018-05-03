package com.dao;

import com.po.DoEvaluate;

import java.util.List;

public interface DoEvaluateDao {
    public List<DoEvaluate> getData(String sql);
    public boolean addDoEvaluate(DoEvaluate doEvaluate);
    public boolean delDoEvaluate(DoEvaluate doEvaluate);
    public boolean updateDoEvaluate(DoEvaluate doEvaluate);
}
