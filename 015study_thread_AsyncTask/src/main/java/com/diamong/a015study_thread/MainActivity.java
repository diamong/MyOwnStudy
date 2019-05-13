package com.diamong.a015study_thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void OnStart(View view) {
        startASyncCalculation();
    }

    private void startASyncCalculation() {
        ASyncCalculatorText aSyncCalculatorText = new ASyncCalculatorText();
        aSyncCalculatorText.execute(1, Integer.MAX_VALUE);
    }

    class ASyncCalculatorText extends AsyncTask<Integer, Integer, Integer> {

        /**
         * Async Thread Method
         */
        @Override
        protected Integer doInBackground(Integer... integers) {
            int number = integers[0];
            int count = integers[1];
            int result = 0;

            int percentUnit = count / 100;

            for (int i = 0; i < count; i++) {
                result += number;

                if (result % percentUnit ==0 ){
                    publishProgress(result/percentUnit);
                }
            }
            return result;
        }

        /**
         * UI Thread
         */
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            textView.setText("Result :" + integer);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView.setText(values[0]+" %");

        }
    }
}
