package org.sckj.grid_list.bean;

public class GridListBean {
    private String title;
    private String content;
    private String time;
    private String url;
    private String[] imgUrl;

    public GridListBean() {
    }

    public GridListBean(String title, String content, String time, String url, String[] imgUrl) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.url = url;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String[] getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String[] imgUrl) {
        this.imgUrl = imgUrl;
    }
}
