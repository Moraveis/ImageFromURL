package Util;

/**
 * Contain useful links and default paths
 */
public class Constantes {
    private String COMIC_NAVER = "https://comic.naver.com/webtoon/";

    private String DETAIL_TITLE_ID = "detail.nhn?titleId=";
    private String DETAIL_CHAPTER = "&no=";
    private String LIST_TITLE_ID = "list.nhn?titleId=";
    private String LIST_PAGE = "&page=";
    private Integer START_PAGE = 1;
    private Integer END_PAGE = 1;

    private String PATH = "/Users/joao/Documents/";
    private String DIRECTORY = "Webtoons/";

    private Integer TIMEOUT = 5;

    public String getComicNaver() {
        return COMIC_NAVER;
    }

    public String getDetailTitleId() {
        return DETAIL_TITLE_ID;
    }

    public String getDetailChapter() {
        return DETAIL_CHAPTER;
    }

    public String getListTitleId() {
        return LIST_TITLE_ID;
    }

    public String getPath() {
        return PATH;
    }

    public String getDirectory() {
        return DIRECTORY;
    }

    public Integer getStartPage() {
        return START_PAGE;
    }

    public void setStartPage(Integer startPage) {
        this.START_PAGE = START_PAGE;
    }

    public Integer getEndPage() {
        return END_PAGE;
    }

    public void setEndPAge(Integer endPage) {
        this.END_PAGE = END_PAGE;
    }

    public Integer getTimeOut() {
        return TIMEOUT;
    }

    public void setTimeOut(Integer timeOut) {
        this.TIMEOUT = TIMEOUT;
    }

    public String getLinkUrl(Integer titleId, Integer chapter){
        return COMIC_NAVER + DETAIL_TITLE_ID + titleId + DETAIL_CHAPTER + chapter;
    }
}
