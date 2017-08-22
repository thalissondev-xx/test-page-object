package br.com.conference.data.myaccount.service.local

import br.com.conference.share.model.AccountData
import io.reactivex.Single

interface MyAccountService {
    fun getAccount(): Single<AccountData>
}