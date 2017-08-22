package br.com.conference.presentation.myaccount

import br.com.conference.domain.myaccount.MyAccountContract.*
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MyAccountPresenter@Inject constructor(private val view: IView,
                                            private val mainScheduler: Scheduler,
                                            private val ioScheduler: Scheduler,
                                            private val interactor: IInteractor): IPresenter {

    private val disposable = CompositeDisposable()

    override fun onViewReady() {
        disposable.add(requestAccount())
    }

    private fun requestAccount(): Disposable {
        return interactor.requestAccount()
                .subscribeOn(mainScheduler)
                .observeOn(ioScheduler)
                .subscribe({
                    view.showAccount(it)
                }, {
                    view.showError()
                })
    }

    override fun onViewDestroy() {
        disposable.let {
            it.clear()
        }
    }
}