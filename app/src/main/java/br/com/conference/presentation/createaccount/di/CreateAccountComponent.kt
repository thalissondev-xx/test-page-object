package br.com.conference.presentation.createaccount.di

import br.com.conference.presentation.createaccount.CreateAccountActivity
import br.com.conference.share.di.module.GlobalModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(CreateAccountModule::class, GlobalModule::class))
interface CreateAccountComponent {
    fun inject(activity: CreateAccountActivity): CreateAccountActivity
}