package Util;

/**
 * Enum to control the catalog of titles to be downloaded.
 * Attributes: name, folder
 *
 * TODO : implement last chapter downloaded, add day of week and isCompleted
 */
public enum Titles {
    뷰티풀_군바리("뷰티풀 군바리", "뷰티풀군바리", 648419, 0),
    윈드브레이커("윈드브레이커", "윈드브레이커", 602910, 0),
    이상하고_아름다운("이상하고 아름다운", "이상하고아름다운", 668723, 0),
    마왕이_되는_중2야("마왕이 되는 중2야", "마왕이되는중2야", 694807, 0),
    마이너스의_손("마이너스의 손", "마이너스의손", 679568, 0),
    바른연애_길잡이("바른연애 길잡이", "바른연애길잡이", 703852, 0),
    불괴("불괴", "불괴", 710766, 0),
    신의_언어("신의 언어", "신의언어", 602287, 0),
    신석기녀("신석기녀", "신석기녀", 703308, 0),
    허니버니("허니버니", "허니버니", 719277, 0),
    캉타우("캉타우", "캉타우", 714293, 0),
    테러맨("테러맨", "테러맨", 670149, 0),
    결계녀("결계녀", "결계녀", 668101, 0),
    골든_체인지("골든 체인지", "골든체인지", 685460, 0),
    식스틴("식스틴", "식스틴", 703854, 0),
    옆집친구("옆집친구", "옆집친구", 718019, 0),
    늑대와_빨간모자("늑대와 빨간모자", "늑대와빨간모자", 716163, 0),
    아메리카노_엑소더스("아메리카노 엑소더스", "아메리카노엑소더스", 622644, 0),
    우주최강대스타("우주최강대스타", "우주최강대스타", 721462, 0),
    고교생을_환불해_주세요("고교생을 환불해 주세요", "고교생을환불해주세요", 708453, 0),
    오늘도_사랑스럽개("오늘도 사랑스럽개", "오늘도사랑스럽개", 699658, 0),
    귀도호가록("귀도호가록", "귀도호가록", 665170, 0);

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
