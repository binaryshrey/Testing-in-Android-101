package dev.shreyansh.testinginandroid.utils

import android.content.Context

class ResourceComparer {

    fun isResourceEqual(context: Context, resID: Int, string: String): Boolean{
        return context.getString(resID) == string
    }

}