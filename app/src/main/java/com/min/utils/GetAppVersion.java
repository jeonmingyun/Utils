package com.min.utils;

import android.content.Context;
import android.os.AsyncTask;

import org.jsoup.Jsoup;

// 호출 방법 - new GetAppVersion(this).execute(null, null, null);
public class GetAppVersion extends AsyncTask<Void, String, String> {
    private Context mContext;

    public GetAppVersion(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected String doInBackground(Void... voids) {

        String newVersion = null;
        try {
            newVersion = Jsoup.connect("https://play.google.com/store/apps/details?id=" + mContext.getPackageName() + "&hl=ko&gl=US")
                    .timeout(30000)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .get()
                    .select(".hAyfc .htlgb")
                    .get(7)
                    .ownText();
            if(isString(newVersion.replace(".", ""))) {
                return newVersion;
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    @Override
    protected void onPostExecute(String onlineVersion) {
        super.onPostExecute(onlineVersion);

        // 예시) pref에 저장하여 사용
        PreferenceManager.setString(mContext, PreferenceManager.PREF_KEY_APP_VERSION, onlineVersion);
    }

    public boolean isString(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}