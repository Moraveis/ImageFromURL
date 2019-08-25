package Util;

/**
 * Contain useful links and default paths
 */
public class Constantes {

    public static String COMIC_NAVER = "https://comic.naver.com";
    public static String DIRECTORY = "/Users/joao/Documents/Webtoons/";
    public static Integer TIMEOUT = 5 * 1000; // value in milis

    public static String DETAIL_TITLE_ID = "/webtoon/detail.nhn?titleId=";
    public static String DETAIL_CHAPTER = "&no=";
    public static String LIST_TITLE_ID = "/webtoon/list.nhn?titleId=";
    public static String LIST_PAGE = "&page=";

    public static String getLinkUrl(Integer titleId, Integer chapter){
        return COMIC_NAVER + DETAIL_TITLE_ID + titleId + DETAIL_CHAPTER + chapter;
    }

    public static String getLinksFromPage(Integer titleId, Integer page){
        return COMIC_NAVER + LIST_TITLE_ID + titleId + LIST_PAGE + page;
    }
}
