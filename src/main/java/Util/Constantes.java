package Util;

/**
 * Contain useful links and default paths
 */
public class Constantes {
    private static String ComicNaver = "https://comic.naver.com";

    private static String DetailTitleId = "/webtoon/detail.nhn?titleId=";
    private static String DetailChapter = "&no=";
    private static String ListTitleId = "/webtoon/list.nhn?titleId=";
    private static String ListPage = "&page=";

    private static String directory = "/Users/joao/Documents/Webtoons/";

    private static Integer timeout = 5 * 1000; // value in milis

    public static String getComicNaver() {
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

    public static String getDirectory() {
        return directory;
    }

    public static Integer getTimeOut() {
        return timeout;
    }

    public static String getLinkUrl(Integer titleId, Integer chapter){
        return ComicNaver + DetailTitleId + titleId + DetailChapter + chapter;
    }

    public static String getLinksFromPage(Integer titleId, Integer page){
        return ComicNaver + ListTitleId + titleId + ListPage + page;
    }
}
