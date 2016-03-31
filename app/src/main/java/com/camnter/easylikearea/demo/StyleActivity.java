package com.camnter.easylikearea.demo;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.camnter.easylikearea.EasyLikeArea;
import com.camnter.easylikearea.demo.utils.GlideUtils;
import com.camnter.easylikearea.widget.EasyLikeImageView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Description：StyleActivity
 * Created by：CaMnter
 * Time：2016-03-31 13:40
 */
public class StyleActivity extends AppCompatActivity {

    private EasyLikeArea circleEla;
    private EasyLikeArea roundEla;
    private EasyLikeArea normalEla;

    private DisplayMetrics mMetrics;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;


    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_style);
        this.initViews();
        this.initData();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    private void initViews() {
        this.circleEla = (EasyLikeArea) this.findViewById(R.id.circle_ela);
        this.roundEla = (EasyLikeArea) this.findViewById(R.id.round_ela);
        this.normalEla = (EasyLikeArea) this.findViewById(R.id.normal_ela);
    }


    private void initData() {
        this.mMetrics = this.getResources().getDisplayMetrics();
        this.initLikeArea();
    }


    private void initLikeArea() {
        this.circleEla.setOmitView(this.getOmitView(Constant.STYLE_AVATARS.length));
        this.roundEla.setOmitView(this.getOmitView(Constant.STYLE_AVATARS.length));
        this.normalEla.setOmitView(this.getOmitView(Constant.STYLE_AVATARS.length));
        for (int idRes : Constant.STYLE_AVATARS) {
            EasyLikeImageView circleIv = this.createEasyLikeImageView(EasyLikeImageView.CIRCLE);
            EasyLikeImageView roundIv = this.createEasyLikeImageView(EasyLikeImageView.ROUND);
            ImageView normalIv = new ImageView(this);
            normalIv.setLayoutParams(new ViewGroup.LayoutParams(this.dp2px(36), this.dp2px(36)));
            GlideUtils.displayNative(circleIv, idRes);
            GlideUtils.displayNative(roundIv, idRes);
            GlideUtils.displayNative(normalIv, idRes);
            this.circleEla.addView(circleIv);
            this.roundEla.addView(roundIv);
            this.normalEla.addView(normalIv);
        }
    }


    private EasyLikeImageView createEasyLikeImageView(@EasyLikeImageView.ImageType int imageType) {
        EasyLikeImageView iv = new EasyLikeImageView(this);
        iv.setImageType(imageType);
        iv.setLayoutParams(new ViewGroup.LayoutParams(this.dp2px(36), this.dp2px(36)));
        return iv;
    }


    public View getOmitView(int count) {
        View omitView = LayoutInflater.from(this).inflate(R.layout.view_omit_style_topic, null);
        TextView omitTv = (TextView) omitView.findViewById(R.id.topic_omit_tv);
        omitTv.setText(this.getString(this.getOmitVieStringFormatId(), count));
        return omitView;
    }


    public int getOmitVieStringFormatId() {
        return R.string.view_omit_style_topic_content;
    }


    /**
     * Dp to px
     *
     * @param dp dp
     * @return px
     */
    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, this.mMetrics);
    }


    @Override public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient.connect();
        Action viewAction = Action.newAction(Action.TYPE_VIEW, // TODO: choose an action type.
                "Style Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.camnter.easylikearea.demo/http/host/path"));
        AppIndex.AppIndexApi.start(mClient, viewAction);
    }


    @Override public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(Action.TYPE_VIEW, // TODO: choose an action type.
                "Style Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.camnter.easylikearea.demo/http/host/path"));
        AppIndex.AppIndexApi.end(mClient, viewAction);
        mClient.disconnect();
    }
}