package com.delelong.mvvmlib.module;

import com.delelong.mvvmlib.viewmodel.iviewmodel.IRetrofitViewModel;

import dagger.Module;

/**
 * Created by Administrator on 2017/4/8.
 */

@Module
public class RetrofitModelModule {

    IRetrofitViewModel viewModel;

    public RetrofitModelModule(IRetrofitViewModel viewModel) {
        this.viewModel = viewModel;
    }

//    @RetrofitScope
//    @Provides
//    ApiServer providesApiServer(Retrofit retrofit) {
//        return viewModel.setApiService(retrofit);
//    }
//
//    @RetrofitScope
//    @Provides
//    Observable providesObservable(ApiServer apiServer) {
//        return viewModel.getApiData(apiServer);
//    }
}
