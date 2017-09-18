package net.derohimat.sgpsi.data.sources.remote;

import android.content.Context;

import net.derohimat.sgpsi.BuildConfig;
import net.derohimat.sgpsi.constants.Constants;
import net.derohimat.sgpsi.data.models.PsiDao;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

public interface ApiService {

    @GET("psi")
    Observable<PsiDao> getPsi();

    class Factory {

        public static ApiService create(Context context) {

            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.readTimeout(30, TimeUnit.SECONDS);
            builder.connectTimeout(20, TimeUnit.SECONDS);
            builder.writeTimeout(60, TimeUnit.SECONDS);

            builder.addNetworkInterceptor(chain -> {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("api-key", Constants.API_KEY)
                        .build();
                return chain.proceed(request);
            });

            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                builder.addInterceptor(interceptor);
            }

            int cacheSize = 10 * 1024 * 1024; // 10 MiB
            Cache cache = new Cache(context.getCacheDir(), cacheSize);
            builder.cache(cache);

            OkHttpClient client = builder.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_API_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            return retrofit.create(ApiService.class);
        }
    }
}