package br.com.conference.data.createaccount

import br.com.conference.data.createaccount.service.local.CreateAccountService
import br.com.conference.domain.createaccount.CreateAccountContract.IRepository
import br.com.conference.share.model.AccountData
import io.reactivex.Single
import javax.inject.Inject

class CreateAccountRepository @Inject constructor(
        private val service: CreateAccountService): IRepository {

    override fun saveAccount(data: AccountData): Single<Boolean> {
        return service.saveAccount(data)
    }
}