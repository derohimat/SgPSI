package net.derohimat.sgpsi.di.component;

import android.content.Context;

import net.derohimat.sgpsi.BaseApplication;
import net.derohimat.sgpsi.data.sources.local.PreferencesHelper;
import net.derohimat.sgpsi.data.sources.remote.ApiService;
import net.derohimat.sgpsi.di.module.ApplicationModule;
import net.derohimat.sgpsi.features.psi.PsiListPresenter;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(BaseApplication baseApplication);
    void inject(PsiListPresenter presenter);

    ApiService apiService();
    EventBus eventBus();
    Realm realm();
    PreferencesHelper prefsHelper();
    Context context();

}