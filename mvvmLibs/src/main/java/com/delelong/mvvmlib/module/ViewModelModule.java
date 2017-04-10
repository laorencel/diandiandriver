package com.delelong.mvvmlib.module;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.delelong.mvvmlib.bean.ErrorBean;
import com.delelong.mvvmlib.databinding.ActivityMvvmBinding;
import com.delelong.mvvmlib.databinding.ContentMvvmBinding;
import com.delelong.mvvmlib.databinding.DefaultProgressBinding;
import com.delelong.mvvmlib.databinding.ErrorBinding;
import com.delelong.mvvmlib.databinding.TitleMvvmBinding;
import com.delelong.mvvmlib.model.RetrofitModel;
import com.delelong.mvvmlib.model.imodel.IRetrofitModel;
import com.delelong.mvvmlib.model.imodel.IViewModel;
import com.delelong.mvvmlib.scope.ViewModelScope;
import com.delelong.mvvmlib.viewmodel.ViewModel;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module
public class ViewModelModule {

    private ActivityMvvmBinding activityMvvmBinding;
    private Context context;
    private IViewModel viewModel;

    public ViewModelModule(ViewModel viewModel, Context context, ActivityMvvmBinding activityMvvmBinding){
        this.viewModel = viewModel;
        this.context = context;
        this.activityMvvmBinding = activityMvvmBinding;
    }

    @ViewModelScope
    @Provides
    public ActivityMvvmBinding providesActivityMvvmBinding(){
        return activityMvvmBinding;
    }

    @ViewModelScope
    @Provides
    TitleMvvmBinding providesTitleMvvmBinding(){
        return activityMvvmBinding.titleMvvm;
    }

    @ViewModelScope
    @Provides
    public ContentMvvmBinding providesContentMvvmBinding(){
        return activityMvvmBinding.contentMvvm;
    }

    @Named("titleBinding")
    @ViewModelScope
    @Provides
    ViewDataBinding providesToolbarBinding(TitleMvvmBinding titleMvvmBinding){
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);

        ViewDataBinding toolbarBinding = viewModel.onCreateToolbarBinding(
                LayoutInflater.from(context),titleMvvmBinding.contentTitle);
        if (toolbarBinding!=null){
            titleMvvmBinding.contentTitle
                    .addView(toolbarBinding.getRoot(),lp);
        }
        return toolbarBinding;
    }

    @Named("childBinding")
    @ViewModelScope
    @Provides
    ViewDataBinding providesChildBinding(ContentMvvmBinding contentMvvmBinding){
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);

        ViewDataBinding childBinding = viewModel.onCreateChildBinding(LayoutInflater.from(context)
                ,contentMvvmBinding.mvvmFrameLayout);
        if (childBinding != null ){
            contentMvvmBinding.mvvmFrameLayout
                    .addView(childBinding.getRoot(),lp);
        }
        return childBinding;
    }

    @ViewModelScope
    @Provides
    public ErrorBinding providesErrorBinding(ContentMvvmBinding contentMvvmBinding){
        return contentMvvmBinding.mvvmError;
    }

    @ViewModelScope
    @Provides
    public DefaultProgressBinding providesProgressBinding(ContentMvvmBinding contentMvvmBinding){
        return contentMvvmBinding.mvvmDefaultProgress;
    }

    @ViewModelScope
    @Provides
    public ErrorBean providesError(){
        return new ErrorBean();
    }

    @ViewModelScope
    @Provides
    public IRetrofitModel providesRetrofitModel(){
        return new RetrofitModel(viewModel);
    }

    @ViewModelScope
    @Provides
    public ProgressDialog providesProgressDialog(){
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setTitle("加载中");
        return dialog;
    }
}
