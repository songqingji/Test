package com.feicui.everyproject.entity;

/**
 * 新闻实体类
 * Created by Eric on 2016/9/22.
 */
public class TestEntity {

    private String title;
    private String date;
    private String category;
    private String author_name;
    private String thumbnail_pic_s;
    private String url;
    private String thumbnail_pic_s03;


    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getThumbnail_pic_s03() {
        return thumbnail_pic_s03;
    }

    public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
        this.thumbnail_pic_s03 = thumbnail_pic_s03;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "author_name='" + author_name + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
                ", url='" + url + '\'' +
                ", thumbnail_pic_s03='" + thumbnail_pic_s03 + '\'' +
                '}';
    }
}
