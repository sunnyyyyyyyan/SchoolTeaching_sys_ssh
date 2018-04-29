package com.dao;


import com.po.Selection;

import java.util.List;

public interface SelectionDao {
    public List<Selection> getData(String sql);
    public boolean addSelection(Selection selection);
    public boolean delSelection(Selection selection);
    public boolean updateSelection(Selection selection);
}
