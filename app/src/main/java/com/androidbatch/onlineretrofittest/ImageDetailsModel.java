package com.androidbatch.onlineretrofittest;

class ImageDetailsModel {
    String date, explanation, hdurl, url;

    public ImageDetailsModel(String date, String explanation, String hdurl, String url) {
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
