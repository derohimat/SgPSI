package net.derohimat.sgpsi;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.VisibleForTesting;

import net.derohimat.sgpsi.di.component.ApplicationComponent;
import net.derohimat.sgpsi.di.component.DaggerApplicationComponent;
import net.derohimat.sgpsi.di.module.ApplicationModule;

import io.realm.Realm;
import rx.Scheduler;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class BaseApplication extends Application {

    private Scheduler mScheduler;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        boolean isDebuggable = (0 != (getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE));

        if (isDebuggable) {
            Timber.plant(new Timber.DebugTree());
        }

        Realm.init(this);

        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
    }

    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @VisibleForTesting
    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.mApplicationComponent = applicationComponent;
    }

    public Scheduler getSubscribeScheduler() {
        if (mScheduler == null) {
            mScheduler = Schedulers.io();
        }
        return mScheduler;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Timber.e("########## onLowMemory ##########");
    }
}
