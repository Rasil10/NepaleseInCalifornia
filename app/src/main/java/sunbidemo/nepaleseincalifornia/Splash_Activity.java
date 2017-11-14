package sunbidemo.nepaleseincalifornia;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash_Activity extends Activity {
    private static final long DELAY = 3000;
    private boolean scheduled = false;
    private Timer splashTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashTimer = new Timer();
        splashTimer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                Intent myIntent=new Intent(Splash_Activity.this, SignUpActivity.class);
                ActivityOptions options =
                        ActivityOptions.makeCustomAnimation(Splash_Activity.this, R.anim.anim_one, R.anim.anim_two);
                Splash_Activity.this.startActivity(myIntent, options.toBundle());
                Splash_Activity.this.finish();
                startActivity(myIntent);
            }
        }, DELAY);
        scheduled = true;
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if (scheduled)
            splashTimer.cancel();
        splashTimer.purge();
    }
}
