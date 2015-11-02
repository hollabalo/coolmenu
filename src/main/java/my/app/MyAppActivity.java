package my.app;

import android.app.Activity;
import android.os.Bundle;

public class MyAppActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // ImageView iv = new ImageView(this);
        // iv.setImageResource(R.drawable.mypicture);
        setContentView(new MyViewGroup(this));
    }
}
