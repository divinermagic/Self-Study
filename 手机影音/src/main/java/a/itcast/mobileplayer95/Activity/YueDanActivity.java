package a.itcast.mobileplayer95.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import a.itcast.mobileplayer95.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 作者：Administrator on 2017/9/27 05:13
 * 邮箱：bonian1852@163.com
 */

public class YueDanActivity extends AppCompatActivity {

    @Bind(R.id.videoPlayer)
    JCVideoPlayerStandard videoPlayer;
    @Bind(R.id.iv_yuedan_describe)
    ImageView ivYuedanDescribe;
    @Bind(R.id.iv_yuedan_comment)
    ImageView ivYuedanComment;
    @Bind(R.id.iv_yuedan_list)
    ImageView ivYuedanList;
    @Bind(R.id.fl_content)
    FrameLayout flContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuedan);
        ButterKnife.bind(this);
    }
}
