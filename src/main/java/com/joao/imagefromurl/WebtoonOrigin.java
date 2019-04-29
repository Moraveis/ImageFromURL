/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joao.imagefromurl;

import Util.Titles;

import java.util.logging.Logger;

/**
 *
 * @author joao
 */
public class WebtoonOrigin {

    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static String urlBase = "https://comic.naver.com";
    private static String folder = "general";

    public static void main(String[] args) {
        ComicNaver cn = new ComicNaver();

        cn.all(Titles.마왕이_되는_중2야,1,5);

        /*
        cn.downloadChapter("205화_검열 7", "/webtoon/detail.nhn?titleId=648419&no=209&weekday=mon", Titles.뷰티풀_군바리);
        cn.downloadChapter("206화_검열 8", "/webtoon/detail.nhn?titleId=648419&no=210&weekday=mon", Titles.뷰티풀_군바리);
        cn.downloadChapter("207화_검열 뒤풀이", "/webtoon/detail.nhn?titleId=648419&no=211&weekday=mon", Titles.뷰티풀_군바리);
        cn.downloadChapter("208화_845K 전역", "/webtoon/detail.nhn?titleId=648419&no=212&weekday=mon", Titles.뷰티풀_군바리);
        */
    }

}
