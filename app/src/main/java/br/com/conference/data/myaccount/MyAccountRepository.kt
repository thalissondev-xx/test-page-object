package br.com.conference.data.myaccount

import br.com.conference.data.myaccount.service.local.MyAccountService
import br.com.conference.domain.myaccount.MyAccountContract.IRepository
import br.com.conference.share.model.AccountData
import io.reactivex.Single
import javax.inject.Inject

class MyAccountRepository @Inject constructor(
        private val service: MyAccountService): IRepository {

    override fun requestAccount(): Single<AccountData> {
        return service.getAccount()
    }
}