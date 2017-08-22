package br.com.conference.presentation.myaccount.di

import br.com.conference.presentation.myaccount.MyAccountActivity
import br.com.conference.share.di.module.GlobalModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(MyAccountModule::class, GlobalModule::class))
interface MyAccountComponent {
    fun inject(activity: MyAccountActivity): MyAccountActivity
}