package com.ui.callback;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

// ProgressBar with a callback activity
public class CallBackActivity extends Activity implements MyAsyncTask.DoSomething {

    ProgressBar myProgressBar;
    MyAsyncTask myAsyncTask;
    int myProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_back);

        myProgressBar = (ProgressBar) findViewById(R.id.myprogressbar);
        myProgress = 0;
        myAsyncTask = new MyAsyncTask(this, 100);
        myAsyncTask.execute();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.call_back, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void doInBackground(int progress) {
        myProgressBar.setProgress(progress);
    }

    @Override
    public void doPostExecute() {
        Toast.makeText(CallBackActivity.this,
                "Finish", Toast.LENGTH_LONG).show();
    }
}
