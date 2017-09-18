package net.derohimat.sgpsi.di.component;

import net.derohimat.sgpsi.di.ActivityScope;
import net.derohimat.sgpsi.features.psi.PsiListActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
public interface ActivityComponent extends ApplicationComponent {

    void inject(PsiListActivity activity);
}