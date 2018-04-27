package com.dao.impl;

import com.dao.FileInfoDao;
import com.po.FileInfo;
import org.apache.commons.fileupload.FileItem;

import java.io.OutputStream;
import java.util.List;

public class FileInfoDaoImpl implements FileInfoDao {


    //上传文件
    @Override
    public boolean uploadFile(FileInfo fileInfo, FileItem item) {
        return false;
    }

    @Override
    public boolean deleteFile(String id) {
        return false;
    }

    @Override
    public boolean downloadFile(String id, OutputStream os) {
        return false;
    }

    @Override
    public List<FileInfo> checkFile(String hql) {
        return null;
    }
}
