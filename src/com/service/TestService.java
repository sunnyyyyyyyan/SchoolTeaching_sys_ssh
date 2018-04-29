package com.service;


import com.po.Test;

import java.util.List;

public interface TestService {
    public String addTest(Test test);
    public List<Test> showTest();
}
