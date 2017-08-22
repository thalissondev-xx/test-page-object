package br.com.conference.data.createaccount.service

import br.com.conference.domain.createaccount.model.AccountData
import io.reactivex.Single

interface CreateAccountServiceLocal {
    fun save(data: AccountData): Single<Boolean>
}