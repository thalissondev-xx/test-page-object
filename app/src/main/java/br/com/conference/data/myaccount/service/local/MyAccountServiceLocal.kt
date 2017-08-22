package br.com.conference.data.myaccount.service.local

import android.content.SharedPreferences
import br.com.conference.share.model.AccountData
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject

class MyAccountServiceLocal @Inject constructor(private val shared: SharedPreferences,
                                                private val gson: Gson): MyAccountService {

    private val SHARE_PREFERENCES_KEY = "account"

    override fun getAccount(): Single<AccountData> {
        return Single.just(gson.fromJson(
                shared.getString(SHARE_PREFERENCES_KEY, ""), AccountData::class.java))
    }
}