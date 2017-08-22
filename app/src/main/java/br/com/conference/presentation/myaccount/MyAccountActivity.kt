package br.com.conference.presentation.myaccount

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import br.com.conference.R
import br.com.conference.domain.myaccount.MyAccountContract.IPresenter
import br.com.conference.domain.myaccount.MyAccountContract.IView
import br.com.conference.presentation.myaccount.di.DaggerMyAccountComponent
import br.com.conference.presentation.myaccount.di.MyAccountModule
import br.com.conference.share.di.module.GlobalModule
import br.com.conference.share.model.AccountData
import kotlinx.android.synthetic.main.activity_my_account.*
import javax.inject.Inject

class MyAccountActivity: AppCompatActivity(), IView {

    @Inject
    lateinit var presenter: IPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_account)

        presenter.onViewReady()
    }

    private fun inject() {
        DaggerMyAccountComponent
                .builder()
                .myAccountModule(MyAccountModule(this))
                .globalModule(GlobalModule(this))
                .build()
                .inject(this)
    }

    override fun showError() {
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle(resources.getString(R.string.alert_title))
        alertBuilder.setMessage(resources.getString(R.string.alert_message_error))
        alertBuilder.setPositiveButton(resources.getString(R.string.alert_btn_ok), null)
        alertBuilder.create().show()
    }

    override fun showAccount(data: AccountData) {
        tvFirstName.text = data.firstName
        tvLastName.text = data.lastName
        tvEmail.text = data.email
        tvPassword.text = data.password
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroy()
    }
}