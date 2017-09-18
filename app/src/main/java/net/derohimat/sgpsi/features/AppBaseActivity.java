package net.derohimat.sgpsi.features;

import android.os.Bundle;
import android.view.LayoutInflater;

import net.derohimat.baseapp.ui.BaseActivity;
import net.derohimat.sgpsi.BaseApplication;
import net.derohimat.sgpsi.di.component.ActivityComponent;
import net.derohimat.sgpsi.di.component.DaggerActivityComponent;

import butterknife.ButterKnife;
import timber.log.Timber;

public abstract class AppBaseActivity extends BaseActivity {

    private ActivityComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceLayout());
        ButterKnife.bind(this);
        Timber.tag(getClass().getSimpleName());
        mInflater = LayoutInflater.from(mContext);
        mComponent = DaggerActivityComponent.builder().applicationComponent(getApp().getApplicationComponent()).build();
        onViewReady(savedInstanceState);
    }

    protected ActivityComponent getComponent() {
        return mComponent;
    }

    protected BaseApplication getApp() {
        return (BaseApplication) getApplicationContext();
    }

}
