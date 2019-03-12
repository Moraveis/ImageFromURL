package com.joao.imagefromurl;

import Models.Webtoons;
import Util.Constantes;
import Util.Titles;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComicNaver implements Webtoons {

    private static Logger logger = Logger.getLogger(ComicNaver.class.getName());

    @Override
    public void all(Titles t, Integer startPage, Integer endPage) {
        Constantes constantes = new Constantes();

        HashMap<String, String> map = new LinkedHashMap<>();

        Connection con = null;
        Document doc = null;

        try {
            for (int p = startPage; p <= endPage; p++) {
                String url = constantes.getLinksFromPage(t.getTitleId(), p);

                con = Jsoup.connect(url);
                doc = con.get();

                Elements viewList = doc.getElementsByClass("viewList");
                Elements trs = viewList.get(0).getElementsByClass("title");

                for (Element e : trs) {
                    String title = e.text();
                    String link = e.getElementsByTag("a").get(0).attr("href");

                    map.put(title, link);
                    logger.log(Level.INFO, "{\"title\": \"{0}\", \"link\": \"{1}\"}", new Object[]{t.getName(), url});
                }

                Thread.sleep(constantes.getTimeOut());
            }

            if (map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    downloadChapter(entry.getKey(), entry.getValue(), t.getTitleId());
                }
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to download Webtoon {0}. {1}", new Object[]{t.getName(), e});
        }
    }

    @Override
    public void byChapter() {

    }

    @Override
    public void downloadChapter(String name, String folder, Integer titleId) {

    }

    @Override
    public boolean isDownloaded(String search) {
        return false;
    }
}
