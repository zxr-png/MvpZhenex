package com.example.mvpzhenex.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetortInterface implements NewWorkInterFaces{
    private static RetortInterface retortInterface;
    private ApiService apiService;

    public static RetortInterface getRetortInterface() {
        if (retortInterface==null){
            synchronized (RetortInterface.class){
                if (retortInterface==null){
                    retortInterface=new RetortInterface ();
                }
            }
        }
        return retortInterface;
    }

    public RetortInterface(){
        Retrofit build = new Retrofit.Builder ()
                .baseUrl (Url.BaseUrl)
                .addCallAdapterFactory (RxJava2CallAdapterFactory.create ())
                .build ();
        apiService=build.create (ApiService.class);

    }

    @Override
    public <T> void get(String url, CallBackList<T> callBackList) {
        apiService.get (url).subscribeOn (Schedulers.io ())
                .observeOn (AndroidSchedulers.mainThread ())
                .subscribe (new Observer<ResponseBody> () {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string ();
                            Type[] genericInterfaces = callBackList.getClass ().getGenericInterfaces ();
                            ParameterizedType anInterface = (ParameterizedType) genericInterfaces[0];
                            Type[] arguments = anInterface.getActualTypeArguments ();
                            Type types=arguments[0];
                            T o = new Gson ().fromJson (string, types);
                            callBackList.onSecced (o);
                        } catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
