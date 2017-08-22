package br.com.conference.domain.createaccount

import br.com.conference.share.model.AccountData
import br.com.conference.domain.createaccount.CreateAccountContract.IInteractor
import br.com.conference.domain.createaccount.CreateAccountContract.IRepository
import io.reactivex.Single
import javax.inject.Inject

class CreateAccountInteractor @Inject constructor(
        private val repository: IRepository) : IInteractor {

    override fun saveAccount(data: AccountData): Single<Boolean> {
        return repository.saveAccount(data)
    }
}