package com.joao.imagefromurl;

import Util.Constantes;
import Util.Titles;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComicNaver {

    private static Logger logger = Logger.getLogger(ComicNaver.class.getName());

    public void all(Titles t, Integer startPage, Integer endPage) {
        HashMap<String, String> map = new LinkedHashMap<>();

        Connection con = null;
        Document doc = null;

        try {
            for (int p = startPage; p <= endPage; p++) {
                String url = Constantes.getLinksFromPage(t.getTitleId(), p);

                con = Jsoup.connect(url);
                doc = con.get();

                Elements viewList = doc.getElementsByClass("viewList");
                Elements trs = viewList.get(0).getElementsByClass("title");

                for (Element e : trs) {
                    String title = e.text();
                    String link = e.getElementsByTag("a").get(0).attr("href");

                    map.put(title, link);
                    logger.log(Level.INFO, "{\"title\": \"{"+t.getName()+"}\", \"link\": \"{"+link+"}\"}");
                }

                Thread.sleep(Constantes.TIMEOUT);
            }

            if (map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    downloadChapter(entry.getKey(), entry.getValue(), t);
                }
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to download Webtoon {0}. {1}", new Object[]{t.getName(), e});
        }
    }

    // TODO: implement
    public void byChapter() {

    }

    public void downloadChapter(String name, String link, Titles title) {
        Document doc = null;
        Connection con = null;

        link = Constantes.COMIC_NAVER + link;

        try {
            con = Jsoup.connect(link);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unable to connect to url {0}", new Object[]{link});
        }

        try {
            doc = con.get();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Cannot get DOM from url {0}", new Object[]{link});
        }

        Elements lstImg = doc.getElementsByClass("wt_viewer");
        Elements imgs = lstImg.get(0).getElementsByTag("img");

        AtomicInteger ordinal = new AtomicInteger(0);
        imgs.stream().forEach(img -> {
            String urlImg = img.attr("src");

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

                String folder = Constantes.DIRECTORY + title.getFolder() + "/";

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
                        folder = Constantes.DIRECTORY + title.getFolder() + "/";
                        logger.log(Level.SEVERE, se.getMessage());
                    }
                }

                ordinal.getAndIncrement();
                FileOutputStream fos = new FileOutputStream(folder + ordinal + ".jpg");
                System.out.println("Image: " + folder + ordinal + ".jpg");
                fos.write(response);
                fos.close();

            } catch (Exception e){
                logger.log(Level.SEVERE, "Cannot save image from url {0}. {1} ", new Object[]{urlImg, e.getMessage()});
            }

            try {
                Thread.sleep(Constantes.TIMEOUT);
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        });
    }

    public boolean isDownloaded(String search) {
        return false;
    }
}
