package br.com.conference.domain.myaccount

import br.com.conference.domain.myaccount.MyAccountContract.IInteractor
import br.com.conference.share.model.AccountData
import io.reactivex.Single
import javax.inject.Inject

class MyAccountInteractor @Inject constructor(
        private val repository: MyAccountContract.IRepository): IInteractor {

    override fun requestAccount(): Single<AccountData> {
        return repository.requestAccount()
    }
}