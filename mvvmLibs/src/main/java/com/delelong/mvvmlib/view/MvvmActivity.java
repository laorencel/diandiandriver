package com.delelong.mvvmlib.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import com.delelong.mvvmlib.component.DaggerMvvmActivityComponent;
import com.delelong.mvvmlib.module.BindViewModelModule;
import com.delelong.mvvmlib.view.iview.BindViewModel;
import com.delelong.mvvmlib.viewmodel.ViewModel;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/4/9.
 */

public abstract class MvvmActivity extends BaseActivity implements BindViewModel{

    @Inject
    ViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        DaggerMvvmActivityComponent
                .builder()
                .bindViewModelModule(new BindViewModelModule(this))
                .build()
                .inject(this);

        init();
    }

    @Override
    public void init() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
