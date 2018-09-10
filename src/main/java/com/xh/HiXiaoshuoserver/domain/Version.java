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