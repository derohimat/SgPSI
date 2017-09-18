package net.derohimat.sgpsi.features.psi;

import android.content.Context;

import net.derohimat.baseapp.presenter.BasePresenter;
import net.derohimat.sgpsi.BaseApplication;
import net.derohimat.sgpsi.data.models.PsiDao;
import net.derohimat.sgpsi.data.sources.local.PreferencesHelper;
import net.derohimat.sgpsi.data.sources.remote.ApiService;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

public class PsiListPresenter implements BasePresenter<PsiListMvpView> {

    @Inject
    PsiListPresenter(Context context) {
        ((BaseApplication) context.getApplicationContext()).getApplicationComponent().inject(this);
    }

    @Inject ApiService mApiService;
    @Inject EventBus mEventBus;
    @Inject PreferencesHelper mPreferencesHelper;
    @Inject Realm mRealm;

    private PsiListMvpView mView;
    private Subscription mSubscription;
    private PsiDao mData;
    private BaseApplication mBaseApplication;

    @Override
    public void attachView(PsiListMvpView view) {
        mView = view;
        mBaseApplication = BaseApplication.get(mView.getContext());
    }

    @Override
    public void detachView() {
        mView = null;
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    void getData() {
        mView.showProgress();
        if (mSubscription != null) mSubscription.unsubscribe();

        mSubscription = mApiService.getPsi("2016-12-12T09:45:00", "2016-12-12")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(mBaseApplication.getSubscribeScheduler())
                .subscribe(new Subscriber<PsiDao>() {
                    @Override
                    public void onCompleted() {
                        Timber.i("Data loaded " + mData);
                        mView.showData(mData);
                    }

                    @Override
                    public void onError(Throwable error) {
                        Timber.e("Error loading Data", error);
                        mView.showError(error);
                    }

                    @Override
                    public void onNext(PsiDao response) {
                        mData = response;
                    }
                });
        mView.hideProgress();
    }

}