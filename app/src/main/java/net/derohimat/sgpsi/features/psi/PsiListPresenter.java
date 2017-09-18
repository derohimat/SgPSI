package net.derohimat.sgpsi.features.psi;

import android.content.Context;
import android.support.annotation.Nullable;

import net.derohimat.baseapp.presenter.BasePresenter;
import net.derohimat.sgpsi.BaseApplication;
import net.derohimat.sgpsi.data.models.ItemsDao;
import net.derohimat.sgpsi.data.models.PsiDao;
import net.derohimat.sgpsi.data.models.PsiReadingsType;
import net.derohimat.sgpsi.data.models.ReadingDao;
import net.derohimat.sgpsi.data.models.ReadingsDao;
import net.derohimat.sgpsi.data.sources.local.PreferencesHelper;
import net.derohimat.sgpsi.data.sources.remote.ApiService;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

import static net.derohimat.sgpsi.data.models.PsiReadingsType.CO8HourMax;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.COSubIndex;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.O38HourMax;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.O3SubIndex;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.PM10Daily;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.PM10SubIndex;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.PM25Daily;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.PM25SubIndex;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.PSIDaily;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.SO2Daily;

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

    void getData(boolean refresh) {
        mView.showProgress();
        if (mSubscription != null) mSubscription.unsubscribe();

        if (refresh) {
            mSubscription = mApiService.getPsi()
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
                            saveToLocal();
                        }
                    });
        } else {
            getFromLocal();
        }
        mView.hideProgress();
    }

    private void getFromLocal() {
        mData = mRealm.where(PsiDao.class).findFirst();

        if (mData == null) {
            getData(true);
        } else {
            mView.showData(mData);
        }
    }

    @Nullable
    public static ReadingDao filterReading(@PsiReadingsType int readingType, ItemsDao itemsDao) {
        ReadingsDao readingsDao = itemsDao.getReadings();
        if (readingsDao == null) {
            return null;
        }

        switch (readingType) {
            case O3SubIndex:
                return readingsDao.getO3SubIndex();
            case PM10Daily:
                return readingsDao.getPm10Daily();
            case PM10SubIndex:
                return readingsDao.getPm10SubIndex();
            case COSubIndex:
                return readingsDao.getCoSubIndex();
            case PM25Daily:
                return readingsDao.getPm25Daily();
            case CO8HourMax:
                return readingsDao.getCoEightHourMax();
            case SO2Daily:
                return readingsDao.getSo2Daily();
            case PM25SubIndex:
                return readingsDao.getPm25SubIndex();
            case PSIDaily:
                return readingsDao.getPsiDaily();
            case O38HourMax:
                return readingsDao.getO3EightHourMax();
        }

        return null;
    }

    private void saveToLocal() {
        if (!mRealm.isInTransaction()) {
            mRealm.beginTransaction();
        }

        mRealm.copyToRealmOrUpdate(mData);
        mPreferencesHelper.setRecipeListSynced(true);
    }

    void closeRealm() {
        mRealm.close();
    }
}