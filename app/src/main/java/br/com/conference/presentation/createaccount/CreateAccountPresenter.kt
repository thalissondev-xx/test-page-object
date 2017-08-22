package br.com.conference.presentation.createaccount

import br.com.conference.domain.createaccount.CreateAccountContract.IView
import br.com.conference.domain.createaccount.CreateAccountContract.IInteractor
import br.com.conference.domain.createaccount.CreateAccountContract.IPresenter
import br.com.conference.domain.createaccount.model.AccountData
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CreateAccountPresenter @Inject constructor(private val view: IView,
                                                 private val mainScheduler: Scheduler,
                                                 private val ioSchduler: Scheduler,
                                                 private val interactor: IInteractor): IPresenter {

    private val disposable = CompositeDisposable()

    override fun saveAccount(data: AccountData) {
        disposable.add(interactor.saveAccount(data)
                .subscribeOn(mainScheduler)
                .observeOn(ioSchduler)
                .doOnSubscribe { view.showLoading() }
                .doOnSuccess { view.hideLoading() }
                .subscribe({
                    view.showSuccess()
                }, {
                    view.showError()
                }))
    }

    override fun onViewDestroy() {
        disposable.let {
            it.clear()
        }
    }

    override fun goTo() {
        view.goToMyAccount()
    }
}