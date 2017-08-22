package br.com.conference.domain.createaccount

import br.com.conference.domain.createaccount.model.AccountData
import io.reactivex.Single

interface CreateAccountContract {
    interface IView {
        fun showLoading()
        fun hideLoading()
        fun showSuccess()
        fun showError()
        fun goToMyAccount()
    }
    interface IPresenter {
        fun saveAccount(data: AccountData)
        fun onViewDestroy()
        fun goTo()
    }
    interface IInteractor {
        fun saveAccount(data: AccountData): Single<Boolean>
    }
    interface IRepository {
        fun saveAccount(data: AccountData): Single<Boolean>
    }
}