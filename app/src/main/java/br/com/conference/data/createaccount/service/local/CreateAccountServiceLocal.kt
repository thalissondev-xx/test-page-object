package br.com.conference.data.createaccount.service.local

import android.content.SharedPreferences
import br.com.conference.share.model.AccountData
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject

class CreateAccountServiceLocal @Inject constructor(private val shared: SharedPreferences,
                                                    private val gson: Gson): CreateAccountService {

    private val SHARE_PREFERENCES_KEY = "account"

    override fun saveAccount(data: AccountData): Single<Boolean> {
        return Single.just(shared.edit()
                .putString(SHARE_PREFERENCES_KEY, gson.toJson(data))
                .commit())
    }
}