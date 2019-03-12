package Util;

/**
 * Enum to control the catalog of titles to be downloaded.
 * Attributes: name, folder
 *
 * TODO : implement comic.naver:id, last chapter downloaded, add day of week and isCompleted
 */
public enum Titles {
    뷰티풀_군바리("뷰티풀 군바리", "뷰티풀군바리"),
    윈드브레이커("윈드브레이커", "윈드브레이커"),
    이상하고_아름다운("이상하고 아름다운", "이상하고아름다운"),
    마왕이_되는_중2야("마왕이 되는 중2야", "마왕이되는중2야"),
    마이너스의_손("마이너스의 손", "마이너스의손"),
    바른연애_길잡이("바른연애 길잡이", "바른연애길잡이"),
    불괴("불괴", "불괴"),
    신의_언어("신의 언어", "신의언어"),
    신석기녀("신석기녀", "신석기녀"),
    허니버니("허니버니", "허니버니"),
    캉타우("캉타우", "캉타우"),
    테러맨("테러맨", "테러맨"),
    결계녀("결계녀", "결계녀"),
    골든_체인지("골든 체인지", "골든체인지"),
    식스틴("식스틴", "식스틴"),
    옆집친구("옆집친구", "옆집친구"),
    늑대와_빨간모자("늑대와 빨간모자", "늑대와빨간모자"),
    아메리카노_엑소더스("아메리카노 엑소더스", "아메리카노엑소더스"),
    우주최강대스타("우주최강대스타", "우주최강대스타"),
    고교생을_환불해_주세요("고교생을 환불해 주세요", "고교생을환불해주세요"),
    오늘도_사랑스럽개("오늘도 사랑스럽개", "오늘도사랑스럽개"),
    귀도호가록("귀도호가록", "귀도호가록");

    Titles(String name, String folder) {
        this.name = name;
        this.folder = folder;
    }

    private String name;
    private String folder;

    public String getName() {
        return name;
    }

    public String getFolder() {
        return folder;
    }
}
