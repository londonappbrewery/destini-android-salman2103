package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyTextView;
    Button ans1Button;
    Button ans2Button;
    int mStoryIndex = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null){
            mStoryIndex = savedInstanceState.getInt("IndexKey");
        }else {
            mStoryIndex = 1;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = (TextView)findViewById(R.id.storyTextView);
        ans1Button = (Button)findViewById(R.id.buttonTop);
        ans2Button = (Button)findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        ans1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mStoryIndex == 1 || mStoryIndex == 2){
                    storyTextView.setText(R.string.T3_Story);
                    ans1Button.setText(R.string.T3_Ans1);
                    ans2Button.setText(R.string.T3_Ans2);
                    mStoryIndex = 3;
                }else if (mStoryIndex == 3){
                    storyTextView.setText(R.string.T6_End);
                    ans1Button.setVisibility(View.GONE);
                    ans2Button.setVisibility(View.GONE);
                }else mStoryIndex = 1;
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        ans2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex == 1){
                    storyTextView.setText(R.string.T2_Story);
                    ans1Button.setText(R.string.T2_Ans1);
                    ans2Button.setText(R.string.T2_Ans2);
                    mStoryIndex = 2;
                }else if (mStoryIndex == 2){
                    storyTextView.setText(R.string.T4_End);
                    ans1Button.setVisibility(View.GONE);
                    ans2Button.setVisibility(View.GONE);
                }else if(mStoryIndex == 3) {
                    storyTextView.setText(R.string.T5_End);
                    ans1Button.setVisibility(View.GONE);
                    ans2Button.setVisibility(View.GONE);
                }else mStoryIndex = 1;
            }
        });


    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("IndexKey",mStoryIndex);
    }


}
