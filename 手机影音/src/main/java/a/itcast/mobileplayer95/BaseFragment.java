package a.itcast.mobileplayer95;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkfuns.logutils.LogUtils;

import butterknife.ButterKnife;

/**
 * 作者：Magic on 2017/9/7 02:34
 * 邮箱：bonian1852@163.com
 */

public abstract class BaseFragment extends Fragment {

    // TODO: 2017/9/7  rootView 因为所有的Fragment都得处理这个rootView
    protected View rootView;

    // TODO: 2017/9/21 把从第一个条目[起始位置]  10个为一页 改成个常量

    protected int offset; //[起始位置]

    protected static final int SIZE = 10; //[10个为一页]

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        a.itcast.mobileplayer95.utils.LogUtils.e(getClass(),"BaseFragment.onCreateView,rootView:"+rootView);

        // TODO: 2017/9/6 复用rootView rootView == null的情况下 再新建rootview否则直接复用rootView,可以节约内存
        if (rootView == null){
            rootView = inflater.inflate(getLayoutId(),null);
        }
        ButterKnife.bind(this,rootView);
        initView();
        return rootView;
    }

    // TODO: 2017/9/7 protected abstract int getLayoutId(); 返回当前Fragment使用的布局的ID.
    protected abstract int getLayoutId();

    // TODO: 2017/9/7 protected abstract void initView(); 处理界面初始化.
    protected abstract void initView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
