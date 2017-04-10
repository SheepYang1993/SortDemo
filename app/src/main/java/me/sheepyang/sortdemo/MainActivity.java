package me.sheepyang.sortdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.sheepyang.sortdemo.widget.SortView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.sort_view)
    SortView mSortView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    @OnClick({R.id.btn_stop, R.id.btn_restart, R.id.btn_bubble})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_stop:
                mSortView.stop();
                break;
            case R.id.btn_restart:
                mSortView.restart();
                break;
            case R.id.btn_bubble:
                ToastUtils.showShortToast("正在进行冒泡排序...");
                mSortView.bubbleSort();
                break;
            default:
                break;
        }
    }
}
