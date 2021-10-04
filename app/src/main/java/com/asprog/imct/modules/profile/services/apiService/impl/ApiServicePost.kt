package com.asprog.imct.modules.profile.services.apiService.impl

import com.asprog.imct.base.LocalTryExecuteWithResponse.executeWithResponse
import com.asprog.imct.base.ResponseResult
import com.asprog.imct.base.Result422
import com.asprog.imct.base.responseCheck
import com.asprog.imct.modules.profile.data.models.UserContactsModel
import com.asprog.imct.modules.profile.data.request.UserContactEmailRequest
import com.asprog.imct.modules.profile.data.request.UserContactPhoneRequest
import com.asprog.imct.modules.profile.data.request.UserContactRequest
import com.asprog.imct.modules.profile.services.api.ApiProfile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

interface ApiServicePost {

    val api: ApiProfile

    suspend fun updateUserContacts(userContact: UserContactsModel): ResponseResult<Boolean> {
        return withContext(Dispatchers.IO) {
            executeWithResponse {
                api.updateUserContacts(
                    UserContactRequest(
                        email = UserContactEmailRequest(
                            confirmed = userContact.email.confirmedContactEmail,
                            email = userContact.email.contactEmail,
                            notifyMailFull = userContact.email.notifyMailFull,
                            notifyMailShort = userContact.email.notifyMailShort,
                        ),
                        phone = UserContactPhoneRequest(
                            confirmed = userContact.phone.confirmedContactPhone,
                            phone = userContact.phone.contactPhone,
                            notifySmsFull = userContact.phone.notifySmsFull,
                            notifySmsShort = userContact.phone.notifySmsShort,
                        ),
                    )
                )
                    .responseCheck()
                    .body() != null
            }
        }
    }

    suspend fun checkCode(emailOrPhone: String, code: String): ResponseResult<Boolean> {
        return withContext(Dispatchers.IO) {
            executeWithResponse {
                api.checkCode(
                    configGroupCode = "update",
                    contact = emailOrPhone.replace(" ", ""),
                    code = code
                )
                    .responseCheck()
                    .body()
                    ?.getAsJsonPrimitive("confirmedSuccess")?.asBoolean ?: false
            }
        }
    }

    suspend fun sendCode(emailOrPhone: String): ResponseResult<Boolean> {
        return withContext(Dispatchers.IO) {
            executeWithResponse {
                api.sendCode(
                    configGroupCode = "update",
                    contact = emailOrPhone.replace(" ", ""),
                )
                    .responseCheck { _, body ->
                        JSONObject(body).apply {
                            if (!getBoolean("sentSuccess")) throw Result422(getString("errorMsg"))
                        }
                    }
                    .body()
                    ?.getAsJsonPrimitive("sentSuccess")?.asBoolean ?: false
            }
        }
    }
}