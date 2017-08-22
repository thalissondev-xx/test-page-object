package br.com.conference.domain.myaccount

import br.com.conference.share.model.AccountData
import io.reactivex.Single

interface MyAccountContract {
    interface IView {
        fun showError()
        fun showAccount(data: AccountData)
    }
    interface IPresenter {
        fun onViewReady()
        fun onViewDestroy()
    }
    interface IInteractor {
        fun requestAccount(): Single<AccountData>
    }
    interface IRepository {
        fun requestAccount(): Single<AccountData>
    }
}