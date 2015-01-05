/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The HtmlDownloader.saveHtmlFile() method accepts two String parameters. The
 * first String is the URL of the website you wish to get the html file from.
 * The second String is the name of the output file you wish to create that will
 * contain the html document.
 *
 * urlString should be in the format of
 * "http://en.wikipedia.org/wiki/2014%E2%80%9315_NBA_season"
 *
 * outputFileName should be in the format of "<file-name>.html"
 *
 *
 * @author Joon
 */
public class HtmlDownloader {

    public static void saveHtmlFile(String urlString, String outputFileName) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;

        try {
            url = new URL(urlString);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));
            PrintWriter writer = new PrintWriter(outputFileName + ".html", "UTF-8");

            while ((line = br.readLine()) != null) {
                writer.println(line);
//                System.out.println(line);
            }
            writer.close();

        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();

                }
            } catch (IOException ioe) {
                // nothing to see here 
            }
        }

    }

}
