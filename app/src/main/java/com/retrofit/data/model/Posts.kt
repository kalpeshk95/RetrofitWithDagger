package com.retrofit.data.model

import com.google.gson.annotations.SerializedName

class Posts {

    @SerializedName("userId")
    var userId: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("title")
    var title: String? = null

    @SerializedName("body")
    var body: String? = null

    override fun toString(): String {
        return "Posts{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\''.toString() +
                ", body='" + body + '\''.toString() +
                '}'.toString()
    }
}
