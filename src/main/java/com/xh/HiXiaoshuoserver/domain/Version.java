package com.xh.HiXiaoshuoserver.domain;


/**
 * @program: HiXiaoshuo-server
 * @description:
 * @author: XuHao
 * @create: 2018-09-10 15:34
 **/

public class Version {

    private Boolean forceUpdate;

    private Boolean showSplash;

    private Boolean showChapterAD;

    private Boolean showGoogleRewaredAD;

    private Boolean showAD;

    public Boolean getShowAD() {
        return showAD;
    }

    public void setShowAD(Boolean showAD) {
        this.showAD = showAD;
    }

    public Boolean getShowGoogleRewaredAD() {
        return showGoogleRewaredAD;
    }

    public void setShowGoogleRewaredAD(Boolean showGoogleRewaredAD) {
        this.showGoogleRewaredAD = showGoogleRewaredAD;
    }

    public Boolean getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(Boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public Boolean getShowSplash() {
        return showSplash;
    }

    public void setShowSplash(Boolean showSplash) {
        this.showSplash = showSplash;
    }

    public Boolean getShowChapterAD() {
        return showChapterAD;
    }

    public void setShowChapterAD(Boolean showChapterAD) {
        this.showChapterAD = showChapterAD;
    }
}