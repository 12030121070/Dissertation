package com.sj.noticeboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;

import com.sj.groups.annc.Announcements;
import com.sj.groups.annc.FetchAnncDataListener;

public class FetchNotices extends AsyncTask<String, Void, String>{
	
    private final FetchNoticesListener listener;
    private String msg;
    Context c;
    
    public FetchNotices(FetchNoticesListener listener,Context con) {
        this.listener = listener;
        c=con;
    }
    
    @Override
    protected String doInBackground(String... params) {
        if(params == null) return null;
        
        // get url from params
        String url = params[0];
        
        try {
            // create http connection
            HttpClient client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            
            // connect
            HttpResponse response = client.execute(httpget);
            
            // get response
            HttpEntity entity = response.getEntity();
            
            if(entity == null) {
                msg = "No response from server";
                return null;        
            }
         
            // get response content and convert it to json string
            InputStream is = entity.getContent();
            return streamToString(is);
        }
        catch(IOException e){
            msg = "No Network Connection";
        }
        
        return null;
    }
    
    @Override
    protected void onPostExecute(String sJson) {
        if(sJson == null) {
            if(listener != null) listener.onFetchFailure(msg);
            return;
        }        
        
        try {
            // convert json string to json array
            JSONArray aJson = new JSONArray(sJson);
            // create apps list
            List<Notices> apps = new ArrayList<Notices>();
            
            for(int i=0; i<aJson.length(); i++) {
                JSONObject json = aJson.getJSONObject(i);
                
                Notices app = new Notices();
                app.setNid(json.getInt("n_id"));
                app.setNtitle(json.getString("n_title"));
                app.setNpart1(json.getString("n_part1"));
                app.setNpart1(json.getString("n_part2"));
                app.setNpart1(json.getString("n_part3"));
                app.setNpart1(json.getString("n_part4"));
                app.setSdate(json.getString("start_date"));
                app.setEdate(json.getString("end_date"));
                app.setAid(json.getInt("author"));
                
                // add the app to apps list
                apps.add(app);
            }
            
            //notify the activity that fetch data has been complete
            if(listener != null) listener.onFetchComplete(apps);
        } catch (JSONException e) {
            msg = "Invalid response";
            if(listener != null) listener.onFetchFailure(msg);
            return;
        }        
    }
    
    /**
     * This function will convert response stream into json string
     * @param is respons string
     * @return json string
     * @throws IOException
     */
    public String streamToString(final InputStream is) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder(); 
        String line = null;
        
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } 
        catch (IOException e) {
            throw e;
        } 
        finally {           
            try {
                is.close();
            } 
            catch (IOException e) {
                throw e;
            }
        }
        
        return sb.toString();
    }
}