package br.com.conference.data.createaccount.service.local

import br.com.conference.share.model.AccountData
import io.reactivex.Single

interface CreateAccountService {
    fun saveAccount(data: AccountData): Single<Boolean>
}