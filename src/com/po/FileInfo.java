package com.po;

public class FileInfo {
    private String id;//唯一标识
    private String name;//文件保存名称
    private String uploadTime;//上传日期
    private String savePath;//文件保存目录
    private String description;//文件描述
    private String uploader;//上传者

    @Override
    public String toString() {
        return "FileInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", savePath='" + savePath + '\'' +
                ", description='" + description + '\'' +
                ", uploader='" + uploader + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
