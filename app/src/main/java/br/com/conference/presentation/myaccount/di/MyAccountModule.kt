package br.com.conference.presentation.myaccount.di

import br.com.conference.data.myaccount.MyAccountRepository
import br.com.conference.data.myaccount.service.local.MyAccountService
import br.com.conference.data.myaccount.service.local.MyAccountServiceLocal
import br.com.conference.domain.myaccount.MyAccountContract.*
import br.com.conference.domain.myaccount.MyAccountInteractor
import br.com.conference.presentation.myaccount.MyAccountActivity
import br.com.conference.presentation.myaccount.MyAccountPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class MyAccountModule(private val view: MyAccountActivity) {

    @Singleton
    @Provides
    fun provideView(): IView {
        return view
    }

    @Singleton
    @Provides
    fun providePresenter(interactor: MyAccountInteractor): IPresenter {
        return MyAccountPresenter(
                view, Schedulers.newThread(), AndroidSchedulers.mainThread(), interactor)
    }

    @Singleton
    @Provides
    fun provideInteractor(interactor: MyAccountInteractor): IInteractor {
        return interactor
    }

    @Singleton
    @Provides
    fun provideRepository(repository: MyAccountRepository): IRepository {
        return repository
    }

    @Singleton
    @Provides
    fun provideRepositoryLocal(service: MyAccountServiceLocal): MyAccountService {
        return service
    }
}