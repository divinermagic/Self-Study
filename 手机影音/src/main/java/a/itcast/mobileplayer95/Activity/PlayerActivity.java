package a.itcast.mobileplayer95.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import a.itcast.mobileplayer95.R;
import a.itcast.mobileplayer95.fragment.playerpage.CommentFragment;
import a.itcast.mobileplayer95.fragment.playerpage.DescriptionFragment;
import a.itcast.mobileplayer95.fragment.playerpage.RelativeFragment;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class PlayerActivity extends AppCompatActivity {

    @Bind(R.id.jiecaoplayer)
    JCVideoPlayerStandard jiecaoplayer;
    @Bind(R.id.mv_describe)
    ImageView mvDescribe;
    @Bind(R.id.mv_comment)
    ImageView mvComment;
    @Bind(R.id.mv_relative)
    ImageView mvRelative;
    @Bind(R.id.fl_content)
    FrameLayout flContent;

    private SparseArray<Fragment> sparseArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);
        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");

        // TODO: 2017/9/27 初始化按钮 让视频 点击进去直接播放视频
        jiecaoplayer.setUp(url, title);
        
        // TODO: 2017/9/27 模拟点击按钮 [perform]:执行
        jiecaoplayer.startButton.performClick();

        // TODO: 2017/9/27 初始化 Fragment 缓存 只在初始化时创建了一次 并放到了缓存里面了
        sparseArray = new SparseArray<>();
        sparseArray.append(R.id.mv_describe,new DescriptionFragment());
        sparseArray.append(R.id.mv_comment,new CommentFragment());
        sparseArray.append(R.id.mv_relative,new RelativeFragment());

        // TODO: 2017/9/27 初始化界面时 默认选中MV描述界面
        mvDescribe.performClick();

    }

    @Override
    // TODO: 2017/9/23 JCVideoPlayerStandard.onPause 视频不可见时,就把资源释放掉
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @OnClick({R.id.mv_describe, R.id.mv_comment, R.id.mv_relative})
    public void onViewClicked(View view) {
        updataButtonPic(view.getId());
        showFragment(sparseArray.get(view.getId()));
//        switch (view.getId()) {
//            case R.id.mv_describe:
//                showFragment(new DescriptionFragment());
//                break;
//            case R.id.mv_comment:
//                showFragment(new CommentFragment());
//                break;
//            case R.id.mv_relative:
//                showFragment(new RelativeFragment());
//                break;
//        }
    }

    // TODO: 2017/9/27 将参数里的 Fragment 显示出来
    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fl_content,fragment);

        transaction.commit();
    }

    // TODO: 2017/9/27 根据选中的ID来更新图片
    private void updataButtonPic(int viewId) {
        //更新简介
        if (viewId == R.id.mv_describe){
            mvDescribe.setBackgroundResource(R.drawable.player_mv_p);
        }else {
            mvDescribe.setBackgroundResource(R.drawable.player_mv);
        }

        //更新评论
        if (viewId == R.id.mv_comment){
            mvComment.setBackgroundResource(R.drawable.player_comment_p);
        }else {
            mvComment.setBackgroundResource(R.drawable.player_comment);
        }

        //更新相关
        if (viewId == R.id.mv_relative){
            mvRelative.setBackgroundResource(R.drawable.player_relative_mv_p);
        }else {
            mvRelative.setBackgroundResource(R.drawable.player_relative_mv);
        }


    }
}
