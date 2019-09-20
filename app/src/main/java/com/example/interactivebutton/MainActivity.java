package com.example.interactivebutton;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GestureDetectorCompat; 

import android.view.GestureDetector; // this one too
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;// line 12 and from line 16-19 are the classes or libraries or packages whatever u call them we r going to need them
import android.widget.TextView; // in order to use their methods
import android.view.MotionEvent;
import android.view.GestureDetector;


// let's implements these classes
public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    
    private TextView TextLabel;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // reference to the TextLabel
        TextLabel = (TextView)findViewById(R.id.TextLabel);
        this.gestureDetector = new GestureDetector(this,this);
        gestureDetector.setOnDoubleTapListener(this); //objects


        // Click listener
        Button BuckysButton = (Button)findViewById(R.id.BuckysButton);
        BuckysButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView TextLabel = (TextView)findViewById(R.id.TextLabel);
                        TextLabel.setText("Good Job Hoss!");
                    }
                }
        );

        // Long click listener
        BuckysButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        TextView TextLabel = (TextView)findViewById(R.id.TextLabel);
                        TextLabel.setText("OOps you pressemd me too long"); //make sure u spell it wrong. just kidding
                        return true;
                    }
                }
        );

    }
//////// GESTURE START ////////
               // here all the methods, i set them return true if we returned false then the methods will called but won't be handeled
    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        TextLabel.setText("This is a single TAP ");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        TextLabel.setText("onDoubleTap Detected");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        TextLabel.setText("u just double tapped me");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        TextLabel.setText("u pressed me down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        TextLabel.setText("SingleTapUp Detected");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        TextLabel.setText("u r scrolling me now");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        TextLabel.setText("u flinging me now");
        return true;
    }
    //////// END GESTURES ////////////

// this is the last methods of them all, the reason we need this bcoz we want to detect the touhes on screen for our app
                // here what i want, this will be called called when user touches and will detect the gestures
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
