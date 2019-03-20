package Util;

/**
 * Contain useful links and default paths
 */
public class Constantes {
    private String ComicNaver = "https://comic.naver.com";

    private String DetailTitleId = "/webtoon/detail.nhn?titleId=";
    private String DetailChapter = "&no=";
    private String ListTitleId = "/webtoon/list.nhn?titleId=";
    private String ListPage = "&page=";

    private String directory = "/Users/joao/Documents/Webtoons/";

    private Integer timeout = 5 * 1000; // value in milis

    public String getComicNaver() {
        return ComicNaver;
    }

    public String getDetailTitleId() {
        return DetailTitleId;
    }

    public String getDetailChapter() {
        return DetailChapter;
    }

    public String getListTitleId() {
        return ListTitleId;
    }

    public String getDirectory() {
        return directory;
    }

    public Integer getTimeOut() {
        return timeout;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeout = timeout;
    }

    public String getLinkUrl(Integer titleId, Integer chapter){
        return ComicNaver + DetailTitleId + titleId + DetailChapter + chapter;
    }

    public String getLinksFromPage(Integer titleId, Integer page){
        return ComicNaver + ListTitleId + titleId + ListPage + page;
    }
}
