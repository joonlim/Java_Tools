/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 *
 * @author Joon
 */
public class WebTools {

    /**
     * The WebTools.saveHtmlFile() method accepts two String parameters. The
     * first String is the URL of the website you wish to get the html file
     * from. The second String is the name of the output file you wish to create
     * that will contain the html document.
     *
     * urlString should be in the format of
     * "http://en.wikipedia.org/wiki/2014%E2%80%9315_NBA_season"
     *
     * outputFileName should be in the format of "<file-name>.html"
     *
     * @param urlString
     * @param outputFileName
     */
    public static void saveHtmlFile(String urlString, String outputFileName) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;

        try {
            url = new URL(urlString);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));
            PrintWriter writer = new PrintWriter(outputFileName, "UTF-8");

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

    /**
     * The WebTools.saveImage() method accepts two String parameters. The first
     * String is the URL of the image you wish to download. The second String is
     * the name of the output file you wish to create that will contain the
     * image file.
     *
     * urlString should be in the format of "http://i.imgur.com/9CtcIIk.jpg"
     *
     * outputFileName should be in the format of "<file-name>.jpg" can also be
     * gif or png
     *
     * @param imageURL
     * @param outputFileName
     * @throws IOException
     */
    public static void saveImage(String imageURL, String outputFileName) throws IOException {
        URL url = new URL(imageURL);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(outputFileName);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();

    }
    
    public static void main(String[] args) throws IOException {
                saveImage("https://i.imgur.com/J8sK1yp.gif", ".gif");
    }
}
