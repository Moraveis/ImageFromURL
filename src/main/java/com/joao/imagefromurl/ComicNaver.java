package com.joao.imagefromurl;

import Models.Webtoons;
import Util.Constantes;
import Util.Titles;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComicNaver implements Webtoons {

    private static Logger logger = Logger.getLogger(ComicNaver.class.getName());
    private Constantes constantes = new Constantes();

    @Override
    public void all(Titles t, Integer startPage, Integer endPage) {
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
                    logger.log(Level.INFO, "{\"title\": \"{"+t.getName()+"}\", \"link\": \"{"+link+"}\"}");
                }

                Thread.sleep(constantes.getTimeOut());
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

    @Override
    public void byChapter() {

    }

    @Override
    public void downloadChapter(String name, String link, Titles title) {
        Document doc = null;
        Connection con = null;

        link = constantes.getComicNaver() + link;

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

        imgs.stream().forEach(img -> {
            String urlImg = img.attr("src");
            int i = 0;

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

                String folder = constantes.getDirectory() + title.getFolder() + "/";

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
                        folder = constantes.getDirectory() + title.getFolder() + "/";
                        logger.log(Level.SEVERE, se.getMessage());
                    }
                }

                FileOutputStream fos = new FileOutputStream(folder + (++i) + ".jpg");
                System.out.println("Image: " + folder + i + ".jpg");
                fos.write(response);
                fos.close();

            } catch (Exception e){
                logger.log(Level.SEVERE, "Cannot save image from url {0}. {1} ", new Object[]{urlImg, e.getMessage()});
            }

            try {
                Thread.sleep(constantes.getTimeOut());
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        });
    }

    @Override
    public boolean isDownloaded(String search) {
        return false;
    }
}
