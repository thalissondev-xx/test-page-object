package br.com.conference.data.createaccount

import br.com.conference.data.createaccount.service.CreateAccountServiceLocal
import br.com.conference.domain.createaccount.CreateAccountContract.IRepository
import br.com.conference.domain.createaccount.model.AccountData
import io.reactivex.Single
import javax.inject.Inject

class CreateAccountRepository @Inject constructor(
        private val service: CreateAccountServiceLocal): IRepository {

    override fun saveAccount(data: AccountData): Single<Boolean> {
        return service.save(data)
    }
}