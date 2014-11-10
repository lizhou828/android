package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-7
 * Time: 上午10:55
 * To change this template use File | Settings | File Templates.
 */
public class RatingBarActivity extends Activity implements RatingBar.OnRatingBarChangeListener{
    private TextView ratingBarTextView;
    private RatingBar indicatorRatingBar;
    private RatingBar smallRatingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.rating_bar);

        ratingBarTextView = (TextView)findViewById(R.id.ratingbarTextView);
        indicatorRatingBar = (RatingBar)findViewById(R.id.indicator_ratingbar);
        smallRatingBar = (RatingBar)findViewById(R.id.small_rating_bar);

        ((RatingBar)findViewById(R.id.ratingbar1)).setOnRatingBarChangeListener(this);
        ((RatingBar)findViewById(R.id.ratingbar2)).setOnRatingBarChangeListener(this);
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        final int numStars = ratingBar.getNumStars();
        ratingBarTextView.setText("受欢迎程度"+rating+"/"+numStars);

        if(indicatorRatingBar.getNumStars() != numStars){
            indicatorRatingBar.setNumStars(numStars);
            smallRatingBar.setNumStars(numStars);
        }

        if(indicatorRatingBar.getRating() != rating){
            indicatorRatingBar.setRating(rating);
            smallRatingBar.setRating(rating);
        }
        float ratingBarStepSize = ratingBar.getStepSize();
        if(indicatorRatingBar.getStepSize() != ratingBarStepSize){
            indicatorRatingBar.setStepSize( ratingBarStepSize );
            smallRatingBar.setStepSize(ratingBarStepSize);
        }

    }
}
