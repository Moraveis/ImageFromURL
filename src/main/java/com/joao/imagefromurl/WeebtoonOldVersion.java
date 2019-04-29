package com.joao.imagefromurl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WeebtoonOldVersion {

    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static String urlBase = "https://comic.naver.com";
    private static String folder = "general";

    public static void main(String[] args) {

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

    private static void downloadChapter(String name, String link, String folder) {
        WeebtoonOldVersion.folder = folder;
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

                String folder = "/Users/joao/Documents/Webtoons/" + WeebtoonOldVersion.folder + "/";

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
                        folder = "/Users/joao/Documents/Webtoons/" + WeebtoonOldVersion.folder + "/";
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
