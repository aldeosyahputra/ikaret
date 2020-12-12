package com.ikaret.app.ui.auth

import android.content.Context
import com.ikaret.app.data.model.ActionState
import com.ikaret.app.data.repository.AuthRepository
import kotlinx.coroutines.*

object iKaretAuth {

    fun logout(context: Context,callback: ((ActionState<Boolean>) -> Unit)? = null){
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main){
                if (callback != null)callback.invoke(resp)
        }
        }
    }
}