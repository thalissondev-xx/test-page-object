package br.com.conference.presentation.createaccount.di

import android.content.Context
import android.content.SharedPreferences
import br.com.conference.data.createaccount.CreateAccountRepository
import br.com.conference.data.createaccount.service.CreateAccountServiceLocal
import br.com.conference.data.createaccount.service.CreateAccountServiceLocalImpl
import br.com.conference.domain.createaccount.CreateAccountContract.*
import br.com.conference.domain.createaccount.CreateAccountInteractor
import br.com.conference.presentation.createaccount.CreateAccountActivity
import br.com.conference.presentation.createaccount.CreateAccountPresenter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class CreateAccountModule(private val view: CreateAccountActivity) {

    @Provides
    @Singleton
    fun provideView(): IView {
        return view
    }

    @Provides
    @Singleton
    fun providePresenter(interactor: CreateAccountInteractor): IPresenter {
        return CreateAccountPresenter(
                view, Schedulers.newThread(), AndroidSchedulers.mainThread(), interactor)
    }

    @Provides
    @Singleton
    fun provideInteractor(interactor: CreateAccountInteractor): IInteractor {
        return interactor
    }

    @Provides
    @Singleton
    fun provideRepository(repository: CreateAccountRepository): IRepository {
        return repository
    }

    @Provides
    @Singleton
    fun provideRepositoryLocal(local: CreateAccountServiceLocalImpl): CreateAccountServiceLocal {
        return local
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideSharePreferences(): SharedPreferences {
        return view.getSharedPreferences("br.com.conference", Context.MODE_PRIVATE)
    }
}