package com.xh.HiXiaoshuoserver.domain;


/**
 * @program: HiXiaoshuo-server
 * @description:
 * @author: XuHao
 * @create: 2018-09-10 15:34
 **/

public class Version {

    /// 是否强制升级
    private Boolean forceUpdate;

    /// 是否展示启动广告
    private Boolean showSplash;

    /// 是否展示章节插页广告
    private Boolean showChapterAD;

    /// 是否展示激励视频广告
    private Boolean showGoogleRewaredAD;

    /// 是否展示个人中心广告栏
    private Boolean showAD;

    /// 章节插页广告时间间隔
    private Integer showChapterADNumber;

    public Integer getShowChapterADNumber() {
        return showChapterADNumber;
    }

    public void setShowChapterADNumber(Integer showChapterADNumber) {
        this.showChapterADNumber = showChapterADNumber;
    }

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