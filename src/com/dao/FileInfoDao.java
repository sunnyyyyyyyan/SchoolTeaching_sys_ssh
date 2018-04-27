package com.dao;

import com.po.FileInfo;
import org.apache.commons.fileupload.FileItem;

import java.io.OutputStream;
import java.util.List;

public interface FileInfoDao {
    //增删改查
    public boolean uploadFile(FileInfo fileInfo, FileItem item);    //上传文件
    public boolean deleteFile(String id);   //删除文件
    public boolean downloadFile(String id, OutputStream os);    //下载文件
    public List<FileInfo> checkFile(String hql);    //查看文件
}
