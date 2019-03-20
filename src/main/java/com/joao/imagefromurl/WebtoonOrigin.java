/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joao.imagefromurl;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import Util.Titles;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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


        cn.all(Titles.뷰티풀_군바리, 1, 2);
    }

    private static void all() {
        String linkChapter = "/webtoon/list.nhn?titleId=710757&weekday=sun&page=";
        String url = "";
        Integer startPage = 1;
        Integer totalPages = 3;  // 3
        List<String> lstDown = new ArrayList<>();

        Connection con = null;
        Document doc = null;

        HashMap<String, String> mapchapters = new LinkedHashMap<>();

        try {
            for (int i = startPage; i <= totalPages; i++) {
                url = urlBase + linkChapter + i;

                con = Jsoup.connect(url);
                doc = con.get();

                Elements viewList = doc.getElementsByClass("viewList");
                Elements trs = viewList.get(0).getElementsByClass("title");
                for (Element e : trs) {
                    String title = e.text();
                    String link = e.getElementsByTag("a").get(0).attr("href");

//                    if (!downloaded(title)) {
                    mapchapters.put(title, link);
                    System.out.println(title + " - " + link);
//                    }
                }

                Thread.sleep(15 * 1000);
            }

            if (mapchapters.size() > 0) {
                for (Map.Entry<String, String> entry : mapchapters.entrySet()) {
                    downloadChapter(entry.getKey(), entry.getValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void one() {
//        //MONDAY
//        downloadChapter("192화_봄이 남자 친구 1", "/webtoon/detail.nhn?titleId=648419&no=196&weekday=mon", "뷰티풀군바리");
//        downloadChapter("193화 봄이 남자 친구 2", "/webtoon/detail.nhn?titleId=648419&no=197&weekday=mon", "뷰티풀군바리");
//        downloadChapter("194화_봄이 남자 친구 3", "/webtoon/detail.nhn?titleId=648419&no=198&weekday=mon", "뷰티풀군바리");
//        downloadChapter("195화_봄이 남자 친구 4", "/webtoon/detail.nhn?titleId=648419&no=199&weekday=mon", "뷰티풀군바리");
//        downloadChapter("196화_844k 전역 1", "/webtoon/detail.nhn?titleId=648419&no=200&weekday=mon", "뷰티풀군바리");
//        
//        downloadChapter("2부(下) 114화", "/webtoon/detail.nhn?titleId=602910&no=247&weekday=mon", "윈드브레이커");
//        downloadChapter("2부(下) 115화", "/webtoon/detail.nhn?titleId=602910&no=248&weekday=mon", "윈드브레이커");
//        downloadChapter("2부(下) 116화", "/webtoon/detail.nhn?titleId=602910&no=249&weekday=mon", "윈드브레이커");
//        downloadChapter("2부(下) 117화 첫눈 오는 날 (마지막 화)", "/webtoon/detail.nhn?titleId=602910&no=250&weekday=mon", "윈드브레이커");
//        
//        downloadChapter("3부 49화", "/webtoon/detail.nhn?titleId=668723&no=149&weekday=mon", "이상하고아름다운");
//        downloadChapter("3부 50화", "/webtoon/detail.nhn?titleId=668723&no=150&weekday=mon", "이상하고아름다운");
//        downloadChapter("3부 51화", "/webtoon/detail.nhn?titleId=668723&no=151&weekday=mon", "이상하고아름다운");
//        downloadChapter("3부 52화", "/webtoon/detail.nhn?titleId=668723&no=152&weekday=mon", "이상하고아름다운");
//        downloadChapter("3부 53화", "/webtoon/detail.nhn?titleId=668723&no=153&weekday=mon", "이상하고아름다운");
//        downloadChapter("3부 54화", "/webtoon/detail.nhn?titleId=668723&no=154&weekday=mon", "이상하고아름다운");

        //TUESRDAY
//        downloadChapter("42", "/webtoon/detail.nhn?titleId=703852&no=42&weekday=tue", "바른연애길잡이");
//        downloadChapter("43", "/webtoon/detail.nhn?titleId=703852&no=43&weekday=tue", "바른연애길잡이");
//        downloadChapter("44", "/webtoon/detail.nhn?titleId=703852&no=44&weekday=tue", "바른연애길잡이");
//        downloadChapter("45", "/webtoon/detail.nhn?titleId=703852&no=45&weekday=tue", "바른연애길잡이");
//        downloadChapter("46", "/webtoon/detail.nhn?titleId=703852&no=46&weekday=tue", "바른연애길잡이");
//        downloadChapter("47", "/webtoon/detail.nhn?titleId=703852&no=47&weekday=tue", "바른연애길잡이");

        //WEDNESDAY
//        downloadChapter("51화", "/webtoon/detail.nhn?titleId=703308&no=52&weekday=wed", "신석기녀");
//        downloadChapter("52화", "/webtoon/detail.nhn?titleId=703308&no=53&weekday=wed", "신석기녀");
//        downloadChapter("53화", "/webtoon/detail.nhn?titleId=703308&no=54&weekday=wed", "신석기녀");
//        downloadChapter("54화", "/webtoon/detail.nhn?titleId=703308&no=55&weekday=wed", "신석기녀");
//        downloadChapter("55화", "/webtoon/detail.nhn?titleId=703308&no=56&weekday=wed", "신석기녀");
//        downloadChapter("56화", "/webtoon/detail.nhn?titleId=703308&no=57&weekday=wed", "신석기녀");

        //THURSDAY

        //FRIDAY
//        downloadChapter("시즌2 37화", "/webtoon/detail.nhn?titleId=670149&no=139&weekday=fri", "테러맨");
//        downloadChapter("시즌2 38화", "/webtoon/detail.nhn?titleId=670149&no=140&weekday=fri", "테러맨");
//        downloadChapter("시즌2 39화", "/webtoon/detail.nhn?titleId=670149&no=141&weekday=fri", "테러맨");
//        downloadChapter("시즌2 40화", "/webtoon/detail.nhn?titleId=670149&no=142&weekday=fri", "테러맨");
//        downloadChapter("시즌2 41화", "/webtoon/detail.nhn?titleId=670149&no=143&weekday=fri", "테러맨");
//        downloadChapter("시즌2 42화", "/webtoon/detail.nhn?titleId=670149&no=144&weekday=fri", "테러맨");
//        
//        downloadChapter("158화. 전하지 못한 말 2", "/webtoon/detail.nhn?titleId=668101&no=159&weekday=fri", "결계녀");
//        downloadChapter("159화. 낙엽이 떨어지고", "/webtoon/detail.nhn?titleId=668101&no=160&weekday=fri", "결계녀");
//        downloadChapter("160화. 악의 1", "/webtoon/detail.nhn?titleId=668101&no=161&weekday=fri", "결계녀");
//        downloadChapter("161화. 악의 2", "/webtoon/detail.nhn?titleId=668101&no=162&weekday=fri", "결계녀");
//        downloadChapter("162화. 악의 3", "/webtoon/detail.nhn?titleId=668101&no=163&weekday=fri", "결계녀");
//        downloadChapter("163화. 결전의 날 1", "/webtoon/detail.nhn?titleId=668101&no=164&weekday=fri", "결계녀");
//        
//        downloadChapter("116화", "/webtoon/detail.nhn?titleId=685460&no=116&weekday=fri", "골든체인지");
//        downloadChapter("117화", "/webtoon/detail.nhn?titleId=685460&no=117&weekday=fri", "골든체인지");
//        downloadChapter("118화", "/webtoon/detail.nhn?titleId=685460&no=118&weekday=fri", "골든체인지");
//        downloadChapter("119화", "/webtoon/detail.nhn?titleId=685460&no=119&weekday=fri", "골든체인지");
//        downloadChapter("120화", "/webtoon/detail.nhn?titleId=685460&no=120&weekday=fri", "골든체인지");
//        downloadChapter("121화", "/webtoon/detail.nhn?titleId=685460&no=121&weekday=fri", "골든체인지");
//        
//        downloadChapter("39화. 관계의 정의(12)", "/webtoon/detail.nhn?titleId=703854&no=39&weekday=fri", "식스틴");
//        downloadChapter("40화. 관계의 정의(13)", "/webtoon/detail.nhn?titleId=703854&no=40&weekday=fri", "식스틴");
//        downloadChapter("41화. 균열(1)", "/webtoon/detail.nhn?titleId=703854&no=41&weekday=fri", "식스틴");
//        downloadChapter("42화. 균열(2)", "/webtoon/detail.nhn?titleId=703854&no=42&weekday=fri", "식스틴");
//        downloadChapter("43화. 균열(3)", "/webtoon/detail.nhn?titleId=703854&no=43&weekday=fri", "식스틴");
//        downloadChapter("44화. 알고 싶은 것(1)", "/webtoon/detail.nhn?titleId=703854&no=44&weekday=fri", "식스틴");

        //SATURDAY
//        downloadChapter("18화", "/webtoon/detail.nhn?titleId=716163&no=18&weekday=sat", "늑대와빨간모자");
//        downloadChapter("19화", "/webtoon/detail.nhn?titleId=716163&no=19&weekday=sat", "늑대와빨간모자");
//        downloadChapter("20화", "/webtoon/detail.nhn?titleId=716163&no=20&weekday=sat", "늑대와빨간모자");
//        downloadChapter("21화", "/webtoon/detail.nhn?titleId=716163&no=21&weekday=sat", "늑대와빨간모자");
//        downloadChapter("22화", "/webtoon/detail.nhn?titleId=716163&no=22&weekday=sat", "늑대와빨간모자");
//        downloadChapter("23화", "/webtoon/detail.nhn?titleId=716163&no=23&weekday=sat", "늑대와빨간모자");
//        
//        downloadChapter("190화", "/webtoon/detail.nhn?titleId=622644&no=191&weekday=sat", "아메리카노엑소더스");
//        downloadChapter("191화", "/webtoon/detail.nhn?titleId=622644&no=192&weekday=sat", "아메리카노엑소더스");
//        downloadChapter("192화", "/webtoon/detail.nhn?titleId=622644&no=193&weekday=sat", "아메리카노엑소더스");
//        downloadChapter("193화", "/webtoon/detail.nhn?titleId=622644&no=194&weekday=sat", "아메리카노엑소더스");
//        downloadChapter("194화", "/webtoon/detail.nhn?titleId=622644&no=195&weekday=sat", "아메리카노엑소더스");
//        downloadChapter("195화", "/webtoon/detail.nhn?titleId=622644&no=196&weekday=sat", "아메리카노엑소더스");
//
//        downloadChapter("48화. 명이의 소년(3)", "/webtoon/detail.nhn?titleId=705328&no=48&weekday=sat", "환상적인소년");
//        downloadChapter("49화. 명이의 소년(4)", "/webtoon/detail.nhn?titleId=705328&no=49&weekday=sat", "환상적인소년");
//        downloadChapter("50화. 당신은 나의 태양", "/webtoon/detail.nhn?titleId=705328&no=50&weekday=sat", "환상적인소년");
//        downloadChapter("후기", "/webtoon/detail.nhn?titleId=705328&no=51&weekday=sat", "환상적인소년");
        
        //SUNDAY
    }

    private static void downloadChapter(String name, String link, String folder) {
        WebtoonOrigin.folder = folder;
        downloadChapter(name, link);
    }

    private static void downloadChapter(String name, String link) {
        Document doc = null;
        Connection con = null;

        link = urlBase + link;

        try {
            con = Jsoup.connect(link);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "unable to connect to url {0}", new Object[]{link});
        }

        try {
            doc = con.get();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Cannot get DOM from url {0}", new Object[]{link});
        }

        Elements lstImg = doc.getElementsByClass("wt_viewer");
        Elements imgs = lstImg.get(0).getElementsByTag("img");
        int i = 0;
        for (Element el : imgs) {
            String urlImg = el.attr("src");

            try {
                URL url = new URL(urlImg);

                HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
                httpcon.addRequestProperty("User-Agent", "Mozilla/4.0");

                InputStream in = new BufferedInputStream(httpcon.getInputStream());
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int n = 0;
                while (-1 != (n = in.read(buf))) {
                    out.write(buf, 0, n);
                }
                out.close();
                in.close();
                byte[] response = out.toByteArray();

                String folder = "/Users/joao/Documents/Webtoons/" + WebtoonOrigin.folder + "/";

                folder = folder + name + "/";
                File chapterFolder = new File(folder);

                if (!chapterFolder.exists()) {
                    System.out.println("creating directory: " + chapterFolder.getName());
                    try {
                        if (chapterFolder.mkdir()) {
                            folder = chapterFolder.getAbsolutePath().concat("/");
                            System.out.println("DIR created");
                        }
                    } catch (SecurityException se) {
                        folder = "/Users/joao/Documents/Webtoons/" + WebtoonOrigin.folder + "/";
                        logger.log(Level.SEVERE, se.getMessage());
                    }
                }

                FileOutputStream fos = new FileOutputStream(folder + (++i) + ".jpg");
                System.out.println("Image: " + folder + i + ".jpg");
                fos.write(response);
                fos.close();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Cannot save image from url {0} - " + e.getMessage(), new Object[]{urlImg});
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage());
            }

        }

    }

    //    private static boolean downloaded(String link) {
//        String[] itens = {
//            "1화.", "2화.", "3화.", "4화.", "12화.", "15화.", "16화.", "17화.", "18화.", "19화.",
//            "20화.", "22화.", "24화.", "25화.", "26화.", "27화.", "28화.", "29화.", "30화.", "31화.",
//            "32화.", "33화.", "35화.", "37화.", "38화.", "39화.", "43화.", "47화.", "49화.", "58화.",
//            "63화.", "64화.", "67화.", "68화.", "70화.", "71화.", "80화.", "84화.", "85화.", "88화.",
//            "90화.", "96화.", "97화.", "102화.", "112화.", "113화.", "118화.", "120화.", "121화.", "124화.",
//            "126화.", "127화.", "128화.", "129화.", "131화.", "132화.", "143화.", "144화.", "145화.", "<납량특집> 91화.",
//            "146화.", "142화.", "141화.", "140화.", "139화.", "138화.", "137화.", "136화.", "135화.", "134화.",
//            "133화.", "130화.", "125화.", "123화.", "122화.", "119화.", "117화.", "116화.", "115화.", "114화.", "111화.",
//            "110화.", "109화.", "108화.", "107화.", "106화.", "105화.",};
//
//        boolean baixado = false;
//
//        for (String i : itens) {
//            if (link.startsWith(i)) {
//                baixado = true;
//                break;
//            }
//        }
//
//        return baixado;
//    }
}
