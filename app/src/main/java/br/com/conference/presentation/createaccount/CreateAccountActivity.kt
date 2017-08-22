package br.com.conference.presentation.createaccount

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.conference.R
import br.com.conference.domain.createaccount.CreateAccountContract.IPresenter
import br.com.conference.domain.createaccount.CreateAccountContract.IView
import br.com.conference.domain.createaccount.model.AccountData
import br.com.conference.presentation.createaccount.di.CreateAccountModule
import br.com.conference.presentation.createaccount.di.DaggerCreateAccountComponent
import br.com.conference.presentation.myaccount.MyAccountActivity
import kotlinx.android.synthetic.main.activity_create_account.*
import javax.inject.Inject

class CreateAccountActivity: AppCompatActivity(), IView {

    @Inject
    lateinit var presenter: IPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        setupListeners()
    }

    private fun inject() {
        DaggerCreateAccountComponent
                .builder()
                .createAccountModule(CreateAccountModule(this))
                .build()
                .inject(this)
    }

    private fun setupListeners() {
        btnCreate.setOnClickListener({
            getValuesAndRequest()
        })
    }

    private fun getValuesAndRequest() {
        presenter.saveAccount(
                AccountData(
                    etFirstName.text.toString(),
                    etLastName.text.toString(),
                    etEmail.text.toString(),
                    etPassword.text.toString()
                ))
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }

    override fun showSuccess() {
        showCustomAlert(R.string.alert_message_success)
    }

    override fun showError() {
        showCustomAlert(R.string.alert_message_error)
    }

    private fun showCustomAlert(msg: Int) {
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle(resources.getString(R.string.alert_title))
        alertBuilder.setMessage(resources.getString(msg))

        alertBuilder.setPositiveButton(resources.getString(R.string.alert_btn_ok), {
            _, _ -> presenter.goTo()
        })

        alertBuilder.create().show()
    }

    override fun goToMyAccount() {
        startActivity(Intent(this, MyAccountActivity::class.java))
    }

    override fun onDestroy() {
        presenter.onViewDestroy()
    }
}