package net.derohimat.sgpsi.features.psi;

import net.derohimat.sgpsi.data.models.PsiDao;
import net.derohimat.sgpsi.features.MvpView;

interface PsiListMvpView extends MvpView {

    void setUpSpiner();

    void setUpPresenter();

    void setUpAdapter();

    void setUpRecyclerView();

    void showData(PsiDao data);

    void showError(Throwable throwable);

    void showProgress();

    void hideProgress();
}