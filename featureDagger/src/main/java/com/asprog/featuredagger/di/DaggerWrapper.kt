package com.asprog.featuredagger.di


/*
object DaggerWrapper {
    private var mComponent: ChatComponent? = null
    val component: ChatComponent?
        get() {
            if (mComponent == null) {
                initComponent()
            }
            return mComponent
        }

    private fun initComponent() {
        mComponent = DaggerChatComponent
            .builder()
            .build()
    }
}*/


object DaggerWrapper {
    lateinit var mComponent: ChatComponent
}
