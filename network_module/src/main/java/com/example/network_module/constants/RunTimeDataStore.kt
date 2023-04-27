package com.example.network_module.constants

sealed class RunTimeDataStore(var value: String) {

    companion object {
        // push notification
        const val USERNAME          = ""
        const val USERNAME_MFI      = ""
        const val PUSH_ID           = ""
        const val ACTION_TYPE       = ""
        const val ACTION_ID         = ""
        const val ACTION_URL        = ""
        const val NOTIFICATION_PUSH = ""
        const val FCM_NOTIFICATION_CLICK = ""
        const val MESSAGE           = ""

        const val USER_AGENT        = ""
        // MG
        const val BASE_URL          = ""
        const val WEB_BASE_URL_KH      = ""
        const val WEB_BASE_URL_VN      = ""

        const val BASE_URL_KH          = ""
        const val BASE_URL_VN          = ""

        // Login Info
        const val LOGIN_TOKEN       = ""
        const val JSESSIONID        = ""
        const val USER_ID           = ""
        const val NTNL_CD           = ""

        const val TAB_TYPE          = ""

        const val DEV_MG_URL       = ""
        const val PROD_MG_URL      = ""

        const val BASE_COUNTRY      = ""
        const val COUNTRY_AREA_URL  = ""
        const val TOKEN             = ""
        const val WARNING           = ""
        const val C_PROGRAM_VERSION = ""
        const val ERROR             = ""
        const val SUCCESS           = ""
    }
    object Success: RunTimeDataStore(SUCCESS)

    object Warning: RunTimeDataStore(WARNING)

    object Error: RunTimeDataStore(ERROR)

    object Username: RunTimeDataStore(USERNAME)

    object UsernameMFI: RunTimeDataStore(USERNAME_MFI)

    object PushId: RunTimeDataStore(PUSH_ID)

    object ActionType: RunTimeDataStore(ACTION_TYPE)

    object ActionId: RunTimeDataStore(ACTION_ID)

    object ActionUrl: RunTimeDataStore(ACTION_URL)

    object Message: RunTimeDataStore(MESSAGE)

    object BaseUrlKh: RunTimeDataStore(BASE_URL_KH)

    object BaseUrlVn: RunTimeDataStore(BASE_URL_VN)

    object WebBaseURLKh: RunTimeDataStore(WEB_BASE_URL_KH)

    object WebBaseURLVn: RunTimeDataStore(WEB_BASE_URL_VN)

    object LoginToken: RunTimeDataStore(LOGIN_TOKEN)

    object JsessionId: RunTimeDataStore(JSESSIONID)

    object UserId: RunTimeDataStore(USER_ID)

    object NtnlCd: RunTimeDataStore(NTNL_CD)

    object UserAgent: RunTimeDataStore(USER_AGENT)

    object TabType: RunTimeDataStore(TAB_TYPE)

    object NotificationPush: RunTimeDataStore(NOTIFICATION_PUSH)

    object FcmNotificationClick: RunTimeDataStore(FCM_NOTIFICATION_CLICK)

    object DevMgUrl: RunTimeDataStore(DEV_MG_URL)

    object ProdMgUrl: RunTimeDataStore(PROD_MG_URL)

    object BaseCountry: RunTimeDataStore(BASE_COUNTRY)

    object CountryAreaUrl: RunTimeDataStore(COUNTRY_AREA_URL)

    object CProgramVersion : RunTimeDataStore(C_PROGRAM_VERSION)
}

sealed class Web(var value: String){
    companion object{
        const val CURRENT_PAGE      = "0"
        const val WEB_POSITION      = "0"
    }
    object WebPosition: Web(WEB_POSITION)
    object CurrentPage: Web(CURRENT_PAGE)
}

sealed class LoginInfo(var value: String){
    companion object {
        const val DEVICE_ID = ""
    }
    object DeviceId: LoginInfo(DEVICE_ID)
}

sealed class DataStore(var value: Boolean) {

    companion object {
        const val IN_REVIEW_MODE   = false

        const val ON_RECEIPT_RELOAD = false

        const val ON_NOTI_RELOAD = false

        const val SHOULD_RELOAD    = false

        const val RECEIPT_CLICK    = false

        const val NOTI_CLLICK      = false
    }
    object InReviewMode: DataStore(IN_REVIEW_MODE)

    object OnReceiptReload: DataStore(ON_RECEIPT_RELOAD)

    object OnNotiReload: DataStore(ON_NOTI_RELOAD)

    object ShouldReload: DataStore(SHOULD_RELOAD)

    object ReceiptClick: DataStore(RECEIPT_CLICK)

    object NotiClick: DataStore(NOTI_CLLICK)

}

sealed class SnackBarAction(var value: Boolean) {

    companion object {
        const val SHOW_UPDATE_SUCCESS       = false
        const val SHOW_DELETE_SUCCESS       = false
        const val SHOW_SUBMIT_SUCCESS       = false
        const val SHOW_PHOTO_SAVED_SUCCESS  = false
    }

    object ShowUpdateSuccess: DataStore(SHOW_UPDATE_SUCCESS)

    object ShowDeleteSuccess: DataStore(SHOW_DELETE_SUCCESS)

    object ShowSubmitSuccess: DataStore(SHOW_SUBMIT_SUCCESS)

    object ShowPhotoSavedSuccess: DataStore(SHOW_PHOTO_SAVED_SUCCESS)
}