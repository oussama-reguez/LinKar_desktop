package com.linkar.tn.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Oussama Reguez
 */
public  class LinkarUploader {
   public static  String   upload(String path){
        String url=null;
       FileInputStream fis = null;
		try {
                    File f = new File(path);
			fis = new FileInputStream(f);
			DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
			
			// server back-end URL
			HttpPost httppost = new HttpPost("http://localhost/upload/upload.php");
			MultipartEntity entity = new MultipartEntity();
			// set the file input stream and file name as arguments
                        System.out.println(f.getName());
                        
			entity.addPart("fileToUpload", new InputStreamBody(fis, f.getName()));
			httppost.setEntity(entity);
			// execute the request
			HttpResponse response = httpclient.execute(httppost);
			
			int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity responseEntity = response.getEntity();
			String responseString = EntityUtils.toString(responseEntity, "UTF-8");
                        System.out.println(responseString);
			if(statusCode==200){
                            if(!responseString.equals("error")){
                                return responseString;
                            }
                        }
			
			
		} catch (ClientProtocolException e) {
			System.err.println("Unable to make connection");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unable to read file");
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) fis.close();
			} catch (IOException e) {}
                        
		}
                return null;
    }
    
}
