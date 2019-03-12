package Util;

/**
 * Enum to control the catalog of titles to be downloaded.
 * Attributes: name, folder
 *
 * TODO : implement comic.naver:id, last chapter downloaded, add day of week and isCompleted
 */
public enum Titles {
    뷰티풀_군바리("뷰티풀 군바리", "뷰티풀군바리", 0, 0),
    윈드브레이커("윈드브레이커", "윈드브레이커", 0, 0),
    이상하고_아름다운("이상하고 아름다운", "이상하고아름다운", 0, 0),
    마왕이_되는_중2야("마왕이 되는 중2야", "마왕이되는중2야", 0, 0),
    마이너스의_손("마이너스의 손", "마이너스의손", 0, 0),
    바른연애_길잡이("바른연애 길잡이", "바른연애길잡이", 0, 0),
    불괴("불괴", "불괴", 0, 0),
    신의_언어("신의 언어", "신의언어", 0, 0),
    신석기녀("신석기녀", "신석기녀", 0, 0),
    허니버니("허니버니", "허니버니", 0, 0),
    캉타우("캉타우", "캉타우", 0, 0),
    테러맨("테러맨", "테러맨", 0, 0),
    결계녀("결계녀", "결계녀", 0, 0),
    골든_체인지("골든 체인지", "골든체인지", 0, 0),
    식스틴("식스틴", "식스틴", 0, 0),
    옆집친구("옆집친구", "옆집친구", 0, 0),
    늑대와_빨간모자("늑대와 빨간모자", "늑대와빨간모자", 0, 0),
    아메리카노_엑소더스("아메리카노 엑소더스", "아메리카노엑소더스", 0, 0),
    우주최강대스타("우주최강대스타", "우주최강대스타", 0, 0),
    고교생을_환불해_주세요("고교생을 환불해 주세요", "고교생을환불해주세요", 0, 0),
    오늘도_사랑스럽개("오늘도 사랑스럽개", "오늘도사랑스럽개", 0, 0),
    귀도호가록("귀도호가록", "귀도호가록", 0, 0);

    Titles(String name, String folder, Integer titleId, Integer chapter) {
        this.name = name;
        this.folder = folder;
        this.titleId = titleId;
        this.chapter = chapter;
    }

    private String name;
    private String folder;
    private Integer titleId;
    private Integer chapter;

    public String getName() {
        return name;
    }

    public String getFolder() {
        return folder;
    }

    public Integer getTitleId() { return titleId; }

    public Integer getChapter() { return chapter; }
}
