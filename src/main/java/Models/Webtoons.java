package Models;

public interface Webtoons {
    public void all();

    public void byChapter();

    public void downloadChapter(String name, String folder);

    public void downloadChapter(String name, String folder, Integer titleId);

    public boolean isDownloaded(String search);

    //TODO : implement based on last chapter downloaded
    //public void downloadChapter(String name, String folder, Integer titleId, Integer lastChapter);

    //TODO : implement based on day of week (mon, tue, wed, thu, fri, sat and sun) > add to enum
}
