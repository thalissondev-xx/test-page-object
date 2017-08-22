package br.com.conference.data.createaccount.service

import android.content.SharedPreferences
import br.com.conference.domain.createaccount.model.AccountData
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject

class CreateAccountServiceLocalImpl @Inject constructor(private val shared: SharedPreferences,
                                                        private val gson: Gson): CreateAccountServiceLocal {

    private val SHARE_PREFERENCES_KEY = "account"

    override fun save(data: AccountData): Single<Boolean> {
        return Single.just(shared.edit()
                .putString(SHARE_PREFERENCES_KEY, gson.toJson(data))
                .commit())
    }
}