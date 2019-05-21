package com.diamong.a022study_spinner;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Utils {
    public static String[] readTextFromAssets(Activity activity, String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(activity.getAssets().open(fileName)));

            // do reading, usually loop until end of file reading
            String mLine;
            String[] splited = null;
            while ((mLine = reader.readLine()) != null) {
                splited = mLine.split("\\s+");
            }
            return splited;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
